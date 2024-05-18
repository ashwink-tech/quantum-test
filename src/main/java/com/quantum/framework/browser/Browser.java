package com.quantum.framework.browser;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.quantum.framework.utilities.LogUtil.info;

public class Browser {

  private Browser() {
    throw new IllegalStateException("Browser class");
  }

  private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

  private static final Consumer<WebDriver> setDriver = webDriver::set;

  public static final Supplier<WebDriver> getDriver = webDriver::get;

  public static final Consumer<String> setBrowser =
    browser -> {
         info("Setting the WebDriver for " + browser + " Browser");
         var driver = BrowserType.getDriver.apply(browser);
         setDriver.accept(driver);
  };
  
  public static void removeWebdriver() {
    webDriver.remove();
  }
}
