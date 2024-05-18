package pages.onemap.searchresults;

import com.quantum.framework.exceptionhandling.QuantumCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.quantum.framework.config.Constants.TEXT;
import static com.quantum.framework.controls.BrowserValidation.isDisplayed;

public class InfoBox extends BasePage<InfoBox> {

    private static MultiKeyMap<String, String> infoBoxMultiLocs = new MultiKeyMap<>();

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, TXT_INFO_TITLE)) {
            throw new QuantumCustomException("Info Box component was not successfully loaded");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return infoBoxMultiLocs.get(locator, elementType);
    }

    private static final String TXT_INFO_TITLE = "//div[@id='markerInfoTitle']";

    static {
        infoBoxMultiLocs.put("Info Title", TEXT, TXT_INFO_TITLE);
        infoBoxMultiLocs.put("Info Name", TEXT, "//div[@id='markerInfoContent']/span");
        infoBoxMultiLocs.put("Info Address", TEXT, "(//div[@id='markerInfoContent']/span)[2]");
        infoBoxMultiLocs.put("Info Position", TEXT, "//div[@id='markerInfoPos']/span");
    }
}
