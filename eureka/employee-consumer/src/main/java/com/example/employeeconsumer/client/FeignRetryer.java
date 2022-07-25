package com.example.employeeconsumer.client;

import feign.RetryableException;
import feign.Retryer;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class FeignRetryer implements Retryer {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private int retryMaxAttempt;

  private long retryInterval;

  private int attempt = 1;

  public FeignRetryer(int retryMaxAttempt, Long retryInterval) {
    this.retryMaxAttempt = retryMaxAttempt;
    this.retryInterval = retryInterval;
  }

  @Override
  public void continueOrPropagate(RetryableException e) {
    logger.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

    if (attempt++ == retryMaxAttempt) {
      throw e;
    }
    try {
      Thread.sleep(retryInterval);
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public Retryer clone() {
    return new FeignRetryer(3, 1000l);
  }
}
