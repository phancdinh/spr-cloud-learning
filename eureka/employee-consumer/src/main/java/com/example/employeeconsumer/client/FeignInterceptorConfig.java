package com.example.employeeconsumer.client;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//@Configuration
public class FeignInterceptorConfig {

  @Autowired
  private ObjectFactory<HttpMessageConverters> messageConverters;

  @Bean
  public Decoder feignDecoder() {
    return new ResponseEntityDecoder(new SpringDecoder(this.messageConverters));
  }

  @Bean
  public Encoder feignEncoder() {
    return new SpringFormEncoder(new SpringEncoder(this.messageConverters));
  }

  @Bean
  public Logger.Level loggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public Retryer retryer() {
    return new FeignRetryer();
  }

  @Bean
  @Primary
  public Feign.Builder feignBuilder(Retryer retryer) {
    return Feign.builder().errorDecoder(new FeignErrorDecoder()).retryer(retryer);
  }
}
