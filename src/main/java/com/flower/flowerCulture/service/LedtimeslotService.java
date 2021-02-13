package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Ledtimeslot;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
