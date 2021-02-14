package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Ledtimeslot;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
public interface LedtimeslotService extends IService<Ledtimeslot> {
    /**
     * 插入时间段
     * @param type
     * @param minutes
     */
    void inserttimeslot(String type,float minutes);

    /**
     * 分组查询LED光照的时间（人工和自然光照）
     * @return
     */
    List<Ledtimeslot>  SelectLedtimeslot();
}
