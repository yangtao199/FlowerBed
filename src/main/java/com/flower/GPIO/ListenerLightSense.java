package com.flower.GPIO;

import com.flower.flowerCulture.service.LedtimeslotService;
import com.flower.flowerCulture.service.LightingService;
import com.flower.flowerCulture.service.impl.ControlpanelServiceImpl;
import com.flower.util.SpringUtil;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description TODO
 * @Author yangtao
 * @Date 2021/2/8 0008 14:22
 * 光感应
 */
@Component
public class ListenerLightSense implements CommandLineRunner, Ordered {
    public static Date openCloseLED;
    //红外监控
    public void ListenerLightSense(){
        //光感GPIO
        final GpioPinDigitalInput gpioLightSense = ControlGpio.MapGpioPinDigitalInput.get("LightSense");
        //灯光GPIO
        final GpioPinDigitalOutput gpioLED = ControlGpio.MapGpioPinDigitalOutput.get("LED");


        System.out.println("光感应监控"+gpioLightSense);
        gpioLightSense.setShutdownOptions(true);
        gpioLightSense.addListener(new GpioPinListenerDigital() {
            @SneakyThrows
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                LedtimeslotService ledtimeslotService = (LedtimeslotService) SpringUtil.getBean(LedtimeslotService.class);
                if("1".equals(ControlpanelServiceImpl.hardwareState.get("Lighting")))
                    return;
                if("HIGH".equals(event.getState().getName())){
                    System.out.println("开灯");
                    gpioLED.high();
                    float minutes = (float) ((new Date().getTime() - openCloseLED.getTime()) / (1000 * 60));
                    System.out.println("关灯时间（分）：----"+minutes);
                    if(minutes>0)
                        ledtimeslotService.inserttimeslot("0",minutes);
                    openCloseLED =  new Date();
                }
                if("LOW".equals(event.getState().getName())){
                    System.out.println("关灯");
                    gpioLED.low();
                    float minutes = (float) ((new Date().getTime() - openCloseLED.getTime()) / (1000 * 60));
                    System.out.println("关灯时间（分）：----"+minutes);
                    if(minutes>0)
                        ledtimeslotService.inserttimeslot("1",minutes);
                    openCloseLED =  new Date();
                }
                LightingService lightingService = (LightingService) SpringUtil.getBean(LightingService.class);
                lightingService.insertLightingService(event.getState().getName());
            }

        });
    }
    static{
        openCloseLED = new Date();
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始监听光感");
        ListenerLightSense();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
