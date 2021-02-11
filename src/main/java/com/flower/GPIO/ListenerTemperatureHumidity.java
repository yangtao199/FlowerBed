package com.flower.GPIO;

import com.flower.conf.readFile.readFile;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import java.util.HashMap;

/**
 * 监听温度湿度（C中拿到的值）
 */
public class ListenerTemperatureHumidity{

    public void getTemperatureHumidity(HashMap<String,GpioPinDigitalOutput> pin){
        System.out.println("--------------GPIO信息");
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
        if(28.4<temperature){
            pinFan.high();
            System.out.println("开启风扇");
        }else{
            pinFan.low();
            System.out.println("关闭风扇");
        }
        if(10>=humidity){
            pinAtomizer.high();
            System.out.println("打开雾化器");
        }else{
            pinAtomizer.low();
            System.out.println("关闭雾化器");
        }

    }

}
