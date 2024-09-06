package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommmonUtils.BaseAction;


public class manualInvoicePage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	EproCreateCampaignPage eprocreteCampPg;
	JavascriptExecutor js;

	private BaseAction ba;
	
	@FindBy(xpath = ("//*[@id='sideNav']"))
	private WebElement sidenav;

	@FindBy(xpath = ("//a/*[@src='assets/images/finance-module.svg']"))
	private WebElement finance;
	
	@FindBy(xpath=("//*[@href='/finance/manualinvoice']"))
	private WebElement manualInvoicePage;
	
	@FindBy(xpath = "//a/img[@src='assets/images/workflow.svg']")
	private WebElement workflow;
	
	@FindBy(xpath = "//span/img[@src='assets/images/assign-suppliers.svg']")
	private WebElement createIcon;
	
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customertxtBox;
	
	@FindBy(xpath = "//span[text()='Customer Entities']")
	private WebElement customerEntities;
	
	@FindBy(xpath = "//span[text()=' Add Line']")
    private WebElement addLineTab;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-Description mat-column-Description ng-star-inserted']/input")
	private WebElement tableDescription;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-Quantity mat-column-Quantity ng-star-inserted']/input")
	private WebElement tableQuantity;
	
	@FindBy(xpath = "//*[text()='Copyright 2019 Paragon Group Limited']")
	private WebElement bottom;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-UnitCost mat-column-UnitCost ng-star-inserted']/input")
	private WebElement unitCost;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-Total mat-column-Total ng-star-inserted']/input")
	private WebElement costTotal;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-VATCode mat-column-VATCode ng-star-inserted']/mat-select")
    private WebElement vatCode;
	
	@FindBy(xpath = "//*[text()=' VAT20']")
	private WebElement vat20;
	
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-CategoryId mat-column-CategoryId ng-star-inserted']/mat-select")
    private WebElement categoryCode;
	
	@FindBy(xpath = "//*[text()=' Postage - 106610']")
	private WebElement poStage;
	
	@FindBy(xpath = "//*[@role='table']/tbody/tr/td[@class='mat-cell cdk-cell cdk-column-PONumber mat-column-PONumber ng-star-inserted']/div/div/input")
	private WebElement poNumber;
	
	@FindBy(xpath = "//button/span[text()=' Create Invoice']")
	private WebElement createManualinvoicetab;
	
	@FindBy(xpath = "//button/span[text()=' OK ']")
	private WebElement okbutton;
	
	@FindBy(xpath = "//button/span[text()='Close']")
	private WebElement clsbutton;
	
	@FindBy(xpath = "//*[@id='DescriptionChk']")
	private WebElement discriptionBox;
	
	@FindBy(xpath = "//input[@placeholder='Search..']")
	private WebElement search;
	
	//@FindBy(xpath="//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']")
	@FindBy(xpath="//*[@data-placeholder='Date Of Supply']")
	private WebElement dateofsupply;
	
	@FindBy(xpath="//*[@id='SalesRepresentativeId']")
	private WebElement salesRepresntative;
	
	@FindBy(xpath="//table[@role='grid']/tbody/tr[2]/td[3]")
	private WebElement selectCalDate;
	
	@FindBy(xpath="//*[text()='Manual Invoice Details ']")
	private WebElement ManualInvoiceDetailArrow;
	
	@FindBy(xpath="//button/span[text()= ' Send to Final Invoice']")
	private WebElement sendFinalInvoice;
	
	@FindBy(xpath="//button[span=' Send ']")
	private WebElement clickSend;
	
	@FindBy(xpath="//*[text()='Final Manual Invoice']")
	
	private WebElement finalManualInvoiceTab;
	
	@FindBy(xpath="//*[text()=' Post']")
	private WebElement postButton;
	
	@FindBy(xpath="//button[span=' OK ']")
	private WebElement clickOkButton;
	
	@FindBy (xpath="//span[contains (text(),' On-Hold Invoice')]")
	private WebElement click_On_Hold_button; 
	
	@FindBy (xpath="//textarea[@id='invoicequery']")
	private WebElement pass_text; 
	
	@FindBy (xpath="//span[contains (text(),' OK ')]")
	private WebElement clickOk;
	
	@FindBy (xpath="//div[contains(text(),'OnHold-Manual Invoice')]")
	private WebElement holdInvoiceTab;
	
	@FindBy (xpath="//span[contains (text(),' Release Invoice')]")
	private WebElement click_release_button;
	
	@FindBy (xpath="//button[@style='float: right;']")
	private WebElement ClkOKunderHoldTab;
	
	@FindBy (xpath="//div[contains(text(),'Posted Manual Invoices')]")
	private WebElement Post_invoice_tab;
	
	@FindBy (xpath="//mat-select[@id='SalesRepresentativeId']")
	private WebElement salesRepresentativeTextBox;
	
	@FindBy(xpath = "//bread-crumb//li[3]/span")
	private WebElement manualInvoiceNo;
	
	
	
	public WebElement getsalesRepresentativeTextBox() {
		return salesRepresentativeTextBox;
	}
	
	public WebElement getmanualInvoiceNo() {
		return manualInvoiceNo;
	}
	
	public WebElement getPost_invoice_tab() {
		return Post_invoice_tab;
	}
	
	
	public WebElement getholdInvoiceTab() {
		return holdInvoiceTab;
	}
	
	public WebElement getclick_release_button() {
		return click_release_button;
	}
	public WebElement getClkOKunderHoldTab () {
		return ClkOKunderHoldTab;
	}
	
	public WebElement getclickOk() {
		return clickOk;
	}
	 
	public WebElement getpass_text() {
		return pass_text;
	}
	
	
	public WebElement getclick_On_Hold_button() {
		return click_On_Hold_button;
	}
	
	
	
	
	
	public WebElement getfinance() {
		return finance;
	}

	public WebElement getsidenav() {
		return sidenav;
	}
		

	public WebElement getmanualInvoicePage()
	{
		return manualInvoicePage;
	}
	
	public WebElement getokbutton() {
		return okbutton;
	}
	
	public WebElement getclsbutton() {
		return clsbutton;
	}
	
	public WebElement getpoNumber() {
		return poNumber;
	}
	
	public WebElement getcreateManualinvoicetab() {
		return createManualinvoicetab;
	}
	
	public WebElement getpoStage() {
		return poStage;
	}
	
	public WebElement getcategoryCode() {
		return categoryCode;
	}
	
	public WebElement getvat20() {
		return vat20;
	}

	public WebElement getvatCode() {
		return vatCode;
	}
	
	public WebElement getcostTotal() {
		return costTotal;
	}
	
	public WebElement getunitcost() {
		return unitCost;
	}
	
	public WebElement getbottom() {
	    return bottom;
	
	}
	
	public WebElement gettableQuantity() {
		return tableQuantity;
	}
	
	public WebElement gettableDescription() {
		return tableDescription;
	}
	
	
	public WebElement getaddLineTab() {
		return addLineTab;
	}
	
	public WebElement getcustomerEntities() {
	    return customerEntities;	
	}
	
	public WebElement getcustomertxtBox() {
		return customertxtBox;
	}
	public WebElement getcreateIcon() {
		return createIcon;
	}
	
	public WebElement getdiscriptionBox() {
		return discriptionBox;
	}
	
	public WebElement getworkflow() {
		return workflow;
	}
	public WebElement getsearch() {
		return search;
	}
	
	public WebElement getsalesRepresntative()
	{
		return salesRepresntative;
	}
public WebElement getdateofsupply()
{
	return dateofsupply;
}

public WebElement getselectCalDate()
{
	return selectCalDate;
}

public WebElement getManualInvoiceDetailArrow()
{
	return ManualInvoiceDetailArrow;
}

public WebElement getsendFinalInvoice()
{
	return sendFinalInvoice;
}

public WebElement getclickSend()
{
	return clickSend;
}

public WebElement getfinalManualInvoiceTab()
{
	return finalManualInvoiceTab;
}
	public WebElement getclickOkButton()
	{
		return clickOkButton;
	}
public WebElement getpostButton()
{
	return postButton;
}
	public manualInvoicePage(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
		eprocreteCampPg = new EproCreateCampaignPage(driver);
		js = (JavascriptExecutor) driver;

	}
	
	private static final Logger logger = LogManager.getLogger(SalesOrderPage.class);
	
	
	public void goToManualInvoicePage() throws InterruptedException {
		// navigating to Finance

		wait.until(ExpectedConditions.elementToBeClickable(getfinance())).click();
		//Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(getmanualInvoicePage())).click();
		logger.info("landed on manual invoice page");
		
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();

	}
	
	public void manualInvoiceDetailsandClickAddLine() throws Throwable {
		// click on create icon
			
		
				  ba.retryMechanism(driver, getcreateIcon());
				  
				
				  ba.retryMechanism(driver, eprocreteCampPg.getBusinessID());
					ba.retryMechanism(driver, eprocreteCampPg.getpccUKLeadSupply());
					
					ba.retryMechanism(driver, getcustomertxtBox());	
					ba.retryMechanism(driver, eprocreteCampPg.getstagingClient_1());
					
					ba.retryMechanism(driver, getcustomerEntities());
					ba.retryMechanism(driver, eprocreteCampPg.getAdminClient());
					
					ba.retryMechanismWithSendKeys(driver, getdiscriptionBox(), "for Demo test");	

					//wait.until(ExpectedConditions.elementToBeClickable(getdateofsupply())).click();
					Thread.sleep(1000);
					ba.retryMechanism(driver, getdateofsupply());
					//hardcoded date 
					Thread.sleep(1000);
					wait.until(ExpectedConditions.elementToBeClickable(getselectCalDate())).click();
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
				    js.executeScript("arguments[0].scrollIntoView(true);", getbottom());
					
					ba.retryMechanism(driver, getaddLineTab());
					
					 logger.info("Final manual Invoice details added");
					
				
			}
	
	public String createManualInvoice() throws Throwable
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", getbottom());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(gettableDescription())).sendKeys("For Demo");
		wait.until(ExpectedConditions.elementToBeClickable(gettableDescription())).click();
		//ba.retryMechanism(driver,getdateofsupply());
		wait.until(ExpectedConditions.elementToBeClickable(gettableQuantity())).sendKeys("200");
		
		wait.until(ExpectedConditions.elementToBeClickable(getunitcost())).sendKeys("12");
		
		//wait.until(ExpectedConditions.elementToBeClickable(getcostTotal())).click();
		ba.retryMechanism(driver, getcostTotal());
		
		wait.until(ExpectedConditions.elementToBeClickable(getvatCode())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getvat20())).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getcategoryCode())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getpoStage())).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getpoNumber())).sendKeys("PO2020202");
		
		//wait.until(ExpectedConditions.elementToBeClickable(getcreateCRinvoicetab())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getcreateManualinvoicetab())).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(getokbutton())).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getclsbutton())).click();
		
		String manualInvoiceNo = wait.until(ExpectedConditions.elementToBeClickable(getmanualInvoiceNo())).getText();
		
		 logger.info("Final manual Invoice created");
		
		return manualInvoiceNo;
		
			
	}
	
	
	public void sendFinalInvoice(String manualInvoiceNo, int td) throws InterruptedException {
    	// search for invoice no which has same description
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(manualInvoiceNo);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
		  
		  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
		  ba.retryMechanism(driver, ManualInvoiceDetailArrow);
		  Thread.sleep(1000);
		  js.executeScript("arguments[0].scrollIntoView(true);", getsendFinalInvoice());
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getsendFinalInvoice())).click();
		  //ba.retryMechanism(driver, getsendFinalInvoice());
		
		  js.executeScript("arguments[0].scrollIntoView(true);", getclickSend());
		  wait.until(ExpectedConditions.elementToBeClickable(getclickSend())).click();
		 
		  logger.info("Final manual Invoice send");

}
	
	public void postFinalInvoice(String manualInvoiceNo, int td) throws InterruptedException {
		js.executeScript("window.scrollTo(0, 0);");
    	 wait.until(ExpectedConditions.elementToBeClickable(getfinalManualInvoiceTab())).click();
    	 Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(manualInvoiceNo);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
		  
		  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
		  ba.retryMechanism(driver, ManualInvoiceDetailArrow);
		 
			Thread.sleep(1000);
		  js.executeScript("arguments[0].scrollIntoView(true);", getpostButton());
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getpostButton())).click();
		  
		  js.executeScript("arguments[0].scrollIntoView(true);", getclickOkButton());
		  Thread.sleep(1000);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(getclickOkButton())).click();
		  
		  logger.info("Final manual Invoice Posted");
    }
	
	public void goToFinalInvoiceTab_And_DoOnHold (String manualInvoiceNo, int td) throws InterruptedException {
		
	 wait.until(ExpectedConditions.elementToBeClickable(getfinalManualInvoiceTab())).click();
   	 Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(manualInvoiceNo);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
		  
		  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
		  ba.retryMechanism(driver, ManualInvoiceDetailArrow);
		 
			Thread.sleep(1000);
		  js.executeScript("arguments[0].scrollIntoView(true);", getclick_On_Hold_button());
		  Thread.sleep(1000);
        ba.retryMechanism(driver, getclick_On_Hold_button());
		  
		
		  Thread.sleep(1000);
		  ba.retryMechanismWithSendKeys(driver, getpass_text(), "Not Applicable");
		 
		  ba.retryMechanism(driver, getclickOk());
		  
		  logger.info("Final manual Invoice on-hold");
	}
	
	
	public void gotToOnHoldInvoiceTab_And_DoRelease (String manualInvoiceNo, int td) throws InterruptedException {
		
		
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 0);");
		
		Thread.sleep(2000);
		 ba.retryMechanism(driver, getholdInvoiceTab());
		 
		 Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(manualInvoiceNo);
		  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
		  
		  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
		  ba.retryMechanism(driver, ManualInvoiceDetailArrow);
		 
			Thread.sleep(1000);
		 
		
		 ba.retryMechanism(driver, getclick_release_button());
		 
		 Thread.sleep(2000);
		
		 ba.retryMechanismWithSendKeys(driver, getpass_text(), "Not Applicable");
		 
		
		 ba.retryMechanism(driver, getClkOKunderHoldTab());
		 
		 Thread.sleep(3000);
		 
		 logger.info("Final manual Invoice Released");
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void gotToPostInvoiceTab_And_Validate_data (String manualInvoiceNo, int td) throws InterruptedException {
		
		 Thread.sleep(3000);
		 js.executeScript("window.scrollTo(0, 0);");
		
		
		// js.executeScript("arguments[0].scrollIntoView();", Post_invoice_tab);
		 ba.retryMechanism(driver, getPost_invoice_tab());
		 
		
		 ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
		 
		
		 
		 ba.retryMechanism(driver, ManualInvoiceDetailArrow);
		String unitcost= getunitcost().getAttribute("value");
		String description= gettableDescription().getAttribute("value");
		String quantity= gettableQuantity().getAttribute("value");
		String ponumber=(String) js.executeScript("return arguments[0].value;", getpoNumber());
		
		try {Assert.assertEquals(unitcost, "12.00000");
		Assert.assertEquals(description, "For Demo");
		Assert.assertEquals(quantity, "200");
		Assert.assertEquals(ponumber, "PO2020202");
		
		System.out.println("Details are verified successfully");
		logger.info("Details are verified successfully");
		}
		catch (AssertionError e) {	
			e.printStackTrace();
			System.out.println("Validation failed");
			logger.info("Validation failed");
		}
		
		
	}
	
	
}



