package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Sensor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.flower.flowerCulture.vo.SensorVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
public interface SensorService extends IService<Sensor> {

    /**
     * 插入温度
     * @param temperature
     * @param humidity
     */
    void insertTemperature(float temperature, float humidity);



    /**
     * 温度、湿度、光照信息统计
     */
    SensorVo getDatas();
}
