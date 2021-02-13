package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Infraredmonitoring;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
public interface InfraredmonitoringService extends IService<Infraredmonitoring> {
    /**
     * 红外抓拍保存图像
     * @param img
     */
    void insertInfraredmonitoring(String img);
}
