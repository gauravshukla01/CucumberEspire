package stepDefinitions;

import CommmonUtils.ExcelUtil;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.*;
import otherResources.TestContext;
import pageObjects.Credit_InvoicePage;
import pageObjects.EproCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.POManagementPage;
import pageObjects.QuoteManagementPage;
import pageObjects.SalesOrderPage;

public class StepDef_Scenario8 {

	TestContext testContext;
	
	WebDrivermanager webdrivermanager;
	Credit_InvoicePage creditInvoicePg;
	String methodName;
 
	public StepDef_Scenario8(TestContext tstContext) {
		
		testContext = tstContext;
		webdrivermanager = testContext.getWebDriverManager();
		creditInvoicePg = testContext.getPageObjectManager().getCredit_InvoicePage();
	}
	
	
	
	@And("User go to Credit Invoice page and create a Credit Invoice")
	public void user_go_to_credit_invoice_page_and_create_a_credit_invoice() throws Throwable {
	  		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
	  creditInvoicePg.goToCreditInvoicePg();
	  creditInvoicePg.enterDetailsAndclickAddline();
	 String CrInvoice = creditInvoicePg.createCreditInvoice();
	  testContext.Hmap.put("CrInvoiceNo", CrInvoice);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("User will send the Final credit invoice")
	public void user_will_send_the_final_credit_invoice() throws Throwable {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		creditInvoicePg.goToCreditInvoicePg();
		 creditInvoicePg.sendFinalCRInvoice(testContext.Hmap.get("CrInvoiceNo"), 1);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
	
	@And("User will post the credit invoice")
	public void User_will_post_the_credit_invoice() throws InterruptedException {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		 creditInvoicePg.goToCreditInvoicePg();
		 creditInvoicePg.postFinalCRInvoice(testContext.Hmap.get("CrInvoiceNo"), 1);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
	
	@Then("User will download the posted credit invoice")
	public void User_will_download_the_posted_credit_invoice() throws Throwable {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
		 creditInvoicePg.goToCreditInvoicePg();
		 creditInvoicePg.downloadPostedInvoice(testContext.Hmap.get("CrInvoiceNo"));
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

}
