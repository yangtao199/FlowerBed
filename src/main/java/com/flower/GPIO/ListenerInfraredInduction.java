package com.flower.GPIO;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @Description TODO
 * @Author yangtao
 * @Date 2021/2/8 0008 14:22
 * 红外感应
 */
@Component
public class ListenerInfraredInduction implements CommandLineRunner, Ordered {
    //红外监控
    public void ListenerInfraredInduction(){
        final GpioPinDigitalInput gpioInfraredInduction = ControlGpio.MapGpioPinDigitalInput.get("InfraredInduction");
        System.out.println("红外监控gpioInfraredInduction"+gpioInfraredInduction);
        gpioInfraredInduction.setShutdownOptions(true);
        gpioInfraredInduction.addListener(new GpioPinListenerDigital() {
            @SneakyThrows
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println("变化了！");
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+";   source=	"+event.getSource());
               /* while(true) {
                    Thread.sleep(500);
                }*/
            }

        });
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始监听红外");
       // ListenerInfraredInduction();
    }

    @Override
    public int getOrder() {
        return 0;
    }


/*    public static void main(String args[]) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        //将gpio引脚＃02设置为输入引脚，并使能其内部下拉电阻
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

        //设置此输入引脚的关闭状态
        myButton.setShutdownOptions(true);

        //创建并注册gpio pin监听器
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+";   source=	"+event.getSource());
            }

        });

        System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

        // keep program running until user aborts (CTRL-C)
        while(true) {
            Thread.sleep(500);
        }
        //通过关闭GPIO控制器来停止所有GPIO活动/线程
        //（此方法将强制关闭所有GPIO监视线程和计划任务）
        // gpio.shutdown（）; <---如果要终止Pi4J GPIO控制器，请执行此方法调用
    }*/
}
