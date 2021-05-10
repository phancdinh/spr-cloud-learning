package com.example.employeeproducer.controller;

import com.example.employeeproducer.facade.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {
        System.out.println("handle request load balancing");
        int num = random(200, 400);
        if (num % 2 == 0) {
            throw  new RuntimeException("odd number");
        }
        return EmployeeDto.builder()
                .name("emp1")
                .designation("manager")
                .empId("1")
                .salary(3000)
                .build();
    }

    private int random(int min, int max) {
        System.out.println("Random value of type double between " + min + " to " + max + ":");
        double a = Math.random() * (max - min + 1) + min;
        System.out.println(a);
        System.out.println("Random value of type int between " + min + " to " + max + ":");
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
