package com.quantum.framework.factories;

import static java.lang.System.getProperty;

public class GetBaseUrlFactory {

  private GetBaseUrlFactory() {}

  public static String getBaseUrl() {
    return getProperty("baseurl");
  }
}
