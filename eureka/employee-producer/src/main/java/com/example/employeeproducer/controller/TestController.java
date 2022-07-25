package com.example.employeeproducer.controller;

import com.example.employeeproducer.facade.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@RestController
@Slf4j
public class TestController {
    private static final Logger LOG = Logger.getLogger(TestController.class.getName());

    @GetMapping(value = "/employee")
    public EmployeeDto firstPage() {

        LOG.info("handle request load balancing");
        log.info("handle request load balancing2");
        int num = random(200, 400);
//        int result = num % 5;
        int result = 6;

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
