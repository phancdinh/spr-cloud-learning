package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String stdId;
    private String name;
}
