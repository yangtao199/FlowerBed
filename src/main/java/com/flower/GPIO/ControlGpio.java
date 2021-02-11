package com.flower.GPIO;/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  ControlGpioExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 */
import com.pi4j.io.gpio.*;

import java.util.HashMap;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Robert Savage
 */
public class ControlGpio {
    public static  HashMap<String, GpioPinDigitalInput> MapGpioPinDigitalInput=new HashMap<>();//GPIO输入
    //ping 初始化
    public final HashMap<String,GpioPinDigitalOutput> getfinalpin(){
        GpioController gpio  = GpioFactory.getInstance();
        HashMap<String,GpioPinDigitalOutput> MapGpioPinDigitalOutput=new HashMap<>();
        //风扇
        MapGpioPinDigitalOutput.put("fan",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyFan", PinState.HIGH));
        //雾化器
        MapGpioPinDigitalOutput.put("atomizer",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyAtomizer", PinState.HIGH));
        //灯光
        MapGpioPinDigitalOutput.put("LED",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.HIGH));

        return MapGpioPinDigitalOutput;
    }
    static{
        GpioController gpio  = GpioFactory.getInstance();
        //红外感应
        MapGpioPinDigitalInput.put("InfraredInduction",gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN));
    }


/*    public static void led() throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // turn off gpio pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01 (should turn on)
        pin.toggle();
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01  (should turn off)
        pin.toggle();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000);

        // turn on gpio pin #01 for 1 second and then off
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin.pulse(1000, true); // set second argument to 'true' use a blocking call

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }*/
}