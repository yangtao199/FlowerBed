
package com.flower;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter
{
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://xncs.bda.gov.cn","http://127.0.0.1:8082").allowCredentials(true).allowedHeaders("*");
    super.addCorsMappings(registry);
  }
}

