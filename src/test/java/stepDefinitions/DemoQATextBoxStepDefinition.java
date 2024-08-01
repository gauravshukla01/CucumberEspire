package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import CommmonUtils.BaseAction;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import otherResources.TestContext;
import pageObjects.DemoQATextBoxPage;

public class DemoQATextBoxStepDefinition {


	DemoQATextBoxPage dqtbp;
	TestContext testContext;
	private WebDriver driver;
	 private BaseAction baseaction;

	public DemoQATextBoxStepDefinition(TestContext tstContext){
		testContext = tstContext;
		dqtbp = testContext.getPageObjectManager().getDemoQaTextBoxPage();
		this.driver = testContext.getWebDriverManager().getDriver();
	}
	

	@Given("User enter and Launches website {string}")
	public void user_enter_and_launches_website(String url) {

		dqtbp.openDemoQATextBoxPage(url);

		System.out.println("Launching the Demo QA Website");

	}

	@When("User click on element")
	public void user_click_on_element() {

		dqtbp.clickOnElementButton();

		System.out.println("Clicking on Element Button");

	}

	@When("User click on Text Box")
	public void user_click_on_text_box() {

		dqtbp.clickonTextBoxButton();

		System.out.println("Clicking on Text Box Button");
	}

	@When("User enter the name (.*)$")
	public void user_enter_the_name(String fullname) {

		dqtbp.enterFullNameField(fullname);
	}

	@When("User enter the mail (.*)$")
	public void user_enter_the_mail(String email) {

		dqtbp.enterEmailAddress(email);
	}

	@When("User enter the current address (.*)$")
	public void user_enter_the_current_address(String curadd) {

		dqtbp.enterCurrentAdd(curadd);
	}

	@When("User enter the Permanent address (.*)$")
	public void user_enter_the_permanent_address(String peradd) {

		dqtbp.enterPermanentAdd(peradd);
	}

	@When("User click on submit")
	public void user_click_on_submit() {

		dqtbp.clickonSubmitButton();
	}

	@Then("User will visible enter details")
	public void user_will_visible_enter_details() {
		
		System.out.println("User able to view Enter Details");

	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(screenshot,"img/png",scenario.getName());
	}



}
