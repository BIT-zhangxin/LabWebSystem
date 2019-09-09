package com.example.labwebsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class LabwebsystemApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(LabwebsystemApplication.class, args);
    }

}
