package com.example.employeeproducer.controller;

import com.example.employeeproducer.facade.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {
        return EmployeeDto.builder()
                .name("emp1")
                .designation("manager")
                .empId("1")
                .salary(3000)
                .build();
    }
}
