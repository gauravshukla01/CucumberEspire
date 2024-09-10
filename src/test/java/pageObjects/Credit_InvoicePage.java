package pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommmonUtils.BaseAction;

import otherResources.TestContext;

public class Credit_InvoicePage {

	private WebDriver driver;
	private WebDriverWait wait;
	EproCreateCampaignPage eprocreteCampPg;
	JavascriptExecutor js;

	private BaseAction ba;

	@FindBy(xpath = "//input[@placeholder='Search..']")
	private WebElement search;

	@FindBy(xpath = "//a/img[@src='assets/images/workflow.svg']")
	private WebElement workflow;

	@FindBy(xpath = ("//a/*[@src='assets/images/finance-module.svg']"))
	private WebElement finance;

	@FindBy(xpath = "//ul/li/a[text()=' Credit Invoices']")
	private WebElement creditInvoicePg;

	@FindBy(xpath = "//*[@id='DescriptionChk']")
	private WebElement discriptionBox;

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

	@FindBy(xpath = "//button/span[text()=' Create CR Invoice']")
	private WebElement createCRinvoicetab;

	@FindBy(xpath = "//button/span[text()=' OK ']")
	private WebElement okbutton;

	@FindBy(xpath = "//button/span[text()='Close']")
	private WebElement clsbutton;

	@FindBy(xpath = "//button/span[text()=' Send to Final Invoice']")
	private WebElement sendFinalInvoiceBtn;

	@FindBy(xpath = "//mat-checkbox[@id='finalRcpEmailChecked']")
	private WebElement checkBxEmail;

	@FindBy(xpath = "//button/span[text()=' Send ']")
	private WebElement sendinPopup;

	//@FindBy(xpath = "//*[text()='Final Credit Invoice']")
	@FindBy(xpath="//*[contains(text(),'Final Credit Invoice')]")
	private WebElement finalCreditInoiceTB;

	@FindBy(xpath = "//button/span[text()=' Post']")
	private WebElement postBtn;

	@FindBy(xpath = "//bread-crumb//li[4]/span")
	private WebElement crInvoiceNo;

	@FindBy(xpath = "//div[text()='Posted Credit Notes']")
	private WebElement postedCrTab;

	@FindBy(xpath = "//*[@role='table']/tbody/tr/td/button/span/img[@src='assets/images/download.svg']")
	private WebElement inTableDownload;

	// On Hold Element

	//@FindBy(xpath = "//span[contains (text(),' Final Credit Invoice')]")
	//@FindBy(xpath="//*[text()='Final Credit Invoice']")
	//@FindBy(xpath="//*[contains(text(),'Final Credit Invoice')]")
	//private WebElement click_On_Final_Credit_Invoice;

	@FindBy(xpath = "//textarea[@id='invoicequery']")
	private WebElement pass_text;

	@FindBy(xpath = "//span[contains (text(),' OK ')]")
	private WebElement clickOk;

	//@FindBy(xpath = "//div[contains(text(),'OnHold-Credit Invoice')]")
	@FindBy(xpath="//span[contains(text(),' On-Hold Invoice')]")
	private WebElement click_On_Hold_button;

	@FindBy(xpath = "//span[contains (text(),' Release Invoice')]")
	private WebElement click_release_button;

	@FindBy(xpath = "//button[@style='float: right;']")
	private WebElement ClkOKunderHoldTab;

	@FindBy(xpath = "//div[contains(text(),'Posted Credit Notes')]")
	private WebElement Post_invoice_tab;
	
	@FindBy (xpath="//div[contains(text(),'OnHold-Credit Invoice')]")
	private WebElement holdInvoiceTab;
	
	

	public WebElement getfinalCreditInoiceTB() {
		return finalCreditInoiceTB;
	}

	public WebElement getinTableDownload() {
		return inTableDownload;
	}

	public WebElement getpostedCrTab() {
		return postedCrTab;
	}
	public WebElement getholdInvoiceTab() {
		return holdInvoiceTab;
	}

	public WebElement getcrInvoiceNo() {
		return crInvoiceNo;
	}

	public WebElement getpostBtn() {
		return postBtn;
	}

	public WebElement getsendinPopup() {
		return sendinPopup;
	}

	public WebElement getokbutton() {
		return okbutton;
	}

	public WebElement getcheckBxEmail() {
		return checkBxEmail;
	}

	public WebElement getsendFinalInvoiceBtn() {
		return sendFinalInvoiceBtn;
	}

	public WebElement getclsbutton() {
		return clsbutton;
	}

	public WebElement getpoNumber() {
		return poNumber;
	}

	public WebElement getcreateCRinvoicetab() {
		return createCRinvoicetab;
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

	public WebElement getsearch() {
		return search;
	}

	public WebElement getcreditInvoicePg() {
		return creditInvoicePg;
	}

	public WebElement getfinance() {
		return finance;
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

	// Method for On Hold Scenario

	public WebElement getPost_invoice_tab() {
		return Post_invoice_tab;
	}

	public WebElement getclick_On_Hold_button() {
		return click_On_Hold_button;
	}

	public WebElement getclick_release_button() {
		return click_release_button;
	}

	public WebElement getClkOKunderHoldTab() {
		return ClkOKunderHoldTab;
	}

	public WebElement getclickOk() {
		return clickOk;
	}

	public WebElement getpass_text() {
		return pass_text;
	}

	/*public WebElement getclick_On_Final_Credit_Invoice() {
		return click_On_Final_Credit_Invoice;
	}*/

	public Credit_InvoicePage(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
		eprocreteCampPg = new EproCreateCampaignPage(driver);
		js = (JavascriptExecutor) driver;

	}

	private static final Logger logger = LogManager.getLogger(SalesOrderPage.class);

	public void goToCreditInvoicePg() {

		// click on workflow icon

		wait.until(ExpectedConditions.elementToBeClickable(getfinance())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getcreditInvoicePg())).click();

		logger.info("Landed on Credit Invoice page");
		// clear search

		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();

	}

	public void enterDetailsAndclickAddline() throws Throwable {
		// click on create icon
		// String description = "forTestDemo";
		ba.retryMechanism(driver, getcreateIcon());

		ba.retryMechanism(driver, eprocreteCampPg.getBusinessID());
		ba.retryMechanism(driver, eprocreteCampPg.getpccUKLeadSupply());

		ba.retryMechanism(driver, getcustomertxtBox());
		ba.retryMechanism(driver, eprocreteCampPg.getstagingClient_1());

		ba.retryMechanism(driver, getcustomerEntities());
		ba.retryMechanism(driver, eprocreteCampPg.getAdminClient());

		ba.retryMechanismWithSendKeys(driver, getdiscriptionBox(), "ForDemoTest");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", getbottom());
		Thread.sleep(1500);

		wait.until(ExpectedConditions.elementToBeClickable(getaddLineTab())).click();
		logger.info("New add line created for Credit Invoice");

	}

	public String createCreditInvoice() {

		js.executeScript("arguments[0].scrollIntoView(true);", getbottom());

		wait.until(ExpectedConditions.elementToBeClickable(gettableDescription())).sendKeys("For Demo");

		wait.until(ExpectedConditions.elementToBeClickable(gettableQuantity())).sendKeys("200");

		wait.until(ExpectedConditions.elementToBeClickable(getunitcost())).sendKeys("12");

		ba.retryMechanism(driver, getcostTotal());

		wait.until(ExpectedConditions.elementToBeClickable(getvatCode())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getvat20())).click();

		wait.until(ExpectedConditions.elementToBeClickable(getcategoryCode())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getpoStage())).click();

		wait.until(ExpectedConditions.elementToBeClickable(getpoNumber())).sendKeys("PO2020202");

		wait.until(ExpectedConditions.elementToBeClickable(getcreateCRinvoicetab())).click();

		wait.until(ExpectedConditions.elementToBeClickable(getokbutton())).click();

		wait.until(ExpectedConditions.elementToBeClickable(getclsbutton())).click();

		logger.info("Credit Invoice created");

		String crInvoiceNo = wait.until(ExpectedConditions.elementToBeClickable(getcrInvoiceNo())).getText();

		return crInvoiceNo;

	}

	public void sendFinalCRInvoice(String crInvoice, int td) throws InterruptedException {
		// search for invoice no which has same description

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(crInvoice);
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();

		ba.handleWebTable("//*[@role='table']/tbody/tr", crInvoice, td, "clickItem");
		js.executeScript("arguments[0].scrollIntoView(true);", getbottom());

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(getsendFinalInvoiceBtn())).click();
		// ba.retryMechanism(driver, getsendFinalInvoiceBtn());

		js.executeScript("arguments[0].scrollIntoView(true);", getsendinPopup());
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(getcheckBxEmail())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getsendinPopup())).click();
		logger.info("Final Credit Invoice Send");
	}

	public void postFinalCRInvoice(String crInvoice, int td) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(getfinalCreditInoiceTB())).click();
		//ba.retryMechanism(driver, getfinalCreditInoiceTB());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(crInvoice);
		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();

		ba.handleWebTable("//*[@role='table']/tbody/tr", crInvoice, td, "clickItem");
		js.executeScript("arguments[0].scrollIntoView(true);", getpostBtn());
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(getpostBtn())).click();

		js.executeScript("arguments[0].scrollIntoView(true);", getokbutton());
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(getokbutton())).click();

		logger.info("Final Credit Invoice Posted");

	}

	@SuppressWarnings("deprecation")
		public void downloadPostedInvoice(String crInvoice ) throws Throwable {
	    	
	    	 wait.until(ExpectedConditions.elementToBeClickable(getpostedCrTab())).click();
	    	 Thread.sleep(1000);
			  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
			  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(crInvoice);
			  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
	    	   
			  //click on download icon
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.elementToBeClickable(getinTableDownload())).click();
			  
			  logger.info("posted Credit Invoice downloaded");
			  
			  //validate posted CR invoice data	
			  
			  ba.handleWebTable("//*[@role='table']/tbody/tr", crInvoice, 1, "clickItem");
			  
			  Thread.sleep(500);
              js.executeScript("arguments[0].scrollIntoView(true);", getbottom()); 
              
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
			//Credit Invoice On Hold
				
				public void goToFinalInvoiceTab_And_DoOnHold (String CrInvoiceNo, int td) throws InterruptedException {
					
					 wait.until(ExpectedConditions.elementToBeClickable(getfinalCreditInoiceTB())).click();
					//ba.retryMechanism(driver, getfinalCreditInoiceTB());
				   	 Thread.sleep(1000);
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(CrInvoiceNo);
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
						  
						  ba.handleWebTable("//*[@role='table']/tbody/tr", CrInvoiceNo, td, "clickItem");
						  //ba.retryMechanism(driver, ManualInvoiceDetailArrow);
						 
							//Thread.sleep(1000);
						  js.executeScript("arguments[0].scrollIntoView(true);", getclick_On_Hold_button());
						  //Thread.sleep(1000);
				        ba.retryMechanism(driver, getclick_On_Hold_button());
						  
						
						  Thread.sleep(1000);
						  ba.retryMechanismWithSendKeys(driver, getpass_text(), "Not Applicable");
						 
						  ba.retryMechanism(driver, getclickOk());
						  
						  logger.info("Final credit Invoice on-hold");
					}
					
					
					public void gotToOnHoldInvoiceTab_And_DoRelease (String CrInvoiceNo, int td) throws InterruptedException {
						
						
						Thread.sleep(1000);
						js.executeScript("window.scrollTo(0, 0);");
						
						Thread.sleep(2000);
						 ba.retryMechanism(driver, getholdInvoiceTab());
						 
						 Thread.sleep(1000);
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(CrInvoiceNo);
						  wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
						  
						  ba.handleWebTable("//*[@role='table']/tbody/tr", CrInvoiceNo, td, "clickItem");
						  //ba.retryMechanism(driver, ManualInvoiceDetailArrow);
						 
							Thread.sleep(1000);
						 
						
						 ba.retryMechanism(driver, getclick_release_button());
						 
						 Thread.sleep(2000);
						
						 ba.retryMechanismWithSendKeys(driver, getpass_text(), "Not Applicable");
						 
						
						 ba.retryMechanism(driver, getClkOKunderHoldTab());
						 
						 Thread.sleep(3000);
						 
						 logger.info("Final credit Invoice Released");
						
						
					}
					
					@SuppressWarnings("deprecation")
					public void clickOnPostInvoiceTab (String CrInvoiceNo, int td) throws InterruptedException {
						
						 Thread.sleep(1000);
						 js.executeScript("window.scrollTo(0, 0);");
						Thread.sleep(1000);
						
						// js.executeScript("arguments[0].scrollIntoView();", Post_invoice_tab);
						 //ba.retryMechanism(driver, getPost_invoice_tab());
						 ba.retryMechanism(driver, getfinalCreditInoiceTB());
						 
						
						 ba.handleWebTable("//*[@role='table']/tbody/tr", CrInvoiceNo, td, "clickItem");
						 
						 Thread.sleep(1000);
						  wait.until(ExpectedConditions.elementToBeClickable(getpostBtn())).click();
						  
						  js.executeScript("arguments[0].scrollIntoView(true);", getokbutton());
						  Thread.sleep(1000);
						  
						  wait.until(ExpectedConditions.elementToBeClickable(getokbutton())).click();
						  
						  logger.info("Final credit Invoice Posted");
						 
						
						}
						
					
					@SuppressWarnings("deprecation")
					public void goToPostInvoiceTab_And_Validate_data (String CrInvoiceNo, int td) throws InterruptedException {
						
						 Thread.sleep(1000);
						 js.executeScript("window.scrollTo(0, 0);");
						Thread.sleep(1000);
						
						
						 ba.retryMechanism(driver, getpostedCrTab());
						 
						
						 ba.handleWebTable("//*[@role='table']/tbody/tr", CrInvoiceNo, td, "clickItem");
						 
					
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

