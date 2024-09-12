
package testrunner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports","rerun:target/failed.txt",	
		},
		features = "src\\test\\resources\\Stories"
		,glue={"stepDefinitions","Hooks"}
		,dryRun = false
		,monochrome = true
		,tags = "@Scenario11-EPA-1 or  @Scenario12-EPA-2"
		)

public class TestRunner extends AbstractTestNGCucumberTests
{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();

	}
}