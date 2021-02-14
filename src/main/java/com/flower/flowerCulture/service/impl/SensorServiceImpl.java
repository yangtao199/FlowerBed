package com.flower.flowerCulture.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flower.flowerCulture.model.Sensor;
import com.flower.flowerCulture.mapper.SensorMapper;
import com.flower.flowerCulture.service.SensorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flower.flowerCulture.vo.SensorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
@Service
public class SensorServiceImpl extends ServiceImpl<SensorMapper, Sensor> implements SensorService {
    @Autowired
    private SensorMapper sensorMapper;
    /**
     * 插入温度
     * @param temperature
     * @param humidity
     */

    @Override
    public void insertTemperature(float temperature, float humidity) {
        QueryWrapper<Sensor> SensorWrapper = new QueryWrapper<>();
        Sensor sensorVo = new Sensor();
        sensorVo.setTime(new Date());//设置当前时间
        sensorVo.setHumidity((double) humidity);//湿度
        sensorVo.setTemperature((double) temperature);//温度
        int result = sensorMapper.insert(sensorVo);
        System.out.println(result); //影响的行数
        System.out.println(sensorVo); //id自动回填

    }

    /**
     * 温度、湿度、光照信息统计
     * @return
     */
    @Override
    public SensorVo getDatas() {

        return sensorMapper.getDatas();
    }
    /**
     * 分组查询温度档
     * @return
     * @throws Exception
     */
    @Override
    public List<SensorVo> getCountTemperature() {
        return sensorMapper.getCountTemperature();
    }

    /**
     * 分组查询湿度
     * @return
     */
    @Override
    public List<SensorVo> getCountHumidity() {
        return sensorMapper.getCountHumidity();
    }

    /**
     * 分组查询历史温度湿度
     * @return
     */
    @Override
    public List<Sensor> getGroupSensor() {
        Sensor sensor = new Sensor();
        sensor.setTime(new Date());
        return sensorMapper.getGroupSensor(sensor);
    }

}
