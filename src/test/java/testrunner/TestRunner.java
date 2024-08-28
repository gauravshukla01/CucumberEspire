
package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import otherResources.TestContext;


@RunWith(Cucumber.class)
@CucumberOptions(
       //plugin = { "pretty", "html:target/cucumber-reports.html" },
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports"
				},
      // this needs to be localized
//		features = "C:\\Users\\chetan.patel\\Epro_Workspace\\Epro\\CucumberEspire\\src\\test\\resources\\Stories\\Epro.feature"
		features = "src\\test\\resources\\Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
//        ,tags = "@Scenario1 and @Scenario2 and @Scenario3"
)

public class TestRunner {
	
	TestContext testcontext;
	
	public TestRunner() {
			
	}
	


	

	}
