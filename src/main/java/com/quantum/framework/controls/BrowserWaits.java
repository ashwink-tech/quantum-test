package com.quantum.framework.controls;

import com.quantum.framework.config.Constants;
import com.quantum.framework.helper.WaitHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.quantum.framework.controls.BrowserValidation.*;
import static com.quantum.framework.helper.SeleniumHelper.getElement;
import static com.quantum.framework.helper.WaitHelper.*;
import static java.time.Duration.*;
import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BrowserWaits {

    private BrowserWaits() {
        throw new IllegalStateException("BrowserWaits class");
    }

    public static final Function<WebDriver, WebDriverWait> getLongWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.LONG_WAIT));

    public static final Function<WebDriver, WebDriverWait> getMediumWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.MEDIUM_WAIT));

    public static final BiConsumer<WebDriverWait, String> waitForPresence = (wait, sLocator) -> {
        wait.until(visibilityOfElementLocated(xpath(sLocator)));
        wait.until(presenceOfElementLocated(xpath(sLocator)));
      };

    public static final BiConsumer<WebDriver, String> waitMethod = (driver, sLocator) ->
        waitForPresence.accept(getLongWait.apply(driver), sLocator);

    public static final BiConsumer<WebDriver, String> waitTillElementNotPresent = (driver, sLocator) ->
        getLongWait.apply(driver).until(invisibilityOfElementLocated(xpath(sLocator)));

    public static final Consumer<WebDriver> waitForPageLoad =
      (driver) -> driver.manage().timeouts().pageLoadTimeout(ofSeconds(30));

    public static final BiConsumer<WebDriver, String> waitToDisplay =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for an element to display")
        .until(getElement(driver, sLocator)::isDisplayed);

    public static final BiConsumer<WebDriver, String> waitForElement =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for an element presence")
        .untilAsserted(() -> assertThat(isElementPresent(driver, sLocator)).isTrue());

    public static final BiConsumer<WebDriver, String> waitForClickableElement =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for an element to be clickable")
        .ignoreExceptions()
        .untilAsserted(() -> assertThat(isElementClickable(driver, sLocator)).isTrue());
}
