package com.flower.conf.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.flower.conf.resultCommon.ApiCode;
import com.flower.conf.resultCommon.ApiResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class loginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        // 设定字符编码
        response.setCharacterEncoding("utf-8");
     /*   response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");*/
       /* if(session.getAttribute("user")==null){
            PrintWriter writer = response.getWriter();
            ApiResponse<Object> res = ApiResponse.fail(ApiCode.API_NOLOGIN_EXISTS,"null");
            String jsonStr = JSONObject.toJSONString(res);
            writer.print(jsonStr);
            writer.flush();
            writer.close();
            return  false;
        }*/
        //else
         return true;
    }
}
