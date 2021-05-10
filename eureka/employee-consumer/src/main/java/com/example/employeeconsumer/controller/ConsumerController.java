package com.example.employeeconsumer.controller;

import com.example.employeeconsumer.client.EmployeeClient;
import com.example.employeeconsumer.client.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private final EmployeeClient employeeClient;

    public ConsumerController(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {
        return employeeClient.getEmployee();
    }
}
