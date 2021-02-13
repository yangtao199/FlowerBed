package com.flower.flowerCulture.controller;


import com.flower.conf.resultCommon.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangTao
 * @since 2021-02-14
 */
@RestController
@RequestMapping("/controlpanel")
public class ControlpanelController {
    /**
     * 灯光
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/lighting"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<Object> SetLighting(HttpServletRequest request) throws Exception {
       String lighting = request.getParameter("lighting");
        return ApiResponse.success();
    }
    /**
     * 雾化器
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/atomizer"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<Object> SetAtomizer(HttpServletRequest request) throws Exception {
        String atomizer = request.getParameter("atomizer");
        return ApiResponse.success();
    }

    /**
     * 风扇
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/fan"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<Object> SetFan(HttpServletRequest request) throws Exception {
        String atomizer = request.getParameter("fan");
        return ApiResponse.success();
    }

    /**
     * 水泵
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/waterPump"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<Object> SetWaterump(HttpServletRequest request) throws Exception {
        String waterPump = request.getParameter("waterPump");
        return ApiResponse.success();
    }


}
