package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    private final Environment env;


    @Value( "${app.demo-env}" )
    private String appDemoEnv;

    @Value( "${app.value}" )
    private String value;

    public TestController(Environment env) {
        this.env = env;
    }

    @GetMapping("/env")
    public String demoEnv() {
        return appDemoEnv;
    }
    @GetMapping("/value")
    public String value() {
        return value;
    }
    @GetMapping("/dir-env")
    public String student() {
        return env.getProperty("dir-env");
    }
}
