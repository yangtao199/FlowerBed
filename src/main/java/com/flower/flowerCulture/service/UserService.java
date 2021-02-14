package com.flower.flowerCulture.service;

import com.flower.flowerCulture.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
public interface UserService extends IService<User> {
    /**
     * 登陆
     * @param user
     * @return
     */
    User getUserForPassword(User user);
}
