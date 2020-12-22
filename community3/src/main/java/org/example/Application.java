package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(Application.class);
        springApplication.addInitializers(configurableApplicationContext -> System.out.println("[initialize]"));
        springApplication.run(args);

    }
}
