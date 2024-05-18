package steps.onemap.searchresults;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.onemap.searchresults.InfoBox;

import java.util.Map;

import static com.quantum.framework.config.Constants.TEXT;
import static com.quantum.framework.helper.CucumberHelper.getDataTable;

public class InfoBoxSteps {
    InfoBox infoBox;
    public InfoBoxSteps(InfoBox infoBox) {
        this.infoBox = infoBox;
    }

    @Then("Verify following details are present on Info Box")
    public void verifyText(DataTable details) {
        for (Map<String, String> dataTableColumns : getDataTable(details)) {
            infoBox.isEqualTo(dataTableColumns.get("Detail"), TEXT, dataTableColumns.get("Text"));
        }
    }
}
