package com.flower.GPIO;

import com.flower.flowerCulture.service.InfraredmonitoringService;
import com.flower.util.GetImage;
import com.flower.util.SpringUtil;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Date;

/**
 * @Description TODO
 * @Author yangtao
 * @Date 2021/2/8 0008 14:22
 * 红外感应
 */
@Component
public class ListenerInfraredInduction implements CommandLineRunner, Ordered {
    //红外监控
    public void ListenerInfraredInduction(){
        final GpioPinDigitalInput gpioInfraredInduction = ControlGpio.MapGpioPinDigitalInput.get("InfraredInduction");
        System.out.println("红外监控gpioInfraredInduction"+gpioInfraredInduction);
        gpioInfraredInduction.setShutdownOptions(true);
        gpioInfraredInduction.addListener(new GpioPinListenerDigital() {
            @SneakyThrows
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println("变化了！");
                if(event.getState().getName().equals("HIGH")){
                    InfraredmonitoringService infraredmonitoringService = (InfraredmonitoringService) SpringUtil.getBean(InfraredmonitoringService.class);
                    //抓拍图像（base64）
                    //String savePath,String fileUrl
                    /*String fileUrl = "http://172.18.177.2:8080/?action=snapshot";
			        String savePath = "d:\\test.jpg";*/
                    //String savePath,String fileUrl
                    String pictturename = getTimestamp(new Date())+".jpg";
                    GetImage.getPicture("/opt/pictures/"+pictturename,"http://127.0.0.1:8080/?action=snapshot");
                    infraredmonitoringService.insertInfraredmonitoring(pictturename);
                }

                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+";   source=	"+event.getSource());
               /* while(true) {
                    Thread.sleep(500);
                }*/
            }

        });
    }
    public static Long getTimestamp(Date date){
        if (null == date) {
            return (long) 0;
        }
        String timestamp = String.valueOf(date.getTime());
        return Long.valueOf(timestamp);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始监听红外");
        ListenerInfraredInduction();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
