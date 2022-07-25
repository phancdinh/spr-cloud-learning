package com.example.employeeconsumer.client;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {

    Exception exception = defaultErrorDecoder.decode(methodKey, response);
    if (exception instanceof RetryableException) {
      return exception;
    }
    //        TODO
    //        FIXME:
    //        if(response.status() == HttpStatus.SERVICE_UNAVAILABLE.value() || response.status() ==
    // HttpStatus.NOT_FOUND.value()
    //                || response.status() == HttpStatus.REQUEST_TIMEOUT.value()
    //                || response.status() == HttpStatus.BAD_GATEWAY.value() || response.status() ==
    // HttpStatus.BAD_REQUEST.value()
    //                || response.status() == HttpStatus.GATEWAY_TIMEOUT.value() ||
    // response.status() == HttpStatus.METHOD_NOT_ALLOWED.value()){
    //            return new RetryableException("Retry for status code: " + response.status(), new
    // Date());
    //        }

    return exception;
  }
}
