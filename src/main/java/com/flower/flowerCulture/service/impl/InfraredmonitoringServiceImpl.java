package com.flower.flowerCulture.service.impl;

import com.flower.flowerCulture.model.Infraredmonitoring;
import com.flower.flowerCulture.mapper.InfraredmonitoringMapper;
import com.flower.flowerCulture.service.InfraredmonitoringService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
@Service
public class InfraredmonitoringServiceImpl extends ServiceImpl<InfraredmonitoringMapper, Infraredmonitoring> implements InfraredmonitoringService {
    @Autowired
    private InfraredmonitoringMapper infraredmonitoringMapper;
    /**
     * 红外抓拍保存图像
     * @param img
     */
    @Override
    public void insertInfraredmonitoring(String img) {
        System.out.println("------------红外抓拍保存");
        Infraredmonitoring infraredmonitoring = new Infraredmonitoring();
        infraredmonitoring.setTime(new Date());
        infraredmonitoring.setImage(img);
        int msg = infraredmonitoringMapper.insert(infraredmonitoring);
        System.out.println(msg);

    }
}
