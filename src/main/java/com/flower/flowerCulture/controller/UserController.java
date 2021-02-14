package com.flower.flowerCulture.controller;


import com.flower.conf.resultCommon.ApiCode;
import com.flower.conf.resultCommon.ApiResponse;
import com.flower.flowerCulture.model.User;
import com.flower.flowerCulture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/getUserForPassword"}, method = {RequestMethod.POST})
    @ResponseBody
    public ApiResponse<Object> getUserForPassword(@RequestBody User user, HttpServletRequest request, HttpSession session) throws Exception {

        User u = userService.getUserForPassword(user);
        if(null!=u){
            session.setAttribute("user",u);
            return ApiResponse.success(u);
        }else{
            return ApiResponse.fail(ApiCode.API_LOGIN_NOUSER_EXISTS,null);
        }
    }

}
