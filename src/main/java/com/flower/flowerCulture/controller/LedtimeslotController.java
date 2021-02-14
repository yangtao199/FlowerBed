package com.flower.flowerCulture.controller;


import com.flower.conf.resultCommon.ApiResponse;
import com.flower.flowerCulture.model.Ledtimeslot;
import com.flower.flowerCulture.service.LedtimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangTao
 * @since 2021-02-13
 */
@RestController
@RequestMapping("/ledtimeslot")
public class LedtimeslotController {
    @Autowired
    private LedtimeslotService ledtimeslotService;
    /**
     * 分组查询光照时间
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/getLedtimeslot"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<Object> SetWaterump(HttpServletRequest request) throws Exception {
       List<Ledtimeslot> ledtimeslotVo = ledtimeslotService.SelectLedtimeslot();
        return ApiResponse.success(ledtimeslotVo);
    }
}
