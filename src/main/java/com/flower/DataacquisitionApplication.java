package com.flower;

import com.flower.GPIO.ControlGpio;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.flower.flowerCulture.mapper")
public class DataacquisitionApplication{

    public static void main(String[] args) throws InterruptedException {
        //GpioController gpio  = GpioFactory.getInstance();
       // gpio.shutdown();
       // gpio.unprovisionPin(pin);
        SpringApplication.run(DataacquisitionApplication.class, args);

     /*   final GpioPinDigitalInput myButton = GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN);
        myButton.setShutdownOptions(true);
        myButton.addListener(new GpioPinListenerDigital() {
            @SneakyThrows
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println("变化了！");
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+";   source=	"+event.getSource());
               *//* while(true) {
                    Thread.sleep(500);
                }*//*
            }
        });*/

    }

}
