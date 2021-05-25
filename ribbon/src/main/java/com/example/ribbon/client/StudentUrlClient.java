package com.example.ribbon.client;

import com.example.ribbon.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "student-producer")
public interface StudentUrlClient {

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    StudentDto getStudent();
}
