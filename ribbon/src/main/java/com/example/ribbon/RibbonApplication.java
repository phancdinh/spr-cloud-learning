package com.example.ribbon;

import com.example.ribbon.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RibbonClient(
        name = "student-producer",
        configuration = RibbonConfiguration.class)
@EnableFeignClients
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
