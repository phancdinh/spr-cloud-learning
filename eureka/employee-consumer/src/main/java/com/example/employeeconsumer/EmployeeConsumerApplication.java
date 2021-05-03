package com.example.employeeconsumer;

import com.example.employeeconsumer.client.EmployeeClient;
import com.example.employeeconsumer.client.dto.EmployeeDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class EmployeeConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(
                EmployeeConsumerApplication.class, args);

        EmployeeClient consumerControllerClient=ctx.getBean(EmployeeClient.class);
        System.out.println(consumerControllerClient);
        EmployeeDto e = consumerControllerClient.getEmployee();
        System.out.println(e);
    }

}
