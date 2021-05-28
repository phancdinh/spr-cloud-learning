package com.example.employeeconsumer.client;

import com.example.employeeconsumer.client.dto.EmployeeDto;
import com.example.employeeconsumer.config.BadRequestException;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFallbackFactory implements FallbackFactory<EmployeeClient> {

    @Override
    public EmployeeClient create(Throwable cause) {
        String httpStatus = cause.getCause() instanceof FeignException ? Integer.toString(((FeignException) cause.getCause()).status()) : "";
        System.out.println("EmployeeFallbackFactory");
        System.out.println(cause instanceof FeignException );
        System.out.println(cause instanceof FeignException.FeignClientException);
        System.out.println(cause);
        System.out.println(httpStatus);

        return new EmployeeClientFallback();
    }
}