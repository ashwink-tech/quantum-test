package runner;

import com.quantum.framework.config.GlobalConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.quantum.framework.utilities.LogUtil.info;
import static com.quantum.framework.utilities.LogUtil.setLogger;
import static java.lang.System.getProperty;

@CucumberOptions(
    features = "features/",
    glue = {"steps"},
    plugin = {
      "json:target/cucumber.json",
      "html:target/site/cucumber-pretty",
      "rerun:target/rerun.txt",
    },
    monochrome = true,
    tags = "not @Skip")
public class TestRunner extends AbstractTestNGCucumberTests {

  @BeforeClass
  public void beforeSetup() {
    info("Setting the Values of GlobalConfig files");
    GlobalConfigReader.getProperty();
    setLogger();
  }

  @AfterSuite
  public void generateReport() {
    File reportOutputDirectory = new File("target");
    List<String> jsonReport = new ArrayList<>();
    jsonReport.add("target/cucumber.json");
    String projectName = "UI-Automation";
    String buildNumber = "1";

    Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    configuration.setBuildNumber(buildNumber);
    configuration.addClassifications("Platform", getProperty("os.name"));
    configuration.addClassifications("Browser", getProperty("browser"));

    ReportBuilder reportBuilder = new ReportBuilder(jsonReport, configuration);
    reportBuilder.generateReports();
  }

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
