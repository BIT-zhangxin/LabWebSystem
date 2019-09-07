package com.example.labwebsystem;

import com.example.labwebsystem.security.service.AppUserDetailArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class LabwebsystemApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(LabwebsystemApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new AppUserDetailArgumentResolver());
    }

}
