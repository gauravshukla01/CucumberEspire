package stepDefinitions;

import io.cucumber.java.en.*;
import otherResources.TestContext;
import pageObjects.ZohoSignInPage;

public class zohoStepDefinitions {

	TestContext testContext;
	ZohoSignInPage zsp;
	
	//Constructor
	public zohoStepDefinitions(TestContext tstContext){
		testContext = tstContext;
		zsp = testContext.getPageObjectManager().getZohoSignInPage();
	}
	
	// Browser Launch
	@Given("User launches url {string}")
	public void user_launches(String url) throws InterruptedException {

		zsp.openZohoSignInPage(url);

		System.out.println("Launch Zoho Sign in Page");

	}
	//user email id
	@When("User enter email {string}")
	public void user_enter_email(String email) {

		zsp.enterEmailId(email);

		System.out.println("Entering the Email in Email Field");

	}

	//Click on Next button
	@When("User click on Next")
	public void user_click_on_next() {
	 
		zsp.clickNextButton();
		
		System.out.println("Clicking on Next Button");
	   
	}

	//user Password
	@When("User enter password {string}")
	public void user_enter_password(String password) {
	    
		zsp.enterPassword(password);
		
		System.out.println("Entering the Password in Password field");
	    
	}

	//Click on Sign in button
	@When("User click on Sign in")
	public void user_click_on_sign_in() {
	
	  zsp.clickSignInButton();
	  
	  System.out.println("Clicking on Sign In Button");
	}

	//Home Page
	@Then("User on Home Page")
	public void user_on_home_page() {
	
		System.out.println("User on Home Page of Zoho");
	    
	}




}
