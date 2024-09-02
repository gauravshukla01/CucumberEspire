package testrunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import otherResources.CucumberRetryListener;

@CucumberOptions(
	       //plugin = { "pretty", "html:target/cucumber-reports.html" },
			plugin = { "summary","pretty", "html:target1/cucumber-reports.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target1/cucumber-reports"
					},
	      // this needs to be localized
//			features = "C:\\Users\\chetan.patel\\Epro_Workspace\\Epro\\CucumberEspire\\src\\test\\resources\\Stories\\Epro.feature"
			features = "@target/failed.txt"
	        ,glue={"stepDefinitions"}
	        ,dryRun = false
	        ,monochrome = true
//	        ,tags = "@Scenario1"
	)
@Listeners(CucumberRetryListener.class)
public class TestRunnerFailed extends AbstractTestNGCucumberTests {
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

}
}
