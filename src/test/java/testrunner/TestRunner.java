package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        features = "src/test/resources/Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = false
        ,tags = "@TextBox"
)

public class TestRunner {
	
	// after giving a tag @Before we can add any logic that we wish to execute before test case execution// same as @After

}
