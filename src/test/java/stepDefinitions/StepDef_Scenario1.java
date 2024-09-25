package stepDefinitions;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import CommmonUtils.BaseClass;
import CommmonUtils.ExcelData;
import CommmonUtils.ExcelUtil;
import TestResourceManager.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import pageObjects.AddCampaignItemPage;
//import pageObjects.EditCampaignItemPage;
//import pageObjects.EproCampaignPage;
//import pageObjects.EproCreateCampaignPage;
//import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;
//import pageObjects.ManageCampaignPage;
//import pageObjects.ManagePricePage;
//import pageObjects.PageObjectManager;
//import pageObjects.QuoteManagementPage;
//import pageObjects.SubmitSupplierPricePage;
import pageObjects.PageObjectManager;

public class StepDef_Scenario1 {
	
	String methodName;
	HashMap<String,String> Hmap;
	private BaseClass baseclass;
	public static WebDriver driver;
	
	
	private static final Logger logger = LogManager.getLogger(StepDef_Scenario1.class);
	String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	ExcelData exceldata = new ExcelData();
	
	public StepDef_Scenario1(BaseClass baseclass) {
		
		this.baseclass=baseclass;
		driver = baseclass.getDriver();		
	}
			
	@Given("User launches Epro url and login with valid from sheetname {string} and rownum {int}")
	public void user_launches_epro_url_and_login_with_valid_from_Sheetname_and_Rownum(String sheetname, int rownum) throws Exception {

		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			
			logger.info("Launching application");
			
			driver.get(appUrl);
			
			logger.info("Launched application");
			
			logger.info("Loggin into application");
			
			String username = exceldata.getDataFromExcel("Epro.xlsx", sheetname, rownum, "UserName");
			String password = exceldata.getDataFromExcel("Epro.xlsx", sheetname, rownum, "Password");
			System.out.println(username);
			System.out.println(password);

		    PageObjectManager.getEproLoginPage(driver).LoginIntoApplication(username, password);
		    
		    logger.info("Logged into application");

		}
		catch(Exception e) {
			
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
	
//	@And("user navigate to Campaign page and create campaign")
//	public void user_navigate_to_campaign_page_and_create_campaign() throws InterruptedException, InvalidFormatException, IOException {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//
//
//			eprohome.ClkCampaign();
//			eprocamppage.clkAddCampaign();
//
//			String campaign_Title = exceldata.getcampaign_Title(RowNumber, SheetName);
//			String Customer_campaign_reference = exceldata.getCustomer_campaign_reference(RowNumber, SheetName);
//			String VAT = exceldata.getVAT(RowNumber, SheetName);
//			String Purchase_Order_number = exceldata.getPurchase_Order_number(RowNumber, SheetName);
//			String Purchase_Order_value = exceldata.getPurchase_Order_value(RowNumber, SheetName);
//
//			eprocreatecamp.fillRequiredDetails(campaign_Title,Customer_campaign_reference,VAT,Purchase_Order_number,Purchase_Order_value);
//			eprocreatecamp.submitCreateCampaignDetails();
//			eprocreatecamp.ValidateCreateCampaignPopUp();
//
//			String CampaignId = eprocreatecamp.storeCampaignID();
//			//testContext.Hmap.put("CampaignId", CampaignId);
//			Hmap.put("CampaignId", CampaignId);
//			System.out.println("Campaign created successfully");
//
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//
//	}
//
//	@Then("User add new Item in the Campaign using Create New Item button")
//	public void user_add_new_item_in_the_campaign_using_create_new_item_button() throws InterruptedException, InvalidFormatException, IOException {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try { 
//
//			eprocamppage.clickOnCampaignId(Hmap.get("CampaignId"));
//			System.out.println("Campaign ID =" + Hmap.get("CampaignId"));
//			String Number_of_items = exceldata.getNumber_of_items(RowNumber, SheetName);
//			String Quantity = exceldata.getQuantity(RowNumber, SheetName);
//
//			addCampaignItem.addItemDetails(Number_of_items,Quantity);
//			System.out.println("Campaign item added successfully");
//
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@Then("Verify Campaign status as Created")
//	public void verify_campaign_status_as_created_add_this_step() {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try { 
//			addCampaignItem.validateCreateCampaignPopup();
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("Click on Submit for Costing button")
//	public void click_on_submit_for_costing_button() throws InterruptedException {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//			manageCampPage.DetailsForsubmitCosting();
//			manageCampPage.validateItemAddedPopup();
//			manageCampPage.ClicksubmitCostingButton();
//			manageCampPage.validateSubmitCostPopup();
//			System.out.println("Costing submitted for campaign item successfully");
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("User will add Supplier Cost using Submit supplier button")
//	public void user_will_add_supplier_cost_using_submit_supplier_button() throws InterruptedException, InvalidFormatException, IOException {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//			manageCampPage.clickSupplierPricebutton();
//
//			String Supplier = exceldata.getSupplier(RowNumber, SheetName);
//			String Estimate_Reference_number =exceldata.getEstimate_Reference_number(RowNumber, SheetName);
//			String Delivery =exceldata.getDelivery(RowNumber, SheetName);
//			String Paper_cost =exceldata.getPaper_cost(RowNumber, SheetName);
//			String Production_cost =exceldata.getProduction_cost(RowNumber, SheetName);
//
//
//			submitSupplier.addSupplierPriceDetails(Supplier,Estimate_Reference_number,Delivery,Paper_cost,Production_cost);
//			submitSupplier.validateSubmitSupplierCostPopup();
//			System.out.println("Supplier price submitted successfully");
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("User will manage the supplier price and add all required details")
//	public void user_will_manage_the_supplier_price_and_add_all_required_details() throws InterruptedException {
//
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//			manageCampPage.selectSupplierPrice();
//			manageCampPage.validateItemSelectedPopup();
//			manageCampPage.CreateQuote();
//			manageCampPage.validateQuoteGeneratedPopup();
//			System.out.println("Quote has been generated successfully");
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//
//	}
//
//	@And("User will navigate to Quote Managment tab and generate quote")
//	public void user_will_navigate_to_quote_managment_tab_and_generate_quote() throws InterruptedException {
//
//
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {quoteManage.verifyQuote();
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("User will accept the quote on clicking of Quote Accepted button")
//	public void user_will_accept_the_quote_on_clicking_of_quote_accepted_button() {
//
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {quoteManage.acceptQuote();
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//
//	}
//
//	@Then("Verify status as Quote Accepted on Campaign Item Page")
//	public void verify_status_as_quote_accepted_on_campaign_item_page() {
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//			quoteManage.validateAcceptQuotePopup(); }
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
	
//	@After
//	public void closeBrowser() {
//		driver.close();
//	}

}
