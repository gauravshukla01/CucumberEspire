package TestResourceManager;

import org.openqa.selenium.WebDriver;

import pageObjects.AddCampaignItemPage;
import pageObjects.AmazonHomePage;
import pageObjects.DemoQATextBoxPage;
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
import pageObjects.ZohoSignInPage;

public class PageObjectManager {

	WebDriver driver;
	AmazonHomePage amazonHomePage;
	ZohoSignInPage zohoSignPage;
	DemoQATextBoxPage textBoxPage;
	EproLoginPage eprologin;
	EproHomePage eprohome;
	EproCampaignPage eprocamp;
	EproCreateCampaignPage eprocreatecamp;
	AddCampaignItemPage addCampItemPAge;
	EditCampaignItemPage editCampPage;
	ManageCampaignPage manageCampPage;
	ManagePricePage managePricePage;
	POManagementPage poManagementPage;
	QuoteManagementPage quoteManagePage;
	SalesInvoicePage salesInvoicePage;
	SalesOrderPage salesOrderPage;
	SubmitSupplierPricePage submitSupplierPricePage;



	public PageObjectManager(WebDriver webDriver) {
		driver = webDriver;
	}

	public AmazonHomePage getAmazonHomePage(){

		return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;

	}

	public ZohoSignInPage getZohoSignInPage(){

		return (zohoSignPage==null) ? zohoSignPage=new ZohoSignInPage(driver) : zohoSignPage;

	}

	public DemoQATextBoxPage getDemoQaTextBoxPage(){

		return (textBoxPage==null) ? textBoxPage=new DemoQATextBoxPage(driver) : textBoxPage;

	} 
	public EproLoginPage getEproLoginPage(){

		return (eprologin==null) ? eprologin=new EproLoginPage(driver) : eprologin;

	} 

	public EproHomePage getEproHomePage(){

		return (eprohome==null) ? eprohome=new EproHomePage(driver) : eprohome;

	} 
	public EproCampaignPage getEproCampaignPage(){

		return (eprocamp==null) ? eprocamp=new EproCampaignPage(driver) : eprocamp;

	} 

	public AddCampaignItemPage getAddCampaignItemPage(){

		return (addCampItemPAge==null) ? addCampItemPAge =new AddCampaignItemPage(driver) : addCampItemPAge;

	} 

	public EditCampaignItemPage getEditCampaignItemPage(){

		return (editCampPage==null) ? editCampPage =new EditCampaignItemPage(driver) : editCampPage;

	} 

	public ManageCampaignPage getManageCampaignPage(){

		return (manageCampPage==null) ? manageCampPage =new ManageCampaignPage(driver) : manageCampPage;

	} 

	public ManagePricePage getManagePricePage(){

		return (managePricePage==null) ? managePricePage =new ManagePricePage(driver) : managePricePage;

	} 

	public POManagementPage getPOManagementPage(){

		return (poManagementPage==null) ? poManagementPage =new POManagementPage(driver) : poManagementPage;

	} 

	public QuoteManagementPage getQuoteManagementPage(){

		return (quoteManagePage==null) ? quoteManagePage =new QuoteManagementPage(driver) : quoteManagePage;

	} 

	public SalesInvoicePage getSalesInvoicePage(){

		return (salesInvoicePage==null) ? salesInvoicePage =new SalesInvoicePage(driver) : salesInvoicePage;

	} 

	public SalesOrderPage getSalesOrderPage(){

		return (salesOrderPage==null) ? salesOrderPage =new SalesOrderPage(driver) : salesOrderPage;

	} 

	public SubmitSupplierPricePage getSubmitSpplierPricePage(){

		return (submitSupplierPricePage==null) ? submitSupplierPricePage =new SubmitSupplierPricePage(driver) : submitSupplierPricePage;

	} 

	public EproCreateCampaignPage getEproCreateCampaignPage() {

		return (eprocreatecamp == null) ?  eprocreatecamp   = new EproCreateCampaignPage (driver) :  eprocreatecamp ;
	}





}
