package pages;

import com.quantum.framework.controls.BrowserWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.quantum.framework.browser.Browser.getDriver;
import static com.quantum.framework.controls.BrowserActions.click;
import static com.quantum.framework.controls.BrowserActions.input;
import static com.quantum.framework.controls.BrowserCommands.getCurrentUrl;
import static com.quantum.framework.controls.BrowserNavigation.navigateToUrl;
import static com.quantum.framework.controls.BrowserWaits.*;
import static com.quantum.framework.utilities.LogUtil.info;
import static com.quantum.framework.utilities.WebElementAssertUtility.asserts;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {

  protected WebDriver driver;

  public BasePage() {
    this.driver = getDriver.get();
  }

  public String getLocators(String locator, String elementType) {
    return "";
  }

  public void clickOnElement(String locator, String elementType) {
    click(driver, getLocators(locator, elementType));
  }

  public void enterValue(String value, String locator) {
    input(driver, value, locator);
  }

  public void navigateToPageIfNotLoaded(String url) {
    info("Navigating to Page " + url);
    if(!substringBefore(getCurrentUrl.apply(driver), "?").contains(substringBefore(url, "?"))) {
      navigateToUrl.accept(driver, url);
      waitForPageLoad.accept(driver);
    }
  }

  public void isEqualTo(String locator, String elementType, String text) {
    info("checking if " + text + " is present in " + locator);
    asserts(getLocators(locator, elementType)).isEqualTo(text);
  }

  @Override
  protected void load() {}

  @Override
  protected void isLoaded() throws Error {}
}
