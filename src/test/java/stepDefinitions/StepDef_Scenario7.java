package stepDefinitions;

import CommmonUtils.ExcelUtil;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.manualInvoicePage;

public class StepDef_Scenario7 {
	

	
	TestContext testContext;
	manualInvoicePage manualinvoicepg;
	WebDrivermanager webdrivermanager;
	String methodName;
	/*EproHomePage eprohome;
	EproCampaignPage eprocamppage;
	QuoteManagementPage quoteManage;
	POManagementPage poManagementPage;*/
 
	public StepDef_Scenario7(TestContext tstContext) {
		testContext = tstContext;
		manualinvoicepg = testContext.getPageObjectManager().getmanualInvoicePage();
		webdrivermanager = testContext.getWebDriverManager();
	}
	
	
	@Given("Verify Send Final Invoice")
	public void verify_send_final_invoice() throws InterruptedException {
	  
		try {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		 manualinvoicepg.goToManualInvoicePage();
		 manualinvoicepg.sendFinalInvoice(testContext.Hmap.get("InvoiceNo"), 1);
		System.out.println("Hello");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("Do On-Hold Invoice under Final Invoice")
	public void do_on_hold_invoice_under_final_invoice() throws InterruptedException {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manualinvoicepg.goToFinalInvoiceTab_And_DoOnHold(testContext.Hmap.get("InvoiceNo"), 1);
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
		
	}

	@And("Do Release Invoice under On-Hold Invoice")
	public void do_release_invoice_under_on_hold_invoice() throws InterruptedException {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manualinvoicepg.gotToOnHoldInvoiceTab_And_DoRelease(testContext.Hmap.get("InvoiceNo"), 1);
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("Do Post invoice under Final Invoice")
	public void do_post_invoice_under_final_invoice() throws InterruptedException {
		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manualinvoicepg.postFinalInvoice(testContext.Hmap.get("InvoiceNo"), 1);
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("Verify the details under the Post invoice Tab")
	public void verify_the_details_under_the_post_invoice_tab() throws InterruptedException {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manualinvoicepg.gotToPostInvoiceTab_And_Validate_data(testContext.Hmap.get("InvoiceNo"), 1);
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
	
	
	
	
}
