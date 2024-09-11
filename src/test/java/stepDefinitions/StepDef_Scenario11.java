package stepDefinitions;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.POManagementPage;
import pageObjects.SalesInvoicePage;
import pageObjects.SalesOrderPage;

public class StepDef_Scenario11 {
	
	TestContext testContext;

	WebDrivermanager webdrivermanager;
	SalesOrderPage salesOrderPg;
	SalesInvoicePage salesInvoicePg;
	POManagementPage poManagementPage;
	
	public StepDef_Scenario11(TestContext tstContext) {
		testContext = tstContext;

		salesOrderPg = testContext.getPageObjectManager().getSalesOrderPage();
		salesInvoicePg = testContext.getPageObjectManager().getSalesInvoicePage();
		poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
	}
	
	
	@And("User navigate to the Receipt Tab and click on required Checkbox for scenario11")
	public void user_navigate_to_the_receipt_tab_and_click_on_required_checkbox_for_scenario11() throws InterruptedException {
		
		String UTnumber = poManagementPage.validateRecieptForCancelSOLine(testContext.Hmap.get("Index ID"));
            System.out.println("UTNumer from scenario 2 = "+UTnumber);
		testContext.Hmap.put("UTNumber", UTnumber);
	}
	
	@And("Navigate to finance sales order page")
	public void navigate_to_finance_sales_order_page() throws InterruptedException {
	salesOrderPg.goToSaleOrderPg();
	}

	@And("User click on Campaign number")
	public void user_click_on_campaign_number() throws InterruptedException {
		
		String CampID = testContext.Hmap.get("UTNumber");
		System.out.println("camp id ="+CampID);
		String CID [] = CampID.split("-");
		String UTNumber = CID[0].trim();
		//String UTNumber = UTN.trim();
		System.out.println("UTNumber = "+UTNumber);
		salesOrderPg.clickOnReceiptedCampaign(UTNumber);
		
		
	
	}

	@And("Select Campaign item number Checkbox and Click on Cancel Sales Order Lines")
	public void select_campaign_item_number_checkbox_and_click_on_cancel_sales_order_lines() throws InterruptedException {
		
		
		salesOrderPg.clickOnCheckBoxToCancelSOLines(testContext.Hmap.get("UTNumber"));
	}

	@And("Select the Cancellation Reason and Fill the Reason")
	public void select_the_cancellation_reason_and_fill_the_reason() {
		salesOrderPg.SaleslineCancellationReason();
	}

	@And("Click on Confirm")
	public void click_on_confirm() {
		
		salesOrderPg.SaleslineCancellationReasonConfirmation();
	  
	}

	@Then("Verify the sales order cancellation Popup")
	public void verify_the_sales_order_cancellation_popup() throws InterruptedException {
		salesOrderPg.VerifySOLineStatus(testContext.Hmap.get("UTNumber"));
	    
	}


}
