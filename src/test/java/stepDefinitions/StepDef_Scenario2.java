package stepDefinitions;
 
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import CommmonUtils.BaseClass;
import CommmonUtils.ExcelData;
import CommmonUtils.ExcelUtil;
//import CommmonUtils.TestContext;
import TestResourceManager.FileReaderManager;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.PageObjectManager;
//import pageObjects.AddCampaignItemPage;
//import pageObjects.EditCampaignItemPage;
//import pageObjects.EproCampaignPage;
//import pageObjects.EproCreateCampaignPage;
//import pageObjects.EproHomePage;
//import pageObjects.EproLoginPage;
//import pageObjects.ManageCampaignPage;
//import pageObjects.ManagePricePage;
//import pageObjects.POManagementPage;
//import pageObjects.PageObjectManager;
//import pageObjects.QuoteManagementPage;
//import pageObjects.SubmitSupplierPricePage;
import testrunner.TestRunner;
 
public class StepDef_Scenario2 extends TestRunner {
 
	String methodName;
	HashMap<String,String> Hmap;
	private BaseClass baseclass;
	public static WebDriver driver;
	
	
	private static final Logger logger = LogManager.getLogger(StepDef_Scenario1.class);
	String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	ExcelData exceldata = new ExcelData();
	
     public StepDef_Scenario2(BaseClass baseclass) {
		
		this.baseclass=baseclass;
		driver = baseclass.getDriver();		
	}
     
     @Given("Duplicate User launches Epro url and login with valid from sheetname {string} and rownum {int}")
 	public void duplicate_user_launches_epro_url_and_login_with_valid_from_Sheetname_and_Rownum(String sheetname, int rownum) throws Exception {

 		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
 		try {
 			
 			logger.info("Launching application");
 			
 			driver.get(appUrl);
 			
 			logger.info("Launched application");
 			
 			logger.info("Loggin into application");
 			
 			String username = exceldata.getDataFromExcel("Epro.xlsx", sheetname, rownum, "UserName");
 			String password = exceldata.getDataFromExcel("Epro.xlsx", sheetname, rownum, "Password");
 			System.out.println(username);
 			System.out.println(password);

 		    PageObjectManager.getEproLoginPage(driver).LoginIntoApplication(username, password);
 		    
 		    logger.info("Logged into application");

 		}
 		catch(Exception e) {
 			
 			e.printStackTrace();
 			ExcelUtil.logExceptionInExcel(methodName, e.toString());
 			throw e;
 		}
 	}
 
//	@And("On Campaign Item Page verify Status as Quote Accepted and User will Send and the create PO")
//	public void On_Campaign_Item_Page_verify_Status_as_Quote_Accepted_and_user_will_send_and_the_create_po() throws InterruptedException {
//		
//		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		try {
//		eprohome.ClkCampaign();
//		eprocamppage.clickOnCampID("Quote Accepted");
//		String indCampID = eprocamppage.getIndexValue();
//		eprocamppage.SendPO();
//		testContext.Hmap.put("Index ID", indCampID);
//		}
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
// 
//	@Then("Verify Status as PO Created after creating the PO on Campaign Item Page")
//	public void verify_status_as_po_created_after_creating_the_po_on_campaign_item_page() throws InterruptedException {
//		try {
//			eprocamppage.CreatePO(); }
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
// 
//	@And("User will navigate to Finance page to create receipt")
//	public void user_will_navigate_to_finance_page_to_create_receipt() throws InterruptedException {
//		try { 
//			poManagementPage.goToFinance(); }
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
// 
//	@Then("User will upload POD document")
//	public void user_will_upload_pod_document() throws InterruptedException {
// 
//		try {
//			poManagementPage.uploadPOD(testContext.Hmap.get("Index ID")); }
//		catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}//add underscore
//		}
//		//poManagementPage.download();
//	
// 
//	@And("Verify Has POD column status with green tick")
//	public void verify_has_pod_column_status_with_green_tick() {
//		try { 
//			System.out.println("pod status verified, green tick enabled");  // need assertion
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//	}
// 
//	@And("User navigate to the Receipt Tab and click on required Checkbox")
//	public void user_navigate_to_the_receipt_tab_and_click_on_required_checkbox() throws InterruptedException {
//		
//		try { 
//			poManagementPage.validateReciept(testContext.Hmap.get("Index ID"));
//		}catch(Exception e) {
//			System.out.println("In Catch Block");
//			e.printStackTrace();
//			ExcelUtil.logExceptionInExcel(methodName, e.toString());
//			throw e;
//		}
//           
//		
//	}
// 
//	@Then("Verify Receipted column status with green tick")
//	public void verify_receipted_column_status_with_green_tick() {
//		System.out.println("Receipt status verified");
//		// webdrivermanager.closeDriver();
//	}
// 
}