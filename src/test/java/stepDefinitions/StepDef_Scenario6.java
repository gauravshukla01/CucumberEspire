package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.EproCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.POManagementPage;
import pageObjects.QuoteManagementPage;
import pageObjects.manualInvoicePage;

public class StepDef_Scenario6 
{
	
	TestContext testContext;
	manualInvoicePage manualinvoicepg;
	WebDrivermanager webdrivermanager;
	/*EproHomePage eprohome;
	EproCampaignPage eprocamppage;
	QuoteManagementPage quoteManage;
	POManagementPage poManagementPage;*/
 
	public StepDef_Scenario6(TestContext tstContext) {
		testContext = tstContext;
		manualinvoicepg = testContext.getPageObjectManager().getmanualInvoicePage();
		webdrivermanager = testContext.getWebDriverManager();
	}
	
	@Given("Navigate to finance and click on create manual invoice")
	public void navigate_to_finance_and_click_on_create_manual_invoice() throws Throwable {
	   manualinvoicepg.goToManualInvoicePage();
	    manualinvoicepg.manualInvoiceDetailsandClickAddLine();
		String manualInvoiceNo =  manualinvoicepg.createManualInvoice();
		  testContext.Hmap.put("InvoiceNo", manualInvoiceNo);
	   
	}

	@And("Send Final Invoice")
	public void send_final_invoice() throws InterruptedException 
	{
		 manualinvoicepg.goToManualInvoicePage();
		 manualinvoicepg.sendFinalInvoice(testContext.Hmap.get("InvoiceNo"), 1);
	   
	}

	@Then("Post final invoice to customer")
	public void post_final_invoice_to_customer() throws InterruptedException 
	{
		manualinvoicepg.goToManualInvoicePage();
		 manualinvoicepg.postFinalInvoice(testContext.Hmap.get("InvoiceNo"), 1);
	    
	}

}
