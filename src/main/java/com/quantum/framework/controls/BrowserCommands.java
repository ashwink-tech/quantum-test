package com.quantum.framework.controls;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;
import java.util.function.Function;

public class BrowserCommands {

  private BrowserCommands() {
    throw new IllegalStateException("BrowserCommands class");
  }

  public static final Function<WebDriver, String> getCurrentUrl = WebDriver::getCurrentUrl;

  public static final Consumer<WebDriver> closeBrowser = WebDriver::quit;
}
