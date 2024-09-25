//package stepDefinitions;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import CommmonUtils.TestContext;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import pageObjects.EproLoginPage;
//
//public class Hooks{
//
//	TestContext testContext;
//	WebDriver driver ;
//
//	public Hooks(TestContext tstContext) {
//		testContext = tstContext;
//		driver = testContext.getWebDriverManager().getDriver();
//
//	}
//	private static final Logger logger = LogManager.getLogger(Hooks.class);
//
//
//
//	@Before
//	public void BeforeSteps() {
//		// driver = testContext.getWebDriverManager().getDriver(); // Ensure driver is initialized here
//	}
//
//
//
//	@AfterStep 
//	public void takeScreenshot(Scenario scenario) {
//		//   WebDriver driver = testContext.getWebDriverManager().getDriver(); // Use the instance from TestContext
//		try {
//			if (driver != null) {
//				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//				scenario.attach(screenshot, "image/png", "image");
//				String stepname = scenario.getName();
//				logger.info("Screenshot captured :"+ stepname);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	  @After public void teardown() { driver.close();
//	  logger.info("Scenario completed"); }
//	 
//
//}
//
//
//
//
////  testContext.getWebDriverManager().closeDriver(); }
////Sample comment
//
//
