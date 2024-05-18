package com.quantum.framework.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;

import static com.quantum.framework.helper.SeleniumHelper.getChromeOptions;
import static com.quantum.framework.helper.SeleniumHelper.getFireFoxOptions;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static java.lang.System.setProperty;
import static java.util.Map.of;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.firefox.FirefoxDriverLogLevel.fromLevel;


public class BrowserType {

  private BrowserType() {
       throw new IllegalStateException("BrowserType class");
    }
    private static final String silentLog = "webdriver.chrome.silentOutput";

    private static final Supplier<WebDriver> chromeDriverSupplier =
      () -> {
        var chromeOptions = getChromeOptions();
        chromeOptions.setPageLoadStrategy(NORMAL);
        chromeOptions.addArguments("--deny-permission-prompts");
        chromeOptions.addArguments("disable-geolocation");
        chromeOptions.addArguments("enable-strict-powerful-feature-restrictions");
        setProperty(silentLog, "true");
        return new ChromeDriver(chromeOptions);
      };

  private static final Map<String, Supplier<WebDriver>> browserDrivers =
      of("Chrome", chromeDriverSupplier);

  // return a new driver from the map
  public static final Function<String, WebDriver> getDriver =
      browser -> browserDrivers.get(browser).get();
}
