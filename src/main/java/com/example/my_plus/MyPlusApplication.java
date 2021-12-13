package com.example.my_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.my_plus.mapper")
public class MyPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPlusApplication.class, args);
    }



}
