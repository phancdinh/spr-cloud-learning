package com.example.ribbon.client;

import com.example.ribbon.config.RibbonConfiguration;
import com.example.ribbon.dto.StudentDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "student-producer2")
@RibbonClient(
        name = "student-producer2",
        configuration = RibbonConfiguration.class)
public interface StudentUrlClient2 {

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    StudentDto getStudent();
}
