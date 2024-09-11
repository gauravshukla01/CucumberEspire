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

	WebDrivermanager webdrivermanager;
	SalesOrderPage salesOrderPg;
	SalesInvoicePage salesInvoicePg;

	public StepDef_Scenario3(TestContext tstContext) {
		testContext = tstContext;

		salesOrderPg = testContext.getPageObjectManager().getSalesOrderPage();
		salesInvoicePg = testContext.getPageObjectManager().getSalesInvoicePage();
	}

	@Then("User get the Campaign id for PO Receipted and navigate to Sales Order page")
	public void User_get_the_Campaign_id_for_PO_Receipted_and_navigate_to_Sales_Order_page()
			throws InterruptedException {
		salesOrderPg.goToCampaingPg();
		salesOrderPg.searchItem("PO Receipted");
		String campId = salesOrderPg.getCampIdPOReciept("PO Receipted");
		testContext.Hmap.put("Camp_Id", campId);
		salesOrderPg.clickOnCampID("PO Receipted", 1);
		String indexcampId = salesOrderPg.getIndexCampId("PO Receipted");
		testContext.Hmap.put("index_campId", indexcampId);
		salesOrderPg.goToSaleOrderPg();
		salesOrderPg.searchItem(campId);
		salesOrderPg.clickOnCampID(campId, 2);

	}

	@Then("User will Create Draft Invoice")
	public void user_will_create_draft_invoice() throws InterruptedException {

		salesOrderPg.createDraftInvoice(testContext.Hmap.get("index_campId"));
	}

	@And("Click on Finance and navigate to Sales Invoice")
	public void click_on_finance_and_navigate_to_sales_invoice() throws InterruptedException {
		salesOrderPg.goToCampaingPg();
		salesOrderPg.searchItem(testContext.Hmap.get("Camp_Id"));
		salesOrderPg.clickOnCampID(testContext.Hmap.get("Camp_Id"), 1);
		// salesInvoicePg.getCampIdDraftInvoiced("Draft Invoiced");
		String pdfName = salesInvoicePg.getPDFPOname();
		testContext.Hmap.put("PDF_Name", pdfName);
		salesInvoicePg.goToSaleInvoicePg();

	}

	@And("Click on resepctive Invoice number \\(Manage Invoice)")
	public void click_on_resepctive_invoice_number_manage_invoice() throws InterruptedException {
		salesOrderPg.clickOnCampID(testContext.Hmap.get("Camp_Id"), 2);
		salesInvoicePg.clickOnInvoiceNo(testContext.Hmap.get("PDF_Name"));
		salesInvoicePg.clickOnCheckboxs(testContext.Hmap.get("index_campId"));
	}

	@Then("User will send Final Invoice to customer")
	public void user_will_send_final_invoice_to_customer() throws Throwable {
		
		salesInvoicePg.SendFinalInvoice();
		//System.out.println("Scenario_3_completed");
	}

}