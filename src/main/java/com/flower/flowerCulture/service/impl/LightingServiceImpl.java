package com.flower.flowerCulture.service.impl;

import com.flower.flowerCulture.model.Lighting;
import com.flower.flowerCulture.mapper.LightingMapper;
import com.flower.flowerCulture.service.LightingService;
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
public class LightingServiceImpl extends ServiceImpl<LightingMapper, Lighting> implements LightingService {
    @Autowired
    private LightingMapper lightingMapper;
    /**
     * 监听开关灯操作
     * @param name
     */
    @Override
    public void insertLightingService(String name) {
        Lighting lighting = new Lighting();
        lighting.setTime(new Date());
        lighting.setType(name);
        int i = lightingMapper.insert(lighting);
        System.out.println(i);
    }
}
