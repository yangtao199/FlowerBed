package com.flower.GPIO;

import com.flower.conf.readFile.readFile;
import com.flower.flowerCulture.mapper.SensorMapper;
import com.flower.flowerCulture.service.SensorService;
import com.flower.util.SpringUtil;
import com.flower.webSocket.OneToManyWebSocket;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * 监听温度湿度（C中拿到的值）
 */
public class ListenerTemperatureHumidity{
    SensorService sensorService = (SensorService) SpringUtil.getBean(SensorService.class);
    //灯光GPIO
    final GpioPinDigitalOutput gpioLED = ControlGpio.MapGpioPinDigitalOutput.get("LED");
    final GpioPinDigitalOutput fan = ControlGpio.MapGpioPinDigitalOutput.get("fan");
    final GpioPinDigitalOutput atomizer = ControlGpio.MapGpioPinDigitalOutput.get("atomizer");
    public void getTemperatureHumidity(HashMap<String,GpioPinDigitalOutput> pin){
        //System.out.println("--------------GPIO信息");
        //风扇GPIO
        GpioPinDigitalOutput pinFan = pin.get("fan");
        //雾化器GPIO
        GpioPinDigitalOutput pinAtomizer = pin.get("atomizer");

        readFile rf = new readFile();
        String contents = readFile.readFileContent("/opt/data.txt");
        System.out.println("读取传感器数值"+contents);
        String[] strArray = contents.split(",");
        //湿度
        float humidity =  Float.parseFloat(strArray[0].split(":")[1]);
        //温度
        float temperature =  Float.parseFloat(strArray[1].split(":")[1]);
        System.out.println("温度"+temperature);
        sensorService.insertTemperature(temperature,humidity);
        OneToManyWebSocket oneToManyWebSocket = new OneToManyWebSocket();
        gpioLED.getPin();
        gpioLED.getState();
        oneToManyWebSocket.sendMessageALL("湿度："+humidity+"---温度"+temperature+"--灯光："+gpioLED.getState()+"---风扇："+fan.getState()+"----雾化器："+atomizer.getState());
        if(28.4<temperature){
            pinFan.high();
            //System.out.println("开启风扇");
        }else{
            pinFan.low();
           // System.out.println("关闭风扇");
        }
        if(10>=humidity){
            pinAtomizer.high();
            //System.out.println("打开雾化器");
        }else{
            pinAtomizer.low();
            //System.out.println("关闭雾化器");
        }

    }
    public void getTemperatureHumidityTest(){
        sensorService.insertTemperature(22,44);
    }

}
