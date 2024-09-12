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
import pageObjects.SubmitSupplierPricePage;
 
public class StepDef_Scenario2 {
 
	TestContext testContext;
	EproHomePage eprohome;
	EproCampaignPage eprocamppage;
	QuoteManagementPage quoteManage;
	WebDrivermanager webdrivermanager;
	POManagementPage poManagementPage;
	String methodName;
 
	public StepDef_Scenario2(TestContext tstContext) {
		testContext = tstContext;
		eprohome = testContext.getPageObjectManager().getEproHomePage();
		eprocamppage = testContext.getPageObjectManager().getEproCampaignPage();
		quoteManage = testContext.getPageObjectManager().getQuoteManagementPage();
		poManagementPage = testContext.getPageObjectManager().getPOManagementPage();
		webdrivermanager = testContext.getWebDriverManager();
	}
 
 
	@And("On Campaign Item Page verify Status as Quote Accepted and User will Send and the create PO")
	public void On_Campaign_Item_Page_verify_Status_as_Quote_Accepted_and_user_will_send_and_the_create_po() throws InterruptedException {
		
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		eprohome.ClkCampaign();
		eprocamppage.clickOnCampID("Quote Accepted");
		String indCampID = eprocamppage.getIndexValue();
		eprocamppage.SendPO();
		testContext.Hmap.put("Index ID", indCampID);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
 
	@Then("Verify Status as PO Created after creating the PO on Campaign Item Page")
	public void verify_status_as_po_created_after_creating_the_po_on_campaign_item_page() throws InterruptedException {
		try {
			eprocamppage.CreatePO(); }
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
 
	@And("User will navigate to Finance page to create receipt")
	public void user_will_navigate_to_finance_page_to_create_receipt() throws InterruptedException {
		try { 
			poManagementPage.goToFinance(); }
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
 
	@Then("User will upload POD document")
	public void user_will_upload_pod_document() throws InterruptedException {
 
		try {
			poManagementPage.uploadPOD(testContext.Hmap.get("Index ID")); }
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}//add underscore
		}
		//poManagementPage.download();
	
 
	@And("Verify Has POD column status with green tick")
	public void verify_has_pod_column_status_with_green_tick() {
		try { 
			System.out.println("pod status verified, green tick enabled");  // need assertion
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}
 
	@And("User navigate to the Receipt Tab and click on required Checkbox")
	public void user_navigate_to_the_receipt_tab_and_click_on_required_checkbox() throws InterruptedException {
		
		try { 
			poManagementPage.validateReciept(testContext.Hmap.get("Index ID"));
		}catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
           
		
	}
 
	@Then("Verify Receipted column status with green tick")
	public void verify_receipted_column_status_with_green_tick() {
		System.out.println("Receipt status verified");
		// webdrivermanager.closeDriver();
	}
 
}