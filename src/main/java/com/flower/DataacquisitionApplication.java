package com.flower;

import com.flower.GPIO.ControlGpio;
import com.flower.util.SpringUtil;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.flower.flowerCulture.mapper")
@Import(SpringUtil.class)
public class DataacquisitionApplication{

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DataacquisitionApplication.class, args);
    }

}
