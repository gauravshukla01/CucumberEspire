package testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonUtils.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports",
				"rerun:target/failed.txt"
				},
     
		features = "src\\test\\java\\features"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
        ,tags = "@Login"
)

public class TestRunner extends AbstractTestNGCucumberTests
{	
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
	/*
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

	}*/
}

	 
