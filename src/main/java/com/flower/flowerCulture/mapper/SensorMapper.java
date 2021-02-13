package com.flower.flowerCulture.mapper;

import com.flower.flowerCulture.model.Sensor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flower.flowerCulture.vo.SensorVo;

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
}
