package com.flower.flowerCulture.mapper;

import com.flower.flowerCulture.model.Sensor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flower.flowerCulture.vo.SensorVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
public interface SensorMapper extends BaseMapper<Sensor> {

    SensorVo getDatas();

    /**
     * 分组查询温度档
     * @return
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
    List<Sensor> getGroupSensor(Sensor sensor);
}
