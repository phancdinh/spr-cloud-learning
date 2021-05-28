package com.example.employeeproducer.facade.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private String empId;
    private String name;
    private String designation;
    private double salary;
}
