package com.example.ubikatetracking;

import com.example.ubikatetracking.access.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(CorsConfig.class)
@ComponentScan(basePackages = "com.example.ubikatetracking")
@EntityScan(basePackages = "com.example.ubikatetracking.model")
@EnableJpaRepositories(basePackages = "com.example.ubikatetracking.repository")
public class UbikateTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbikateTrackingApplication.class, args);
    }

}
