package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestResourceManager.FileReaderManager;
import commonUtils.AzureClient;
import commonUtils.BaseClass;
import commonUtils.ExcelData;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;


public class LoginToFreeCRMApplication {
	
	String methodName;
	HashMap<String,String> Hmap;
	public BaseClass baseclass;
	public static WebDriver driver;
	PageObjectManager pageObjectManager;
	
	private static final Logger logger = LogManager.getLogger(LoginToFreeCRMApplication.class);
	String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	ExcelData exceldata = new ExcelData();
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginToFreeCRMApplication (BaseClass baseclass){
		
		this.baseclass=baseclass;
		LoginToFreeCRMApplication.driver = BaseClass.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		loginPage=pageObjectManager.getFreeCRMLoginPage();
		homePage=pageObjectManager.getFreeCRMHomePage();
	}
	
	@Given("^user navigate to FreeCRM application login page$")	
	public void user_navigate_to_FreeCRM_application_login_page()
	{
		logger.info("Launching application");
		
		System.out.println(driver);
		
		System.out.println("Driver before navigating to application:" + driver);
		
		driver.get(appUrl);
		
		logger.info("Launched application");
		
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM()
	{
		System.out.println("Driver before checking application title:" + driver);
		
		String title=loginPage.getPageTitle();

		Assert.assertEquals(title,"Cogmento CRM","Application page title is not correct");
	}
	
	@Then("user get login credentials from {string} and {int} and proceed with login")
	public void user_get_login_credentials_from_sheetName_and_rowNum_and_proceed_with_login(String sheetName,int rowNum) throws InvalidFormatException, IOException
	{
		logger.info("Loggin into application");
		
		String username = exceldata.getDataFromExcel("FreeCRMApplication.xlsx", sheetName, rowNum, "UserName");
		String password = exceldata.getDataFromExcel("FreeCRMApplication.xlsx", sheetName, rowNum, "Password");
		loginPage.enterCredentialsAndLoginIntoApplication(username, password);

	}
	
	@Then("^user should land on FreeCRM application homepage$")
	public void verify_user_is_on_home_page()
	{
		String userName=homePage.getUserName();
		Assert.assertTrue(userName.contains("Avinash TS"));
	}
	
	@Then("^user will logout from application$")
	public void verify_user_will_logout_from_application() {
		homePage.logOutFromApplication();
		Assert.assertTrue(loginPage.isUserNameTextBoxDisplayed(),"Application not logged out");
	}
	
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
	
	@AfterStep
	public void createDefectWhenTestFail(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			
			BaseClass.saveScreenshotToFile(scenario);
			AzureClient.createDefectInAzureDevOps("Test case failed",scenario);
			
		}
	}



}
