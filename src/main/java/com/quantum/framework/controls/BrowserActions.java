package com.quantum.framework.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.quantum.framework.controls.BrowserWaits.waitForElement;
import static com.quantum.framework.helper.SeleniumHelper.*;
import static com.quantum.framework.utilities.LogUtil.info;

@SuppressWarnings("ALL")
public class BrowserActions {

  private BrowserActions() {
     throw new IllegalStateException("BrowserActions class");
  }

  private static final String CLICK_ACTION_LOG = "Clicking on an element ";

  public static void click(WebDriver driver, String sLocator) {
    info(CLICK_ACTION_LOG + sLocator);
    getElementToClick(driver, sLocator).click();
  }

  public static void pressEnter(WebDriver driver, String sLocator) {
    info("Pressing Enter Key " + sLocator);
    getElement(driver, sLocator).sendKeys(Keys.RETURN);
  }

  public static void input(WebDriver driver, String inputValue, String sLocator) {
    info("Entering " + inputValue + "in an input field " + sLocator);
    getElement(driver, sLocator).sendKeys(inputValue);
  }

  public static void uploadFile(WebDriver driver, String filePath, String sLocator, String waitForLocator) {
    info("Upload the File");
    getElementWithoutWait(driver, sLocator).sendKeys(filePath);
    waitForElement.accept(driver, waitForLocator);
  }
}
