package com.example.kuberclient.controller;

import com.example.kuberclient.clientServer.StudentClient;
import com.example.kuberclient.dto.StudentDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
    private final StudentClient studentClient;
    private RestTemplate rest = new RestTemplateBuilder().build();

    public StudentController(StudentClient studentClient) {
        this.studentClient = studentClient;
    }

    @GetMapping(value = "/")
    public StudentDto student() {
        return StudentDto.builder().stdId("s").name("di").build();
    }
    @GetMapping(value = "/2")
    public StudentDto student3() {
        return StudentDto.builder().stdId("s").name("di").build();
    }

    @GetMapping(value = "/student")
    public StudentDto student24() {
        return studentClient.getStudent();
    }
    @GetMapping(value = "/student2")
    public String student22() {
        return rest.getForObject("http://k8s-demo-app/student", String.class);
    }
}
