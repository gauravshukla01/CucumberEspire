package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;
import otherResources.TestContext;

public class EproCreateCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	TestContext testContext;

	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");
	
	@FindBy(xpath="//*[@id='BusinessUnitId']")
	private WebElement BusinessID;
	
	@FindBy(xpath="//span[normalize-space()='PCC UK Lead Supply']")
	private WebElement pccUKLeadSupply;
	@FindBy(xpath="//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-28 ng-star-inserted']")
	private WebElement customertxtBox;
	@FindBy(xpath="//*[text()=' StagingClient_1 ']")
	private WebElement stagingClient_1;
	@FindBy(xpath="//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-30 ng-star-inserted']")
	private WebElement customer_entities;
	@FindBy(xpath="//span[normalize-space()='AdminClient 1 - GBP']")
	private WebElement AdminClient;
	@FindBy(xpath="//input[@id='title']")
	private WebElement Campaign_title;
	@FindBy(xpath="//input[@id='reference']")
	private WebElement customer_camping_ref;
	@FindBy(xpath="//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']")
	private WebElement date;
	@FindBy(xpath="//table[@role='grid']/tbody/tr[5]/td[7]")
	private WebElement Value_31;
	@FindBy(xpath="//div[@id='mat-select-value-27']")
	private WebElement VAT;
	@FindBy(xpath="//span[normalize-space()='VAT20']")
	private WebElement vat20;
	@FindBy(xpath="//input[@id='ponumber']")
	private WebElement purchase_order_number;
	
	
	
	
	public WebElement getBusinessID() {
		return BusinessID;
	}
	public WebElement getpccUKLeadSupply() {
		return pccUKLeadSupply;
	}
	public WebElement getcustomertxtBox() {
		return customertxtBox;
	}
	public WebElement getstagingClient_1() {
		return stagingClient_1;
	}
	public WebElement getcustomer_entities() {
		return customer_entities;
	}
	public WebElement getAdminClient() {
		return AdminClient;
	}
	public WebElement getCampaign_title() {
		return Campaign_title;
	}
	public WebElement getcustomer_camping_ref() {
		return customer_camping_ref;
	}
	public WebElement getdate() {
		return date;
	}
	public WebElement getValue_31() {
		return Value_31;
	}
	public WebElement getVAT() {
		return VAT;
	}
	public WebElement getvat20() {
		return vat20;
	}
	public WebElement getpurchase_order_number() {
		return purchase_order_number;
	}
	
	

	public EproCreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		
	}

	public void fillRequiredDetails() throws InterruptedException {

		// retry mechanism implementation
		
		ba.retryMechanism(driver, getBusinessID());
		ba.retryMechanism(driver, getpccUKLeadSupply());

		
		ba.retryMechanism(driver, getcustomertxtBox());	
		ba.retryMechanism(driver, getstagingClient_1());
		

		
				
		ba.retryMechanism(driver, getcustomer_entities());
		ba.retryMechanism(driver, getAdminClient());
		

		/*
		 * WebElement Account_Manager =
		 * driver.findElement(By.xpath("//*[@id='title']"));
		 * ba.retryMechanism(driver,Account_Manager);
		 */
		/*
		 * WebElement Staging_user =
		 * driver.findElement(By.xpath("//span[normalize-space()='Staging User3']"));
		 * ba.retryMechanism(driver,Staging_user);
		 */

		
		ba.retryMechanismWithSendKeys(driver, getCampaign_title(), "Test_3");

		
		ba.retryMechanismWithSendKeys(driver, getcustomer_camping_ref(), "CR124324332");

		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		ba.retryMechanism(driver,getdate());
		//WebElement Value_31 = driver.findElement(By.xpath("//*[contains(@aria-label,'August 31, 2024')]"));
		
		ba.retryMechanism(driver,getValue_31());

		/*
		 * WebElement sales_representative =
		 * driver.findElement(By.xpath("//div[@id='mat-select-value-23']"));
		 * retryMechanism(driver,sales_representative); WebElement David_Reynolds =
		 * driver.findElement(By.xpath("//span[normalize-space()='David Reynolds']"));
		 * retryMechanism(driver,David_Reynolds);
		 */

		
		js.executeScript("arguments[0].scrollIntoView();", getVAT());
		ba.retryMechanism(driver,getVAT());
		
		ba.retryMechanism(driver,getvat20());

		WebElement purchase_order_number = driver.findElement(By.xpath("//input[@id='ponumber']"));
		js.executeScript("arguments[0].scrollIntoView();", purchase_order_number);
		ba.retryMechanismWithSendKeys(driver, purchase_order_number, "PO12421331");

		WebElement purchase_order_value = driver.findElement(By.xpath("//input[@id='povalue']"));
		js.executeScript("arguments[0].scrollIntoView();", getpurchase_order_number());
		ba.retryMechanismWithSendKeys(driver, getpurchase_order_number(), "2");


		/*  WebElement cost_centre = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-51 ng-star-inserted']"));
        ba.retryMechanism(driver,cost_centre);
        WebElement regionalmarketing = driver.findElement(By.xpath("//span[contains(text(),'MFE - DM – Regional Marketing')]"));
        ba.retryMechanism(driver,regionalmarketing);
		 */

	}

	public void submitCreateCampaignDetails() throws InterruptedException {

		WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", SUBMIT);
		ba.retryMechanism(driver, SUBMIT);
	}

	public void ValidateCreateCampaignPopUp() {

		ba.validatePopUp("Campaign has been created successfully.", "Campaign creation popup validated successfully.");
	}

	public String storeCampaignID() throws InterruptedException {

		try {
			WebElement clearSearch = driver.findElement(By.xpath("//div[@class='input-group-append']"));
			ba.retryMechanism(driver, clearSearch);
		} catch (Exception e) {
			e.printStackTrace();
		}
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String campaign_Number = ba.handleWebTable("//*[@role='table']/tbody/tr", "Created", 1, "getText");

		// add this to hashmap

		System.out.println("Campaign number = " + campaign_Number);

		return campaign_Number;
	}




}