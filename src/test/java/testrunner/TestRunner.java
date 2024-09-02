
package testrunner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
       //plugin = { "pretty", "html:target/cucumber-reports.html" },
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports","rerun:target/failed.txt"
				},
      // this needs to be localized
//		features = "C:\\Users\\chetan.patel\\Epro_Workspace\\Epro\\CucumberEspire\\src\\test\\resources\\Stories\\Epro.feature"
		features = "src\\test\\resources\\Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
//        ,tags = "@Scenario1"
)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

	}
}