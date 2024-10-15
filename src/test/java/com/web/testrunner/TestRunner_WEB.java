package com.web.testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports",
				"rerun:target/failed.txt"
				},
     
		features = "src/test/java/com/web/features"
        ,glue={"com.web.stepDefinitions"}
        ,dryRun = false
        ,monochrome = true
        ,tags = "@Login"
)

public class TestRunner_WEB extends AbstractTestNGCucumberTests
{	
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

	}
}

	 
