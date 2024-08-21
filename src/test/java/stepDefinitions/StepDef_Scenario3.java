package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.AddCampaignItemPage;
import pageObjects.EditCampaignItemPage;
import pageObjects.EproCampaignPage;
import pageObjects.EproCreateCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;
import pageObjects.ManageCampaignPage;
import pageObjects.ManagePricePage;
import pageObjects.POManagementPage;
import pageObjects.QuoteManagementPage;
import pageObjects.SalesInvoicePage;
import pageObjects.SalesOrderPage;
import pageObjects.SubmitSupplierPricePage;

public class StepDef_Scenario3 {
	
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
    POManagementPage poManagementPage;
    SalesOrderPage salesOrderPg;
    SalesInvoicePage salesInvoicePg;
    
	
	
	 public StepDef_Scenario3(TestContext tstContext){
	        testContext = tstContext;
	      
	        eprologin = testContext.getPageObjectManager().getEproLoginPage();
	        eprohome =  testContext.getPageObjectManager().getEproHomePage();
	        eprocamppage =  testContext.getPageObjectManager().getEproCampaignPage();
	        eprocreatecamp =  testContext.getPageObjectManager().getEproCreateCampaignPage();
	        addCampaignItem = testContext.getPageObjectManager().getAddCampaignItemPage();
	        editCampPage = testContext.getPageObjectManager().getEditCampaignItemPage();
	        submitSupplier = testContext.getPageObjectManager().getSubmitSpplierPricePage();
	        managePrice = testContext.getPageObjectManager().getManagePricePage();
	        manageCampPage = testContext.getPageObjectManager().getManageCampaignPage();
	        quoteManage = testContext.getPageObjectManager().getQuoteManagementPage();
	        poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
	        salesOrderPg = testContext.getPageObjectManager().getSalesOrderPage();
	        salesInvoicePg = testContext.getPageObjectManager().getSalesInvoicePage();
	    }
	
	
	 @Then("User get the required Campaign id for PO Receipted")
	 public void user_get_the_required_campaign_id_for_po_receipted() throws InterruptedException {
		 salesOrderPg.goToCampaingPg();
		 salesOrderPg.clickOnCampId("UT01667");
	     salesOrderPg.getCampIdPOReciept("PO Receipted");
	 }
	 
	@And("Click on Finance and navigate to Sales Order")
	public void click_on_finance_and_navigate_to_sales_order() {
	   
		 salesOrderPg.goToSaleOrderPg();
		 salesOrderPg.clickOnCampId("UT01667");
	}

	@Then("User will Create Draft Invoice")
	public void user_will_create_draft_invoice() throws InterruptedException {
	   salesOrderPg.createDraftInvoice();
	}

	@And("Click on Finance and navigate to Sales Invoice")
	public void click_on_finance_and_navigate_to_sales_invoice() throws InterruptedException {
	    salesOrderPg.goToCampaingPg();
	    salesOrderPg.clickOnCampId("UT01667");
	    salesInvoicePg.getCampIdDraftInvoiced("Draft Invoiced");
	    salesInvoicePg.getPDFPOname();
	    salesInvoicePg.goToSaleInvoicePg();
	    
	}

	@And("Click on resepctive Invoice number \\(Manage Invoice)")
	public void click_on_resepctive_invoice_number_manage_invoice() throws InterruptedException {
		salesOrderPg.clickOnCampId("UT01667");
		salesInvoicePg.clickOnInvoiceNo();
		salesInvoicePg.clickOnCheckboxs();
	}

	@Then("User will send Final Invoice to customer")
	public void user_will_send_final_invoice_to_customer() {
	   System.out.println("Scenario_3_completed");
	}




}