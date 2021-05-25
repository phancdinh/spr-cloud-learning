package com.example.ribbon.controller;

import com.example.ribbon.client.StudentUrlClient;
import com.example.ribbon.client.StudentUrlClient2;
import com.example.ribbon.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    private RestTemplate restTemplate;
    private StudentUrlClient studentUrlClient;
    private StudentUrlClient2 studentUrlClient2;

    public StudentController(RestTemplate restTemplate, StudentUrlClient studentUrlClient) {
        this.restTemplate = restTemplate;
        this.studentUrlClient = studentUrlClient;
    }

    @GetMapping(value = "/studentClient")
    public String studentClient() {
        return restTemplate.getForObject("http://student-producer/student", String.class);
    }

    @GetMapping(value = "/studentUrlClient")
    public StudentDto studentUrlClient() {
        return studentUrlClient.getStudent();
    }
    @GetMapping(value = "/studentUrlClient2")
    public StudentDto studentUrlClient2() {
        return studentUrlClient.getStudent();
    }
}
