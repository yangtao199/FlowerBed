package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Sensor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.flower.flowerCulture.vo.SensorVo;

import java.util.List;

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
    /**
     * 分组查询温度档
     * @return
     * @throws Exception
     */
    List<SensorVo> getCountTemperature();

    /**
     * 分组查询湿度
     * @return
     */
    List<SensorVo> getCountHumidity();

    /**
     * 分组查询历史温度湿度
     * @return
     */
    List<Sensor> getGroupSensor();
}
