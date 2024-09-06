package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import otherResources.TestContext;


@RunWith(Cucumber.class)
@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports"
				},
     
		features = "src\\test\\resources\\Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
        ,tags = "@EproCampaignCreation2 and @Scenario8"
)

public class TestRunner {
	
	TestContext testcontext;
	
	public TestRunner() {
			
	}
	


	

	}
    //Sample comment  This comment is added in testrunner file. 
//Sample comment  This comment is added in testrunner file. 