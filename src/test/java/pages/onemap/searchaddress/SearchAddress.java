package pages.onemap.searchaddress;

import com.quantum.framework.controls.BrowserNavigation;
import com.quantum.framework.controls.BrowserWaits;
import com.quantum.framework.exceptionhandling.QuantumCustomException;
import com.quantum.framework.helper.SeleniumHelper;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

import static com.quantum.framework.config.Constants.DROPDOWN;
import static com.quantum.framework.config.Constants.INPUT;
import static com.quantum.framework.controls.BrowserValidation.isDisplayed;
import static com.quantum.framework.factories.GetBaseUrlFactory.getBaseUrl;
import static com.quantum.framework.helper.SeleniumHelper.*;

public class SearchAddress extends BasePage<SearchAddress> {

    private static MultiKeyMap<String, String> searchLocationMultiLocs = new MultiKeyMap<>();

    public SearchAddress()  {
        navigateToPageIfNotLoaded(getBaseUrl());
    }

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, IP_ADDRESS)) {
            throw new QuantumCustomException("Search Location component was not successfully loaded");
        }
    }

    public void searchAddress(String address) {
        enterValue(address, IP_ADDRESS);
        getElement(driver, IP_ADDRESS).sendKeys(Keys.SPACE);
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return searchLocationMultiLocs.get(locator, elementType);
    }

    private static final String IP_ADDRESS   = "//input[@id='search_property']";
    private static final String DD_ADDRESS   = "//span[@id='searchresult_name' and text()='MILLENIA WALK']";

    static {
        searchLocationMultiLocs.put("Address", INPUT, IP_ADDRESS);
        searchLocationMultiLocs.put("Address", DROPDOWN, DD_ADDRESS);
    }
}
