package com.example.kuberclient.clientServer;

import com.example.kuberclient.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "k8s-demo-app")
public interface StudentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    StudentDto getStudent();
}
