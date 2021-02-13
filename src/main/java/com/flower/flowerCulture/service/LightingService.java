package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Lighting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
public interface LightingService extends IService<Lighting> {
    /**
     * 监听开关灯操作
     * @param name
     */
    void insertLightingService(String name);
}
