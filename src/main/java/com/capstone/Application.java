package com.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.capstone.*"})
@SpringBootApplication
@EntityScan(basePackages = "com.capstone.entity")
//@EnableJpaRepositories(basePackages = "com.capstone.repository")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
