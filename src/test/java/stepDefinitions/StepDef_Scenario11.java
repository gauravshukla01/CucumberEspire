//package stepDefinitions;
//
//import CommmonUtils.ExcelUtil;
//import CommmonUtils.TestContext;
//import TestResourceManager.WebDrivermanager;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import pageObjects.POManagementPage;
//import pageObjects.SalesInvoicePage;
//import pageObjects.SalesOrderPage;
//
//public class StepDef_Scenario11 {
//
//	TestContext testContext;
//
//	WebDrivermanager webdrivermanager;
//	SalesOrderPage salesOrderPg;
//	SalesInvoicePage salesInvoicePg;
//	POManagementPage poManagementPage;
//	String methodName;
//
//	public StepDef_Scenario11(TestContext tstContext) {
//		testContext = tstContext;
//
//		salesOrderPg = testContext.getPageObjectManager().getSalesOrderPage();
//		salesInvoicePg = testContext.getPageObjectManager().getSalesInvoicePage();
//		poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
//	}
//
//
//	@And("User navigate to the Receipt Tab and click on required Checkbox for scenario11")
//	public void user_navigate_to_the_receipt_tab_and_click_on_required_checkbox_for_scenario11() throws InterruptedException {
//
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//		try {
//			String UTnumber = poManagementPage.validateRecieptForCancelSOLine(testContext.Hmap.get("Index ID"));
//			System.out.println("UTNumer from scenario 2 = "+UTnumber);
//			testContext.Hmap.put("UTNumber", UTnumber);
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("Navigate to finance sales order page")
//	public void navigate_to_finance_sales_order_page() throws InterruptedException {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//		try {
//			salesOrderPg.goToSaleOrderPg();
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("User click on Campaign number")
//	public void user_click_on_campaign_number() throws InterruptedException {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//		try {
//			String CampID = testContext.Hmap.get("UTNumber");
//			System.out.println("camp id ="+CampID);
//			String CID [] = CampID.split("-");
//			String UTNumber = CID[0].trim();
//			//String UTNumber = UTN.trim();
//			System.out.println("UTNumber = "+UTNumber);
//			salesOrderPg.clickOnReceiptedCampaign(UTNumber);
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//
//
//	}
//
//	@And("Select Campaign item number Checkbox and Click on Cancel Sales Order Lines")
//	public void select_campaign_item_number_checkbox_and_click_on_cancel_sales_order_lines() throws InterruptedException {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//
//		try {
//			salesOrderPg.clickOnCheckBoxToCancelSOLines(testContext.Hmap.get("UTNumber"));
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("Select the Cancellation Reason and Fill the Reason")
//	public void select_the_cancellation_reason_and_fill_the_reason() {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//			salesOrderPg.SaleslineCancellationReason();
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@And("Click on Confirm")
//	public void click_on_confirm() {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//		try {
//			salesOrderPg.SaleslineCancellationReasonConfirmation();
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//	@Then("Verify the sales order cancellation Popup")
//	public void verify_the_sales_order_cancellation_popup() throws InterruptedException {
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//
//		try {
//			salesOrderPg.VerifySOLineStatus(testContext.Hmap.get("UTNumber"));
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
//
//
//}
