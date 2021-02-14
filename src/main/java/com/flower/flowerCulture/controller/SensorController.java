package com.flower.flowerCulture.controller;


import com.flower.conf.resultCommon.ApiCode;
import com.flower.conf.resultCommon.ApiResponse;
import com.flower.flowerCulture.model.Sensor;
import com.flower.flowerCulture.service.SensorService;
import com.flower.flowerCulture.vo.SensorVo;
import org.omg.CORBA.Object;
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
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorService sensorService;
    /**
     *温度、湿度、光照信息统计
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/historicalInformation"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<SensorVo> getDatas(HttpServletRequest request) throws Exception {
        SensorVo sensorVo = new SensorVo();
        sensorVo = sensorService.getDatas();
        return ApiResponse.success(sensorVo);
    }
    @RequestMapping(value = {"/historicalInformationq"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<SensorVo> getDatass(HttpServletRequest request) throws Exception {
        SensorVo sensorVo = new SensorVo();
        sensorVo.setArtificialIllumination(11.2344);
        return ApiResponse.success(sensorVo);
    }

    /**
     * 分组查询温度档
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/getCountTemperature"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<List<SensorVo>> getCountTemperature(HttpServletRequest request) throws Exception {
        List<SensorVo> sensorVo= sensorService.getCountTemperature();
        return ApiResponse.success(sensorVo);
    }

    /**
     * 分组查询湿度档
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/getCountHumidity"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<List<SensorVo>> getCountHumidity(HttpServletRequest request) throws Exception {
        List<SensorVo> sensorVo= sensorService.getCountHumidity();
        return ApiResponse.success(sensorVo);
    }

    /**
     * 分组查询历史温度、湿度
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/getGroupSensor"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResponse<List<Sensor>> getGroupSensor(HttpServletRequest request) throws Exception {
        List<Sensor> sensorVo= sensorService.getGroupSensor();
        return ApiResponse.success(sensorVo);
    }
}
