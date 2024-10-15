package com.api.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                 features = "src//test//java//com//api//features",
                  glue = {"com.api.stepDefinitions"},
                  tags = "@getFeature or @putFeature or @postFeature",
                  plugin = {
                		  "summary","pretty", "html:target/cucumber-reports.html",
          				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
          				  "json:target/cucumber-reports",
          				   "rerun:target/failed.txt" },
                  monochrome = true)

public class TestRunner_API extends AbstractTestNGCucumberTests{

}
