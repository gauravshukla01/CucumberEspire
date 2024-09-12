package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import CommmonUtils.ExcelUtil;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.ExcelData;
import otherResources.TestContext;
import pageObjects.AddCampaignItemPage;
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
	ExcelData exceldata;
	private int RowNumber;
	private String SheetName;
	String methodName;




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
		exceldata = new ExcelData();

	}


	private static final Logger logger = LogManager.getLogger(StepDef_Scenario1.class);



	@Given("User launches Epro url and login with valid from Sheetname {string} and Rownum {int}")
	public void user_launches_epro_url_and_login_with_valid_from_Sheetname_and_Rownum(String Sheetname, Integer Rownum) throws InvalidFormatException, IOException {


		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			eprologin.launchurl("https://uat.paragon-epro.com/");
			logger.info("Browser Launched");
			this.SheetName=Sheetname;
			this.RowNumber=Rownum;
			String Username = exceldata.getUserName(RowNumber, SheetName);

			String Password = exceldata.getPassword(RowNumber, SheetName);

			System.out.println("User Credentials entered: " + Username + " / " + Password);

			eprologin.EnterUsernameAndPassword(Username, Password);

			eprologin.Clksubmit();

		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}


	@And("user navigate to Campaign page and create campaign")
	public void user_navigate_to_campaign_page_and_create_campaign() throws InterruptedException, InvalidFormatException, IOException {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {


			eprohome.ClkCampaign();
			eprocamppage.clkAddCampaign();

			String campaign_Title = exceldata.getcampaign_Title(RowNumber, SheetName);
			String Customer_campaign_reference = exceldata.getCustomer_campaign_reference(RowNumber, SheetName);
			String VAT = exceldata.getVAT(RowNumber, SheetName);
			String Purchase_Order_number = exceldata.getPurchase_Order_number(RowNumber, SheetName);
			String Purchase_Order_value = exceldata.getPurchase_Order_value(RowNumber, SheetName);

			eprocreatecamp.fillRequiredDetails(campaign_Title,Customer_campaign_reference,VAT,Purchase_Order_number,Purchase_Order_value);
			eprocreatecamp.submitCreateCampaignDetails();
			eprocreatecamp.ValidateCreateCampaignPopUp();

			String CampaignId = eprocreatecamp.storeCampaignID();
			testContext.Hmap.put("CampaignId", CampaignId);
			System.out.println("Campaign created successfully");

		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}

	}

	@Then("User add new Item in the Campaign using Create New Item button")
	public void user_add_new_item_in_the_campaign_using_create_new_item_button() throws InterruptedException, InvalidFormatException, IOException {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try { 

			eprocamppage.clickOnCampaignId(testContext.Hmap.get("CampaignId"));
			System.out.println("Campaign ID =" + testContext.Hmap.get("CampaignId"));
			String Number_of_items = exceldata.getNumber_of_items(RowNumber, SheetName);
			String Quantity = exceldata.getQuantity(RowNumber, SheetName);

			addCampaignItem.addItemDetails(Number_of_items,Quantity);
			System.out.println("Campaign item added successfully");

		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("Verify Campaign status as Created")
	public void verify_campaign_status_as_created_add_this_step() {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try { 
			addCampaignItem.validateCreateCampaignPopup();
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("Click on Submit for Costing button")
	public void click_on_submit_for_costing_button() throws InterruptedException {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			manageCampPage.DetailsForsubmitCosting();
			manageCampPage.validateItemAddedPopup();
			manageCampPage.ClicksubmitCostingButton();
			manageCampPage.validateSubmitCostPopup();
			System.out.println("Costing submitted for campaign item successfully");
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will add Supplier Cost using Submit supplier button")
	public void user_will_add_supplier_cost_using_submit_supplier_button() throws InterruptedException, InvalidFormatException, IOException {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			manageCampPage.clickSupplierPricebutton();

			String Supplier = exceldata.getSupplier(RowNumber, SheetName);
			String Estimate_Reference_number =exceldata.getEstimate_Reference_number(RowNumber, SheetName);
			String Delivery =exceldata.getDelivery(RowNumber, SheetName);
			String Paper_cost =exceldata.getPaper_cost(RowNumber, SheetName);
			String Production_cost =exceldata.getProduction_cost(RowNumber, SheetName);


			submitSupplier.addSupplierPriceDetails(Supplier,Estimate_Reference_number,Delivery,Paper_cost,Production_cost);
			submitSupplier.validateSubmitSupplierCostPopup();
			System.out.println("Supplier price submitted successfully");
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will manage the supplier price and add all required details")
	public void user_will_manage_the_supplier_price_and_add_all_required_details() throws InterruptedException {

		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			manageCampPage.selectSupplierPrice();
			manageCampPage.validateItemSelectedPopup();
			manageCampPage.CreateQuote();
			manageCampPage.validateQuoteGeneratedPopup();
			System.out.println("Quote has been generated successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}

	}

	@And("User will navigate to Quote Managment tab and generate quote")
	public void user_will_navigate_to_quote_managment_tab_and_generate_quote() throws InterruptedException {


		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {quoteManage.verifyQuote();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will accept the quote on clicking of Quote Accepted button")
	public void user_will_accept_the_quote_on_clicking_of_quote_accepted_button() {

		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {quoteManage.acceptQuote();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}

	}

	@Then("Verify status as Quote Accepted on Campaign Item Page")
	public void verify_status_as_quote_accepted_on_campaign_item_page() {
		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			quoteManage.validateAcceptQuotePopup(); }
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

}
