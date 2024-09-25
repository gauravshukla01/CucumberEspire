package pageObjects;

import org.openqa.selenium.WebDriver;

import CommmonUtils.BaseClass;

public class PageObjectManager extends BaseClass {

	WebDriver driver;
	private static EproLoginPage eprologin;
//	private static AmazonHomePage amazonHomePage;
//  private static ZohoSignInPage zohoSignPage;
//  private static DemoQATextBoxPage textBoxPage;
//	private static EproHomePage eprohome;
//	private static EproCampaignPage eprocamp;
//	private static EproCreateCampaignPage eprocreatecamp;
//	private static AddCampaignItemPage addCampItemPAge;
//	private static EditCampaignItemPage editCampPage;
//	private static ManageCampaignPage manageCampPage;
//	private static ManagePricePage managePricePage;
//	private static POManagementPage poManagementPage;
//	private static QuoteManagementPage quoteManagePage;
//	private static SalesInvoicePage salesInvoicePage;
//	private static SalesOrderPage salesOrderPage;
//	private static SubmitSupplierPricePage submitSupplierPricePage;
//	private static manualInvoicePage manualinvoicepg;
//	private static Credit_InvoicePage creditInvoicePg;

	public static synchronized EproLoginPage getEproLoginPage(WebDriver driver){

		return (eprologin==null) ? eprologin=new EproLoginPage(driver) : eprologin;

	} 

//	public static synchronized amazonHomePage getAmazonHomePage(WebDriver driver){
//
//		return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;
//
//	}
//
//	public static synchronized ZohoSignInPage getZohoSignInPage(WebDriver driver){
//
//		return (zohoSignPage==null) ? zohoSignPage=new ZohoSignInPage(driver) : zohoSignPage;
//
//	}
//
//	public static synchronized DemoQATextBoxPage getDemoQaTextBoxPage(WebDriver driver){
//
//		return (textBoxPage==null) ? textBoxPage=new DemoQATextBoxPage(driver) : textBoxPage;
//
//	} 
//
//	public static synchronized EproHomePage getEproHomePage(WebDriver driver){
//
//		return (eprohome==null) ? eprohome=new EproHomePage(driver) : eprohome;
//
//	} 
//	public static synchronized EproCampaignPage getEproCampaignPage(WebDriver driver){
//
//		return (eprocamp==null) ? eprocamp=new EproCampaignPage(driver) : eprocamp;
//
//	} 
//
//	public static synchronized AddCampaignItemPage getAddCampaignItemPage(WebDriver driver){
//
//		return (addCampItemPAge==null) ? addCampItemPAge =new AddCampaignItemPage(driver) : addCampItemPAge;
//
//	} 
//
//	public static synchronized EditCampaignItemPage getEditCampaignItemPage(WebDriver driver){
//
//		return (editCampPage==null) ? editCampPage =new EditCampaignItemPage(driver) : editCampPage;
//
//	} 
//
//	public static synchronized ManageCampaignPage getManageCampaignPage(WebDriver driver){
//
//		return (manageCampPage==null) ? manageCampPage =new ManageCampaignPage(driver) : manageCampPage;
//
//	} 
//
//	public static synchronized ManagePricePage getManagePricePage(WebDriver driver){
//
//		return (managePricePage==null) ? managePricePage =new ManagePricePage(driver) : managePricePage;
//
//	} 
//
//	public static synchronized POManagementPage getPOManagementPage(WebDriver driver){
//
//		return (poManagementPage==null) ? poManagementPage =new POManagementPage(driver) : poManagementPage;
//
//	} 
//
//	public static synchronized QuoteManagementPage getQuoteManagementPage(WebDriver driver){
//
//		return (quoteManagePage==null) ? quoteManagePage =new QuoteManagementPage(driver) : quoteManagePage;
//
//	} 
//
//	public static synchronized SalesInvoicePage getSalesInvoicePage(WebDriver driver){
//
//		return (salesInvoicePage==null) ? salesInvoicePage =new SalesInvoicePage(driver) : salesInvoicePage;
//
//	} 
//
//	public static synchronized SalesOrderPage getSalesOrderPage(WebDriver driver){
//
//		return (salesOrderPage==null) ? salesOrderPage =new SalesOrderPage(driver) : salesOrderPage;
//
//	} 
//
//	public static synchronized SubmitSupplierPricePage getSubmitSpplierPricePage(WebDriver driver){
//
//		return (submitSupplierPricePage==null) ? submitSupplierPricePage =new SubmitSupplierPricePage(driver) : submitSupplierPricePage;
//
//	} 
//
//    public static synchronized EproCreateCampaignPage getEproCreateCampaignPage(WebDriver driver) {
//	 
//	     return (eprocreatecamp == null) ?  eprocreatecamp   = new EproCreateCampaignPage (driver) :  eprocreatecamp ;
//    }
//
//    public manualInvoicePage getmanualInvoicePage(WebDriver driver) {
//    	
//	     return (manualinvoicepg == null) ? manualinvoicepg  = new manualInvoicePage(driver): manualinvoicepg;
//    }
//
//    public Credit_InvoicePage getCredit_InvoicePage(WebDriver driver) {
//	 
//	     return (creditInvoicePg == null) ?  creditInvoicePg   = new Credit_InvoicePage (driver) :  creditInvoicePg ;
//    }


}
