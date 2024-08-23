package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import otherResources.TestContext;
import pageObjects.EproLoginPage;

public class Hooks{

	TestContext testContext;
	WebDriver driver ;

	public Hooks(TestContext tstContext) {
		testContext = tstContext;
		driver = testContext.getWebDriverManager().getDriver();

	}

	@Before
	public void BeforeSteps() {
		// driver = testContext.getWebDriverManager().getDriver(); // Ensure driver is initialized here
	}



	@AfterStep 
	public void takeScreenshot(Scenario scenario) {
		//   WebDriver driver = testContext.getWebDriverManager().getDriver(); // Use the instance from TestContext
		try {
			if (driver != null) {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "image");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown() {
		
		driver.close();
	}
	
}


//  testContext.getWebDriverManager().closeDriver(); }
//Sample comment


