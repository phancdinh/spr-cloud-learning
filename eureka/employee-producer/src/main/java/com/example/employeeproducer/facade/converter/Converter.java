package com.example.employeeproducer.facade.converter;

import com.example.employeeproducer.dao.model.Employee;
import com.example.employeeproducer.facade.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Converter {
    public EmployeeDto convertToDto(Employee employee) {

        return Optional.ofNullable(employee)
                .map(e -> EmployeeDto.builder()
                        .empId(e.getEmpId())
                        .name(e.getName())
                        .designation(e.getDesignation())
                        .salary(e.getSalary())
                        .build())
                .orElse(null);
    }
}
