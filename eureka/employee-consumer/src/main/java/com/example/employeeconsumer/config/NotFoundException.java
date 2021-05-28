package com.example.employeeconsumer.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "NOT_FOUND request")
public class NotFoundException extends Exception {
}
