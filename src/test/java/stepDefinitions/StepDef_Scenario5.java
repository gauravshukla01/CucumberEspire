package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import otherResources.TestContext;
import pageObjects.EproCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.POManagementPage;
import pageObjects.QuoteManagementPage;

public class StepDef_Scenario5 {

	TestContext testContext;
	EproHomePage eprohome;
	EproCampaignPage eprocamppage;
	QuoteManagementPage quoteManage;
	WebDrivermanager webdrivermanager;
	POManagementPage poManagementPage;
 
	public StepDef_Scenario5(TestContext tstContext) {
		testContext = tstContext;
		eprohome = testContext.getPageObjectManager().getEproHomePage();
		eprocamppage = testContext.getPageObjectManager().getEproCampaignPage();
		quoteManage = testContext.getPageObjectManager().getQuoteManagementPage();
		poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
		webdrivermanager = testContext.getWebDriverManager();
	}
	
	@And("On Campaign Item Page and search for Camp Number and User will Send and the create PO")
	public void On_Campaign_Item_Page_and_search_for_Camp_Number_and_user_will_send_and_the_create_po() throws InterruptedException {
		eprohome.ClkCampaign();
		eprocamppage.clickOnCampID("123test");
		eprocamppage.SendAndCreatePO();
		String indCampID = eprocamppage.getIndexValue();
		testContext.Hmap.put("Index ID", indCampID);
 
	}
}
