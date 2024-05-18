package com.quantum.framework.controls;

import org.openqa.selenium.WebDriver;

import java.util.function.BiConsumer;

public class BrowserNavigation {

  private BrowserNavigation() {
    throw new IllegalStateException("BrowserNavigation class");
  }

  public static final BiConsumer<WebDriver, String> navigateToUrl = WebDriver::get;
}
