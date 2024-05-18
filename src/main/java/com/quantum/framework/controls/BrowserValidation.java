package com.quantum.framework.controls;

import org.openqa.selenium.WebDriver;

import static com.quantum.framework.controls.BrowserWaits.getMediumWait;
import static com.quantum.framework.controls.BrowserWaits.waitTillElementNotPresent;
import static com.quantum.framework.helper.SeleniumHelper.*;
import static com.quantum.framework.utilities.LogUtil.info;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BrowserValidation {

  private BrowserValidation() {
    throw new IllegalStateException("BrowserValidation class");
  }

  private static final String CHECK_ELEMENT_LOG = "Checking whether an element ";

  public static boolean isElementPresent(WebDriver driver, String sLocator) {
    info(CHECK_ELEMENT_LOG + sLocator + " is present");
    return getElements(driver, sLocator).isEmpty();
  }

  public static boolean isElementClickable(WebDriver driver, String sLocator) {
    info(CHECK_ELEMENT_LOG + sLocator + " is present");
    getMediumWait.apply(driver).until(elementToBeClickable(getElement(driver,sLocator)));
    return true;
  }

  public static boolean isElementNotPresent(WebDriver driver, String sLocator) {
    info("Waiting for an element " + sLocator + " to be not visible");
    waitTillElementNotPresent.accept(driver, sLocator);
    info(CHECK_ELEMENT_LOG + sLocator + " is present without wait");
    return getElementsWithoutWait(driver, sLocator).isEmpty();
  }

  public static boolean isDisplayed(WebDriver driver, String sLocator) {
    info(CHECK_ELEMENT_LOG + sLocator + " is displayed");
    return getElement(driver, sLocator).isDisplayed();
  }
}
