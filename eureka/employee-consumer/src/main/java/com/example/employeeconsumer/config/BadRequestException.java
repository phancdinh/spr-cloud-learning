package com.example.employeeconsumer.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "BAD_REQUEST request")
public class BadRequestException extends Exception {
}
