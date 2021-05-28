package com.example.employeeproducer.controller;

import com.example.employeeproducer.facade.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TestController {
    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {
        System.out.println("handle request load balancing");
        int num = random(200, 400);
        int result = num % 5;

        switch (result) {
            case 0:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
            case 1:
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "FORBIDDEN");
            case 2:
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "NOT_ACCEPTABLE");
            case 3:
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
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
