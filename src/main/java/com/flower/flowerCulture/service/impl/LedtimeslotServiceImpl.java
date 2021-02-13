package com.flower.flowerCulture.service.impl;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.flower.flowerCulture.model.Ledtimeslot;
import com.flower.flowerCulture.mapper.LedtimeslotMapper;
import com.flower.flowerCulture.service.LedtimeslotService;
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
public class LedtimeslotServiceImpl extends ServiceImpl<LedtimeslotMapper, Ledtimeslot> implements LedtimeslotService {
    @Autowired
    private LedtimeslotMapper ledtimeslotMapper;
    /**
     * 插入时间段
     * @param type
     * @param minutes
     */
    @Override
    public void inserttimeslot(String type, float minutes) {
        Ledtimeslot ledtimeslot = new Ledtimeslot();
        ledtimeslot.setType(type);
        ledtimeslot.setTime(new Date());
        ledtimeslot.setTimeslot(minutes);
        int msg = ledtimeslotMapper.insert(ledtimeslot);
        System.out.println(msg);
    }
}
