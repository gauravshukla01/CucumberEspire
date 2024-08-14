package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
       //plugin = { "pretty", "html:target/cucumber-reports.html" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
      // this needs to be localized
		features = "C:\\Users\\rahul\\Workspace3\\CucumberEspire\\src\\test\\resources\\Stories\\Epro.feature"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = false
        ,tags = "@Scenario2"
)

public class TestRunner {
	
	// after giving a tag @Before we can add any logic that we wish to execute before test case execution// same as @After

}
    //Sample comment  This comment is added in testrunner file. 
//Sample comment  This comment is added in testrunner file. 