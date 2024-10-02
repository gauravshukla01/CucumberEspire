package testrunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import commonUtils.AzureClient;
import commonUtils.BaseClass;
import commonUtils.CucumberRetryListener;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

			plugin = { "summary","pretty", "html:target1/cucumber-reports.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target1/cucumber-reports"
					},
			features = "@target/failed.txt"
	        ,glue={"stepDefinitions"}
	        ,dryRun = false
	        ,monochrome = true
	)

public class TestRunnerFailed extends AbstractTestNGCucumberTests {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		if(driver==null) {
		
		new BaseClass().launchBrowser();
		
		driver=BaseClass.getDriver();
		
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		
		if(driver !=null)
		{
		driver.quit();
		driver=null;
		}
	}
	
//	 @Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
	
//	@AfterTest
//	public void createDefectWhenTestFail(Scenario scenario) throws IOException {
//		
//		if(scenario.isFailed()) {
//			
//			BaseClass.saveScreenshotToFile(scenario);
//			AzureClient.createDefectInAzureDevOps("Test case failed",scenario);
//			
//		}
//	}

}