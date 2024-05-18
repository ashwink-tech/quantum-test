package steps.onemap.searchaddress;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.onemap.searchaddress.SearchAddress;

import static com.quantum.framework.browser.Browser.getDriver;
import static com.quantum.framework.controls.BrowserActions.pressEnter;
import static com.quantum.framework.controls.BrowserValidation.isElementNotPresent;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchAddressSteps {

    SearchAddress searchAddress;
    public SearchAddressSteps(SearchAddress searchAddress) {
        this.searchAddress = searchAddress.get();
    }

    @When("The user enters the {string} using Search Address field")
    public void inputData(String address) {
        searchAddress.searchAddress(address);
    }

    @When("The user clicks on {string}:{string}")
    public void clickOnElement(String locator, String elementType) {
        searchAddress.clickOnElement(locator, elementType);
    }

    @Given("The user press enters on {string}:{string}")
    public void pressEnterOnElement(String locator, String elementType) {
        pressEnter(getDriver.get(), searchAddress.getLocators(locator, elementType));
    }

    @Then("Verify {string}:{string} is not present on One Map")
    public void verifyElementNotDisplayed(String locator, String elementType) {
        assertThat(isElementNotPresent(getDriver.get(),
          searchAddress.getLocators(locator, elementType))).isTrue();
    }
}
