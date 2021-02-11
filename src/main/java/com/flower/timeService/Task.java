package com.flower.timeService;

import com.flower.GPIO.ControlGpio;
import com.flower.GPIO.ListenerTemperatureHumidity;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;


/**
 *  @title 定时任务
 *  @Desc  用于定时的执行某一任务
 *  @author yangtao
 *  @Date 2020-03-25 13:31
 *  
 */
@Component
@Configurable
@EnableScheduling
//@EnableAsync
public class Task extends ControlGpio{
    HashMap<String,GpioPinDigitalOutput> pin = super.getfinalpin();

    @Scheduled(cron = "0/10 * * * * ?")//10s执行一次
    @Scheduled(cron = "0 */1 * * * ? ")//1分钟执行一次
    //@Scheduled(cron = "0 10 21 ? * * ")//每 15：48 查询最新数据
    //@Scheduled(cron = "0 00 * * * ?")//整点执行





    public void bandian() throws Exception {
        System.out.println("开始执行");

        //监听温度湿度
        ListenerTemperatureHumidity TH = new ListenerTemperatureHumidity();
        TH.getTemperatureHumidity(pin);
       /* System.out.println("一分钟执行一次");
      //  GpioController gpio = super.getGPIO();
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(1000);

        // turn off gpio pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(1000);

        // toggle the current state of gpio pin #01 (should turn on)
        pin.high();
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(1000);

        // toggle the current state of gpio pin #01  (should turn off)
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(1000);

        // turn on gpio pin #01 for 1 second and then off
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin.pulse(1000, true); // set second argument to 'true' use a blocking call

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        //gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");*/



        // create and register gpio pin listener


    }
}

