
package com.flower;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter
{
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("*").allowedOrigins("ws://172.24.55.2:8081","http://127.0.0.1:8848").allowCredentials(true).allowedHeaders("*");
    super.addCorsMappings(registry);
  }
}

