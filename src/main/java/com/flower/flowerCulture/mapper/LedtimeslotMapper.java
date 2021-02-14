package com.flower.flowerCulture.mapper;

import com.flower.flowerCulture.model.Ledtimeslot;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
public interface LedtimeslotMapper extends BaseMapper<Ledtimeslot> {

    List<Ledtimeslot> SelectLedtimeslot();
}
