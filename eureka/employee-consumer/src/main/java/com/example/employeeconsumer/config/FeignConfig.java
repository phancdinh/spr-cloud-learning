package com.example.employeeconsumer.config;

import feign.Capability;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Capability capability() {
        return new MicrometerCapability();
    }

    @Bean
    public MicrometerCapability micrometerCapability(MeterRegistry meterRegistry) {
        return new MicrometerCapability(meterRegistry);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new SampleErrorDecode();
    }

    @Bean
    public Retryer retryer() {
        return new CustomRetryer();
    }
}
