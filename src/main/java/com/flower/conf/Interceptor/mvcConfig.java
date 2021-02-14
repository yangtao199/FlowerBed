package com.flower.conf.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//导入配置
@Configuration
//继承WebMvcConfigurer
public class mvcConfig implements WebMvcConfigurer {

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
                //配置不拦截的路径
                .excludePathPatterns("/","/user/getUserForPassword","/user/getUserInfo","/user/getverificationCode");
    }
}


//,"/sensor/historicalInformation","/controlpanel/lighting","/controlpanel/atomizer","/controlpanel/fan","/controlpanel/waterPump","/ledtimeslot/getLedtimeslot","/sensor/getCountTemperature","/sensor/getCountHumidity"