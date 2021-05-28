package com.example.employeeconsumer.client;

import com.example.employeeconsumer.client.dto.EmployeeDto;
import com.example.employeeconsumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component
public class EmployeeClientFallback implements EmployeeClient{
    @Override
    public EmployeeDto getEmployee() {
        System.out.println("fallback call");

        return EmployeeDto.builder()
                .name("fallback")
                .designation("employee")
                .empId("22")
                .salary(2000)
                .build();
    }
}
