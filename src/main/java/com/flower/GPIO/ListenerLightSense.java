package com.flower.GPIO;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author yangtao
 * @Date 2021/2/8 0008 14:22
 * 光感应
 */
@Component
public class ListenerLightSense implements CommandLineRunner, Ordered {
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
                if("HIGH".equals(event.getState().getName())){
                    System.out.println("开灯");
                    gpioLED.high();
                }
                if("LOW".equals(event.getState().getName())){
                    System.out.println("关灯");
                    gpioLED.low();
                }
               // System.out.println("光线发生变化了！"+event.getState());
               // System.out.println(" --> 光GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+";   source=	"+event.getSource());
               /* while(true) {
                    Thread.sleep(500);
                }*/
            }

        });
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
