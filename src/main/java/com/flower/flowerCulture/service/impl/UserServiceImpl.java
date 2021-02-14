package com.flower.flowerCulture.service.impl;

import com.flower.flowerCulture.model.User;
import com.flower.flowerCulture.mapper.UserMapper;
import com.flower.flowerCulture.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 登陆
     * @param user
     * @return
     */
    @Override
    public User getUserForPassword(User user) {
        return userMapper.getUserForPassword(user);
    }
}
