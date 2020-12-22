package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("org.example.mapper")
public class Application {
    public static void main(String[] args) {
//        SpringApplication springApplication=new SpringApplication(Application.class);
//        springApplication.setBannerMode(Banner.Mode.LOG);
//        ConfigurableApplicationContext run = springApplication.run(args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        SpringApplication.run(Application.class,args);
    }
}
