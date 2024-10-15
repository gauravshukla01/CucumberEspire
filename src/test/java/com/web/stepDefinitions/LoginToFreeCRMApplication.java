package com.web.stepDefinitions;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.web.pageObjects.HomePage;
import com.web.pageObjects.LoginPage;
import com.web.pageObjects.PageObjectManager;
import com.web.testContext.TestContext;

import commonUtils.BaseClass;
import commonUtils.ExcelData;
import commonUtils.ExcelUtil;
import io.cucumber.java.en.*;
import testResourceManager.FileReaderManager;


public class LoginToFreeCRMApplication {
	
	HashMap<String,String> Hmap;
	BaseClass baseclass;
	public WebDriver driver;
	PageObjectManager pageObjectManager;
	TestContext testContext;
	
	private static final Logger logger = LogManager.getLogger(LoginToFreeCRMApplication.class);
	String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	ExcelData exceldata = new ExcelData();
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginToFreeCRMApplication (TestContext testContext) throws Exception{
		
		this.testContext=testContext;
		loginPage=testContext.getPageObjectManager().getFreeCRMLoginPage();
		homePage=testContext.getPageObjectManager().getFreeCRMHomePage();
	}
	
	@Given("^user navigate to FreeCRM application login page$")	
	public void user_navigate_to_FreeCRM_application_login_page()
	{
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		logger.info("Launching application");
		
		loginPage.navigateToApplication(appUrl);
		
		logger.info("Launched application");
		}
		
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
		
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM()
	{		
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		String title=loginPage.getPageTitle();

		Assert.assertEquals(title,"Cogmento CRM","Application page title is not correct");
		}
		catch(Exception e) {
				System.out.println("In Catch Block");
				e.printStackTrace();
				ExcelUtil.logExceptionInExcel(methodName, e.toString());
				throw e;
		}
	}
	
	@Then("user get login credentials from {string} and {int} and proceed with login")
	public void user_get_login_credentials_from_sheetName_and_rowNum_and_proceed_with_login(String sheetName,int rowNum) throws InvalidFormatException, IOException
	{
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		logger.info("Loggin into application");
		
		String username = exceldata.getDataFromExcel("FreeCRMApplication.xlsx", sheetName, rowNum, "UserName");
		String password = exceldata.getDataFromExcel("FreeCRMApplication.xlsx", sheetName, rowNum, "Password");
		loginPage.enterCredentialsAndLoginIntoApplication(username, password);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
	}

	}
	
	@Then("^user should land on FreeCRM application homepage$")
	public void verify_user_is_on_home_page()
	{
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		String userName=homePage.getUserName();
		Assert.assertTrue(userName.contains("Avinash TS"));
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
	}
	}
	
	@Then("^user will logout from application$")
	public void verify_user_will_logout_from_application() {
		
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		homePage.logOutFromApplication();
		Assert.assertTrue(loginPage.isUserNameTextBoxDisplayed(),"Application not logged out");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
	}
	}

}
