package com.example.demo;

import com.example.demo.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class K8sDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8sDemoAppApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/student")
    public Student student() {
        return Student.builder()
                .name("Phan Cong Dinh")
                .stdId("CO00019")
                .build();
    }
}
