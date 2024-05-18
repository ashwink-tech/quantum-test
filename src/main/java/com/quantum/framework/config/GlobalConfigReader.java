package com.quantum.framework.config;

import static org.aeonbits.owner.ConfigFactory.create;

public class GlobalConfigReader {

  private GlobalConfigReader() {
    throw new IllegalStateException("GlobalConfigReader class");
  }

  public static GlobalConfig getProperty() {
    return create(GlobalConfig.class);
  }
}
