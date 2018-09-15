package com.info.shane;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.info.shane.repository")
public class ShaneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShaneApplication.class, args);
    }
}
