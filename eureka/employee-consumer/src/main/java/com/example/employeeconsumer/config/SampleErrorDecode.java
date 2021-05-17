package com.example.employeeconsumer.config;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class SampleErrorDecode implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        System.out.println("Error Response!!!");

        if (400 == response.status()) {
            System.out.println("It's a 400 Error!!!");
        }
        if (401 == response.status()) {
            System.out.println("It's a 401 Error!!!");
        }

        if (403 == response.status()) {
            System.out.println("It's a 403 Error!!!");
        }

        if (406 == response.status()) {
            System.out.println("It's a 406 Error!!!");
        }
        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException();
            case 409:
                return new NotFoundException();
            default:
                // return feignException
                return defaultErrorDecoder.decode(s, response);
        }
    }
}
