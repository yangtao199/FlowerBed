package com.flower.flowerCulture.service.impl;

import com.flower.GPIO.ControlGpio;
import com.flower.flowerCulture.mapper.LedtimeslotMapper;
import com.flower.flowerCulture.model.Controlpanel;
import com.flower.flowerCulture.mapper.ControlpanelMapper;
import com.flower.flowerCulture.model.Ledtimeslot;
import com.flower.flowerCulture.service.ControlpanelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.flowerCulture.service.LedtimeslotService;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-14
 */
@Service
public class ControlpanelServiceImpl extends ServiceImpl<ControlpanelMapper, Controlpanel> implements ControlpanelService {

    @Autowired
    private LedtimeslotMapper ledtimeslotMapper;
    @Autowired
    private ControlpanelMapper controlpanelMapper;
    public static Date PeopleOpenCloseLED;
    public static HashMap<String, String> hardwareState=new HashMap<>();//保存灯雾化器、电扇、水泵的人为控制状态
    static {
        PeopleOpenCloseLED = new Date();
    }
    //灯光
    final GpioPinDigitalOutput gpioLED = ControlGpio.MapGpioPinDigitalOutput.get("LED");
    //风扇
    final GpioPinDigitalOutput fan = ControlGpio.MapGpioPinDigitalOutput.get("fan");
    //雾化器
    final GpioPinDigitalOutput atomizer = ControlGpio.MapGpioPinDigitalOutput.get("atomizer");
    /**
     * 灯光
     * @param LowHigh
     * @return
     */
    @Override
    public int SetLighting(String LowHigh) {
        insertData(LowHigh,"Lighting");
        hardwareState.put("Lighting",LowHigh);
        int msg = 1;
        if("1".equals(LowHigh))
            gpioLED.high();
        else if("0".equals(LowHigh)){
            gpioLED.low();
            float minutes = (float) ((new Date().getTime() - PeopleOpenCloseLED.getTime()) / (1000 * 60));
            System.out.println("关灯时间（分）：----"+minutes);
            if(minutes>0){
                Ledtimeslot ledtimeslot = new Ledtimeslot();
                ledtimeslot.setType("1");
                ledtimeslot.setTime(new Date());
                ledtimeslot.setTimeslot(minutes);
                int msgs = ledtimeslotMapper.insert(ledtimeslot);
                System.out.println(msgs);
            }
            PeopleOpenCloseLED =  new Date();
        }

        else
            msg = -1;
        return msg;
    }

    /**
     * 雾化器
     * @param LowHigh
     * @return
     */
    @Override
    public int SetAtomizer(String LowHigh) {
        insertData(LowHigh,"Atomizer");
        hardwareState.put("Atomizer",LowHigh);
        int msg = 1;
        if("1".equals(LowHigh))
            atomizer.high();
        else if("0".equals(LowHigh))
            atomizer.low();
        else
            msg = -1;
        return msg;
    }

    /**
     * 风扇
     * @param LowHigh
     * @return
     */
    @Override
    public int SetFan(String LowHigh) {
        insertData(LowHigh,"Fan");
        hardwareState.put("Fan",LowHigh);
        int msg = 1;
        if("1".equals(LowHigh))
            fan.high();
        else if("0".equals(LowHigh))
            fan.low();
        else
            msg = -1;
        return msg;
    }

    /**
     * 水泵
     * @param LowHigh
     * @return
     */
    @Override
    public int SetWaterump(String LowHigh) {
        insertData(LowHigh,"Waterump");
        hardwareState.put("Waterump",LowHigh);
        return -2;
    }

    public int insertData(String LowHigh,String type){
        Controlpanel controlpanel = new Controlpanel();
        controlpanel.setTime(new Date());
        controlpanel.setState(LowHigh);
        controlpanel.setType(type);
        int msg = controlpanelMapper.insert(controlpanel);
        return msg;
    }
}
