package com.example.ubikatetracking;

import com.example.ubikatetracking.access.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class UbikateTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbikateTrackingApplication.class, args);
    }

}
