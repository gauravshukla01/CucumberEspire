package stepDefinitions;

import CommmonUtils.BaseAction;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.AddCampaignItemPage;
import pageObjects.AmazonHomePage;
import pageObjects.EditCampaignItemPage;
import pageObjects.EproCampaignPage;
import pageObjects.EproCreateCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;
import pageObjects.ManageCampaignPage;
import pageObjects.ManagePricePage;
import pageObjects.QuoteManagementPage;
import pageObjects.SubmitSupplierPricePage;

public class StepDef_Scenario1 {
	
	
	TestContext testContext;
    EproLoginPage eprologin;
    EproHomePage eprohome;
    EproCampaignPage eprocamppage;
    EproCreateCampaignPage eprocreatecamp;	
	AddCampaignItemPage addCampaignItem;
	EditCampaignItemPage editCampPage;
	SubmitSupplierPricePage submitSupplier;
	ManagePricePage managePrice;
    QuoteManagementPage quoteManage;
    ManageCampaignPage manageCampPage;
    WebDrivermanager webdrivermanager;
    
    
	
	
    public StepDef_Scenario1(TestContext tstContext) {
		testContext = tstContext;
		eprologin = testContext.getPageObjectManager().getEproLoginPage();
		eprohome = testContext.getPageObjectManager().getEproHomePage();
		eprocamppage = testContext.getPageObjectManager().getEproCampaignPage();
		eprocreatecamp = testContext.getPageObjectManager().getEproCreateCampaignPage();
		addCampaignItem = testContext.getPageObjectManager().getAddCampaignItemPage();
		editCampPage = testContext.getPageObjectManager().getEditCampaignItemPage();
		submitSupplier = testContext.getPageObjectManager().getSubmitSpplierPricePage();
		managePrice = testContext.getPageObjectManager().getManagePricePage();
		manageCampPage = testContext.getPageObjectManager().getManageCampaignPage();
		quoteManage = testContext.getPageObjectManager().getQuoteManagementPage();

	}

	@Given("User launches Epro url")
	public void User_launches_Epro_url() {
		eprologin.launchurl("https://uat.paragon-epro.com/");
		System.out.println("Browser launched");

	}

	@Then("^user login with valid (.*) and (.*)$")
	public void user_login_with_valid_staginguser_and_password(String Username, String Password) {
		eprologin.EnterUsernameAndPassword(Username, Password);
		System.out.println("User Credentials entered");
		eprologin.Clksubmit();
	}

	@And("user navigate to Campaign page and create campaign")
	public void user_navigate_to_campaign_page_and_create_campaign() throws InterruptedException {
		eprohome.ClkCampaign();
		eprocamppage.clkAddCampaign();
		eprocreatecamp.fillRequiredDetails();
		eprocreatecamp.submitCreateCampaignDetails();
		eprocreatecamp.ValidateCreateCampaignPopUp();

		String CampaignId = eprocreatecamp.storeCampaignID();
		testContext.Hmap.put("CampaignId", CampaignId);
		System.out.println("Campaign created successfully");

	}

	@Then("User add new Item in the Campaign using Create New Item button")
	public void user_add_new_item_in_the_campaign_using_create_new_item_button() throws InterruptedException {

		eprocamppage.clickOnCampaignId(testContext.Hmap.get("CampaignId"));
		System.out.println("Campaign ID =" + testContext.Hmap.get("CampaignId"));
		addCampaignItem.addItemDetails();
		System.out.println("Campaign item added successfully");
	}

	@Then("Verify Campaign status as Created")
	public void verify_campaign_status_as_created_add_this_step() {
		addCampaignItem.validateCreateCampaignPopup();
		
	}

	@And("Click on Submit for Costing button")
	public void click_on_submit_for_costing_button() throws InterruptedException {
		manageCampPage.DetailsForsubmitCosting();
		manageCampPage.validateItemAddedPopup();
		manageCampPage.ClicksubmitCostingButton();
		manageCampPage.validateSubmitCostPopup();
		System.out.println("Costing submitted for campaign item successfully");
	}

	@And("User will add Supplier Cost using Submit supplier button")
	public void user_will_add_supplier_cost_using_submit_supplier_button() throws InterruptedException {
		manageCampPage.clickSupplierPricebutton();
		submitSupplier.addSupplierPriceDetails();
		submitSupplier.validateSubmitSupplierCostPopup();
		System.out.println("Supplier price submitted successfully");
	}

	@And("User will manage the supplier price and add all required details")
	public void user_will_manage_the_supplier_price_and_add_all_required_details() throws InterruptedException {
		manageCampPage.selectSupplierPrice();
		manageCampPage.validateItemSelectedPopup();
		manageCampPage.CreateQuote();
		manageCampPage.validateQuoteGeneratedPopup();
		System.out.println("Quote has been generated successfully");

	}

	@And("User will navigate to Quote Managment tab and generate quote")
	public void user_will_navigate_to_quote_managment_tab_and_generate_quote() throws InterruptedException {
		
		quoteManage.verifyQuote();
	}

	@And("User will accept the quote on clicking of Quote Accepted button")
	public void user_will_accept_the_quote_on_clicking_of_quote_accepted_button() {
		quoteManage.acceptQuote();

	}

	@Then("Verify status as Quote Accepted on Campaign Item Page")
	public void verify_status_as_quote_accepted_on_campaign_item_page() {

		quoteManage.validateAcceptQuotePopup();
	}

	
	

}