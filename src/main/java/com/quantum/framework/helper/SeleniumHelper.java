package com.quantum.framework.helper;

import com.quantum.framework.controls.BrowserWaits;
import com.quantum.framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

import static com.quantum.framework.controls.BrowserWaits.*;
import static com.quantum.framework.utilities.LogUtil.*;
import static org.openqa.selenium.By.xpath;

public class SeleniumHelper {

  private SeleniumHelper() {
    throw new IllegalStateException("SeleniumHelper class");
  }

  public static WebElement getElement(WebDriver driver, String sLocator) {
    info("Waiting for an element " + sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement getElementToClick(WebDriver driver, String sLocator) {
    waitForClickableElement.accept(driver, sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement getElementWithoutWait(WebDriver driver, String sLocator) {
    return findElement(driver, sLocator);
  }

  public static WebElement findElement(WebDriver driver, String sLocator) {
    return driver.findElement(xpath(sLocator));
  }

  public static List<WebElement> getElements(WebDriver driver, String sLocator) {
    waitMethod.accept(driver, sLocator);
    return driver.findElements(xpath(sLocator));
  }

  public static List<WebElement> getElementsWithoutWait(WebDriver driver, String sLocator) {
    return driver.findElements(xpath(sLocator));
  }

  public static ChromeOptions getChromeOptions() {
    return new ChromeOptions();
  }

  public static FirefoxOptions getFireFoxOptions() {
    return new FirefoxOptions() ;
  }
}
