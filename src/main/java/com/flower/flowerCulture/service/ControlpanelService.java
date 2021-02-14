package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.Controlpanel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-14
 */
public interface ControlpanelService extends IService<Controlpanel> {
    /**
     * 灯光
     * @param lighting
     * @return
     */
    int SetLighting(String lighting);

    /**
     * 雾化器
     * @param atomizer
     * @return
     */
    int SetAtomizer(String atomizer);

    /**
     * 风扇
     * @param fan
     * @return
     */
    int SetFan(String fan);

    /**
     * 水泵
     * @param waterPump
     * @return
     */
    int SetWaterump(String waterPump);
}
