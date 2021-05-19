package com.example.employeeconsumer.client;

import com.example.employeeconsumer.client.dto.EmployeeDto;
import com.example.employeeconsumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee-producer", configuration = FeignConfig.class, fallbackFactory = EmployeeFallbackFactory.class)
public interface EmployeeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    EmployeeDto getEmployee();
}
