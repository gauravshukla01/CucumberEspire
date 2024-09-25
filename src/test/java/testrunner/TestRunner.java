package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import CommmonUtils.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports"
				},
     
		features = "src\\test\\java\\features"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
        ,tags = "@EproCampaignCreation2"
)

public class TestRunner extends AbstractTestNGCucumberTests
{	
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		new BaseClass().launchBrowser();
	}
	
	@AfterClass
	public void closeBrowser() {
		
		BaseClass.driver.close();
	}
	/*
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

	}*/
}

	 
