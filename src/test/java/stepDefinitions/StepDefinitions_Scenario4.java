package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.POManagementPage;

public class StepDefinitions_Scenario4 {
	WebDrivermanager webdrivermanager;
	TestContext testContext;
	POManagementPage poManagementPage;
	
	public StepDefinitions_Scenario4(TestContext tstContext) {
		testContext = tstContext;
		poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
		webdrivermanager = testContext.getWebDriverManager();
	}
	
	@Then("Click on Donwload button under action tab")
	public void click_on_donwload_button_under_action_tab() throws InterruptedException {
		poManagementPage.downloadPDF("Purchase Order");
	}
}
