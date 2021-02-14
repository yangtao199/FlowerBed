package com.flower.GPIO;

import com.pi4j.io.gpio.*;

import java.util.HashMap;


public class ControlGpio {
    public static  HashMap<String, GpioPinDigitalInput> MapGpioPinDigitalInput=new HashMap<>();//GPIO输入
    public static  HashMap<String, GpioPinDigitalOutput> MapGpioPinDigitalOutput=new HashMap<>();//GPIO输出
    static{
        GpioController gpio  = GpioFactory.getInstance();
        //红外感应
        MapGpioPinDigitalInput.put("InfraredInduction",gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN));
        //光感
        MapGpioPinDigitalInput.put("LightSense",gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN));
        //灯光输出
        MapGpioPinDigitalOutput.put("LED",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW));
        //风扇
        MapGpioPinDigitalOutput.put("fan",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyFan", PinState.HIGH));
        //雾化器
        MapGpioPinDigitalOutput.put("atomizer",gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyAtomizer", PinState.HIGH));


    }
}