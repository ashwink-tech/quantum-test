package com.quantum.framework.helper;

import com.quantum.framework.config.Constants;
import org.awaitility.core.ConditionFactory;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class WaitHelper {

  private WaitHelper() {
    throw new IllegalStateException("WaitHelper class");
  }

  public static final Function<String, ConditionFactory> pollInterval =
    message -> await(message).atMost(Constants.LONG_WAIT, SECONDS).pollInterval(1, SECONDS);
}
