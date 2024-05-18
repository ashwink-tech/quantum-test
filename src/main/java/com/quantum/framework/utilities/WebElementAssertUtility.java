package com.quantum.framework.utilities;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import static com.quantum.framework.browser.Browser.getDriver;
import static com.quantum.framework.helper.SeleniumHelper.getElement;

public class WebElementAssertUtility extends AbstractAssert<WebElementAssertUtility, WebElement> {

  public WebElementAssertUtility(String locator) {
    super(getElement(getDriver.get(), locator), WebElementAssertUtility.class);
  }

  public static WebElementAssertUtility asserts(String locator) {
    return new WebElementAssertUtility(locator);
  }

  public WebElementAssertUtility isEqualTo(String text) {
    isNotNull();
    if (!actual.getText().equals(text)) {
      failWithMessage("Expected text " + text + "is not equal to " + actual.getText());
    }
    return this;
  }
}
