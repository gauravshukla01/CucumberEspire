package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import otherResources.TestContext;



@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports"
				},
     
		features = "src\\test\\resources\\Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
        ,tags = "@EproCampaignCreation2 and @Scenario6"
)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	TestContext testcontext;
	
	public TestRunner() {
			
	}
	


	

	}
    //Sample comment  This comment is added in testrunner file. 
//Sample comment  This comment is added in testrunner file. 