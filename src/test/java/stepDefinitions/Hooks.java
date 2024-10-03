package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonUtils.AzureClient;
import commonUtils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{

	public BaseClass baseclass;
	public static WebDriver driver;

	public Hooks(BaseClass baseclass) {
		
		this.baseclass=baseclass;
		Hooks.driver = BaseClass.getDriver();

	}
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	
	
	@AfterStep 
	public void takeScreenshot(Scenario scenario) {
		
		try {
			if (driver != null) {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "image");
				String stepname = scenario.getName();
				logger.info("Screenshot captured :"+ stepname);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



