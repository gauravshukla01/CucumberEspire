package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.Credit_InvoicePage;
import pageObjects.manualInvoicePage;

public class StepDef_Scenario9 
{
	TestContext testContext;
	Credit_InvoicePage creditInvoicePg;
	manualInvoicePage manualinvoicepg;
	WebDrivermanager webdrivermanager;
	/*EproHomePage eprohome;
	EproCampaignPage eprocamppage;
	QuoteManagementPage quoteManage;
	POManagementPage poManagementPage;*/
 
	public StepDef_Scenario9(TestContext tstContext) {
		testContext = tstContext;
		creditInvoicePg = testContext.getPageObjectManager().getCredit_InvoicePage();
		manualinvoicepg=testContext.getPageObjectManager().getmanualInvoicePage();
		webdrivermanager = testContext.getWebDriverManager();
		
	}
	
	
		@And("Do On-Hold Invoice under Final Invoice for credit invoice")
	public void do_on_hold_invoice_under_final_invoice_for_credit_invoice() throws InterruptedException {
		creditInvoicePg.goToFinalInvoiceTab_And_DoOnHold(testContext.Hmap.get("CrInvoiceNo"), 1);
		
	}

	@And("Do Release Invoice under On-Hold Invoice for credit invoice")
	public void do_release_invoice_under_on_hold_invoice_for_credit_invoice() throws InterruptedException {
		creditInvoicePg.gotToOnHoldInvoiceTab_And_DoRelease(testContext.Hmap.get("CrInvoiceNo"), 1);
	
	}

	@And("Do Post invoice under Final Invoice for credit invoice")
	public void do_post_invoice_under_final_invoice_for_credit_invoice() throws InterruptedException {
		creditInvoicePg.clickOnPostInvoiceTab (testContext.Hmap.get("CrInvoiceNo"), 1);
		
		
	}

	@Then("Verify the details under the Post invoice Tab for credit invoice")
	public void verify_the_details_under_the_post_invoice_tab_for_credit_invoice() throws InterruptedException {
		creditInvoicePg.goToPostInvoiceTab_And_Validate_data(testContext.Hmap.get("CrInvoiceNo"), 1);
	}
	
	
	
	
}



