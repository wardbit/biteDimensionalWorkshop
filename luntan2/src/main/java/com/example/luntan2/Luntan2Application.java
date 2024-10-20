package com.example.luntan2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.luntan2.mapper")
public class Luntan2Application {

    public static void main(String[] args) {
        SpringApplication.run(Luntan2Application.class, args);
    }

}
