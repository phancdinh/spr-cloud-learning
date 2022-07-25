package com.example.employeeconsumer.controller;

import com.example.employeeconsumer.client.EmployeeClient;
import com.example.employeeconsumer.client.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Slf4j
public class ConsumerController {
    private final EmployeeClient employeeClient;
    private static final Logger LOG = Logger.getLogger(ConsumerController.class.getName());

    public ConsumerController(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {
        LOG.info("you called home");
        log.info("you called home2");
        return employeeClient.getEmployee();
    }
}
