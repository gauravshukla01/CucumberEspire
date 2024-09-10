package stepDefinitions;

import CommmonUtils.ExcelUtil;
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
	
	
	 @Then("User get the Campaign id for PO Receipted and navigate to Sales Order page")
	 public void User_get_the_Campaign_id_for_PO_Receipted_and_navigate_to_Sales_Order_page() throws InterruptedException {
		 String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		 try {
		 salesOrderPg.goToCampaingPg();
		 salesOrderPg.searchItem("PO Receipted");
		 String campId = salesOrderPg.getCampIdPOReciept("PO Receipted");
		 testContext.Hmap.put("Camp_Id", campId);
		 salesOrderPg.clickOnCampID("PO Receipted",1);
		 String indexcampId = salesOrderPg.getIndexCampId("PO Receipted");
		 testContext.Hmap.put("index_campId", indexcampId);
		 salesOrderPg.goToSaleOrderPg();
		 salesOrderPg.searchItem(campId);
		 salesOrderPg.clickOnCampID(campId,2);
		 }
			catch(Exception e) {
				System.out.println("In Catch Block");
				e.printStackTrace();
				ExcelUtil.logExceptionInExcel(methodName, e.toString());
				throw e;
			}
		 
	 }
	 

	@Then("User will Create Draft Invoice")
	public void user_will_create_draft_invoice() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
	  try {
	   salesOrderPg.createDraftInvoice(testContext.Hmap.get("index_campId"));
	  }
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("Click on Finance and navigate to Sales Invoice")
	public void click_on_finance_and_navigate_to_sales_invoice() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
	    salesOrderPg.goToCampaingPg();
	    salesOrderPg.searchItem(testContext.Hmap.get("Camp_Id"));
	    salesOrderPg.clickOnCampID(testContext.Hmap.get("Camp_Id"),1);
	   // salesInvoicePg.getCampIdDraftInvoiced("Draft Invoiced");
	    String pdfName = salesInvoicePg.getPDFPOname();
	    testContext.Hmap.put("PDF_Name", pdfName);
	    salesInvoicePg.goToSaleInvoicePg();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("Click on resepctive Invoice number \\(Manage Invoice)")
	public void click_on_resepctive_invoice_number_manage_invoice() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		salesOrderPg.clickOnCampID(testContext.Hmap.get("Camp_Id"),2);
		salesInvoicePg.clickOnInvoiceNo(testContext.Hmap.get("PDF_Name"));
		salesInvoicePg.clickOnCheckboxs(testContext.Hmap.get("index_campId"));
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("User will send Final Invoice to customer")
	public void user_will_send_final_invoice_to_customer() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
	   System.out.println("Scenario_3_completed");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}




}
