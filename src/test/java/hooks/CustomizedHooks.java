package hooks;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import TestContext.TestContext;
import commonUtils.AzureClient;
import commonUtils.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;


public class CustomizedHooks {
	
	public BaseClass baseclass;
	public WebDriver driver;

	public CustomizedHooks(TestContext testContext) {
		
      this.driver=testContext.getWebDriver();
      
	}
	private static final Logger logger = LogManager.getLogger(CustomizedHooks.class);
	
	@AfterStep
	public void createDefectWhenTestFail(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			
			BaseClass.saveScreenshotToFile(scenario);
			AzureClient.createDefectInAzureDevOps("Test case failed",scenario);
			
		}
	}

}
