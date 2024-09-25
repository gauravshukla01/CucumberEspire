//package pageObjects;
//
//import java.util.concurrent.TimeUnit;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import CommmonUtils.BaseClass;
//
//public class SalesInvoicePage {
//
//	private WebDriver driver;
//	private WebDriverWait wait;
//	private JavascriptExecutor js;
//	private BaseClass ba;
//	SalesOrderPage salesorderpage;
//	manualInvoicePage manualinvoicePg;
//	Credit_InvoicePage creditInvoicePg;
//
//	@FindBy(xpath = ("//*[text()='Supporting Documents']"))
//	private WebElement supportdoc;
//
//	@FindBy(xpath = ("//*[text()=' Sales Invoices']"))
//	private WebElement salesinvoice;
//
//	@FindBy(xpath = "//*[text()='Check Client PO or Acceptance of Quote ']")
//	private WebElement FirstCheckBox;
//
//	@FindBy(xpath = "//*[text()='Check Proof of Delivery or Postal Docket ']")
//	private WebElement SecondCheckBox;
//
//	@FindBy(xpath = "//*[text()='Check Proof of Delivery or Postal Docket ']")
//	private WebElement lastele;
//	
//	@FindBy(xpath = "//button/span[text()=' Send to Final Invoice']")
//	private WebElement SendToFinalInvoiceTab;
//	
//	@FindBy(xpath = "//mat-checkbox[@id='finalRcpEmailChecked']")
//	private WebElement checkboxEmailRcp;
//	
//	@FindBy(xpath = "//button/span[text()=' Send ']")
//	private WebElement sendBtn;
//	
//	@FindBy(xpath = "//*[text()='Final Invoices']")
//	private WebElement finalInvoiceTab;
//	
//	@FindBy (xpath="//div[contains(text(),'On-Hold Invoices')]")
//	private WebElement holdInvoiceTab;
//	
//	@FindBy (xpath="//span[text()='ZERO Rated VAT Form ']")
//	private WebElement checkBoxZeroVat;
//	
//	@FindBy (xpath="//*[text()=' SOX Approved ']")
//	private WebElement checkSoxApproved;
//	
//	@FindBy (xpath="//button/span[text()=' Post Invoice']")
//	private WebElement postInvoiceBtn;
//	
//	@FindBy (xpath="//*[text()=' Post ']")
//	private WebElement postBtn;
//	
//	@FindBy (xpath="//div[contains(text(),'Invoices Posted')]")
//	private WebElement invoicePostedTab;
//	
//	@FindBy (xpath="//*[@role='table']/tbody/tr/td/input[contains(@name, 'unitval')]")
//	private WebElement unitCost;
//	
//	@FindBy (xpath="//*[@role='table']/tbody/tr/td/input[contains(@name, 'quantityVal')]")
//	private WebElement tableQnty;
//	
//	@FindBy (xpath="//*[@role='table']/tbody/tr/td/div/div/input[contains(@name, 'poNum')]")
//	private WebElement tablePONumber;
//	
//
//	
//	public WebElement gettablePONumber() {
//		return tablePONumber;
//	}
//	
//	public WebElement gettableQnty() {
//		return tableQnty;
//	}
//	
//	public WebElement getunitCost() {
//		return unitCost;
//	}
//	
//	public WebElement getholdInvoiceTab() {
//		return holdInvoiceTab;
//	}
//	
//	public WebElement getinvoicePostedTab() {
//		return invoicePostedTab;
//	}
//	
//	public WebElement getpostBtn() {
//		return postBtn;
//	}
//	
//	public WebElement getpostInvoiceBtn() {
//		return postInvoiceBtn;
//	}
//	
//	public WebElement getcheckSoxApproved() {
//		return checkSoxApproved;
//	}
//	
//	public WebElement getcheckBoxZeroVat() {
//		return checkBoxZeroVat;
//	}
//	
//	public WebElement getsendBtn() {
//		return sendBtn;
//	}
//	
//	public WebElement getfinalInvoiceTab() {
//		return finalInvoiceTab;
//	}
//	
//	public WebElement getcheckboxEmailRcp() {
//		return checkboxEmailRcp;
//	}
//	
//	public WebElement getsupportdoc() {
//		return supportdoc;
//	}
//	
//	public WebElement getSendToFinalInvoiceTab() {
//		return SendToFinalInvoiceTab;
//	}
//
//	public WebElement getsalesinvoice() {
//		return salesinvoice;
//	}
//
//	public WebElement getFirstCheckBox() {
//		return FirstCheckBox;
//	}
//
//	public WebElement getSecondCheckBox() {
//		return SecondCheckBox;
//	}
//
//	public WebElement getlastele() {
//		return lastele;
//	}
//
//	public SalesInvoicePage(WebDriver driver) {
//		this.driver = driver;
//		js = (JavascriptExecutor) driver;
//		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//		ba = new BaseClass(driver);
//		this.salesorderpage = new SalesOrderPage(driver);
//		this.manualinvoicePg = new manualInvoicePage(driver);
//		this.creditInvoicePg = new Credit_InvoicePage(driver);
//		PageFactory.initElements(driver, this);
//
//	}
//	
//	private static final Logger logger = LogManager.getLogger(SalesInvoicePage.class);
//
//	public String getCampIdDraftInvoiced(String status) throws InterruptedException {
//		// validating status as PO receipted
//		String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status, 2, "getText");
//		System.out.println("campaign_ID = " + campaign_ID);
//		logger.info("Fetched Draft invoice campaign ID");
//		return campaign_ID;
//	}
//
//	public String getPDFPOname() throws InterruptedException {
//		// click on supporting docs link
//		ba.retryMechanism(driver, getsupportdoc());
//
//		// get the pdf PO name from table
//
//		String pdfName = null;
//		for (int i = 0; i < 3; i++) {
//			try {
//				pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr", "Draft Invoice", 2, "getText");
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//		} // end of for loop
//
//		// ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
//		String[] act = pdfName.split("_");
//		System.out.println("split pdf name = " + act[0]);
//		logger.info("PDF name stored");
//		return act[0];
//
//	}
//
//	public void goToSaleInvoicePg() {
//		// navigating to Finance
//
//		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getfinance())).click();
//		// click on Sales order
//		wait.until(ExpectedConditions.elementToBeClickable(getsalesinvoice())).click();
//		// clear search
//		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).click();
//		logger.info("landed on sales invoice page");
//	}
//	
//	public void clickOnDraftInvoiceNo() throws InterruptedException {
//		// click on invoice number
//		for (int i = 0; i < 3; i++) {
//			try {
//				ba.handleWebTable("//*[@role='table']/tbody/tr", "LEAD" , 2, "clickItem"); // hard coded value
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//
//		} // end of for loop
//
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		
//		logger.info("Click on invoice Number");
//	}
//
//	public void clickOnInvoiceNo(String pdfname) throws InterruptedException {
//		// click on invoice number
//		for (int i = 0; i < 3; i++) {
//			try {
//				ba.handleWebTable("//*[@role='table']/tbody/tr", pdfname, 2, "clickItem"); // hard coded value
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//
//		} // end of for loop
//
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		
//		logger.info("Click on invoice Number");
//	}
//
//	public void clickOnCheckboxs(String indexId) throws InterruptedException {
//		// scroll to element
//
//		js.executeScript("arguments[0].scrollIntoView(true);", getlastele());
//
//		// click on check box next to campaig id
//
//		for (int i = 0; i < 3; i++) {
//			try {
//				ba.handleWebTable("//*[@role='table']/tbody/tr", indexId.trim(), 2, "clickItem");
//
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//
//		}// for loop end
//		
//		// click on the check list check boxes
//
//		ba.retryMechanism(driver, getFirstCheckBox());
//		ba.retryMechanism(driver, getSecondCheckBox());
//      
//		logger.info("Click on draft invoice check boxes");
//	}
//
//	public void SendFinalInvoice() throws Throwable {
//		
//		wait.until(ExpectedConditions.elementToBeClickable(getSendToFinalInvoiceTab())).click();
//		
//		 js.executeScript("arguments[0].scrollIntoView(true);", getsendBtn());
//		  Thread.sleep(1000);
//		  
//		  wait.until(ExpectedConditions.elementToBeClickable(getcheckboxEmailRcp())).click();  
//		  wait.until(ExpectedConditions.elementToBeClickable(getsendBtn())).click();   
//		
//	}
//	
//	public void clickOnInvoiceNoInFinalInvoicePg(String invoiceNo) throws InterruptedException {
//		
//		 wait.until(ExpectedConditions.elementToBeClickable(getfinalInvoiceTab())).click();
//		 
//			wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).clear();
//			wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).sendKeys(invoiceNo);
//		//	wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).click();
//			Thread.sleep(500);
//		 ba.handleWebTable("//*[@role='table']/tbody/tr", invoiceNo, 2, "clickItem");
//		
//	}
//	
//	public void clickOn_OnHoldInvoice() throws Throwable {
//		
//		  js.executeScript("arguments[0].scrollIntoView(true);", manualinvoicePg.getclick_On_Hold_button());
//		  Thread.sleep(1000);
//      ba.retryMechanism(driver, manualinvoicePg.getclick_On_Hold_button());
//		  
//		
//		  Thread.sleep(1000);
//		  ba.retryMechanismWithSendKeys(driver, manualinvoicePg.getpass_text(), "Not Applicable");
//		 
//		  ba.retryMechanism(driver, manualinvoicePg.getclickOk());
//		  
//		  logger.info("Final Invoice on-hold");
//	}
//	
//public void gotToOnHoldInvoiceTab_And_Release (String manualInvoiceNo, int td) throws InterruptedException {
//		
//		
//		Thread.sleep(1000);
//		js.executeScript("window.scrollTo(0, 0);");
//		
//		Thread.sleep(2000);
//		 ba.retryMechanism(driver, getholdInvoiceTab());
//		 
//		 Thread.sleep(1000);
//		  wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).clear();
//		  wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).sendKeys(manualInvoiceNo);
//		  wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).click();
//		  
//		  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
//		  Thread.sleep(500);
//		  js.executeScript("arguments[0].scrollIntoView(true);", creditInvoicePg.getbottom());
//			Thread.sleep(500);
//		 ba.retryMechanism(driver, manualinvoicePg.getclick_release_button());
//		 
//		 Thread.sleep(2000);
//		
//		 ba.retryMechanismWithSendKeys(driver, manualinvoicePg.getpass_text(), "Not Applicable");
//		 
//		
//		 ba.retryMechanism(driver, manualinvoicePg.getClkOKunderHoldTab());
//		 
//		 Thread.sleep(3000);
//		 
//		 logger.info("Final Invoice Released");
//		
//		
//	}
//
//public void postFinalInvoice(String manualInvoiceNo, int td) throws InterruptedException {
//	js.executeScript("window.scrollTo(0, 0);");
//	 Thread.sleep(500);
//	 wait.until(ExpectedConditions.elementToBeClickable(getfinalInvoiceTab())).click();
//	 Thread.sleep(1000);
//	  wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).clear();
//	  wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).sendKeys(manualInvoiceNo);
//	 // wait.until(ExpectedConditions.elementToBeClickable(manualinvoicePg.getsearch())).click();
//	  Thread.sleep(500);
//	  ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
//	 
//	  Thread.sleep(1000);
//	
//	  js.executeScript("arguments[0].scrollIntoView(true);", creditInvoicePg.getbottom());
//	  Thread.sleep(500);
//	  wait.until(ExpectedConditions.elementToBeClickable(getcheckSoxApproved())).click();
//	  wait.until(ExpectedConditions.elementToBeClickable(getpostInvoiceBtn())).click();
//	  
//	  js.executeScript("arguments[0].scrollIntoView(true);", getpostBtn());
//	  Thread.sleep(1000);
//	  
//	  wait.until(ExpectedConditions.elementToBeClickable(getpostBtn())).click();
//	  
//	  logger.info("Final manual Invoice Posted");
//}
//	
//
//@SuppressWarnings("deprecation")
//public void gotToPostInvoiceTab_And_Validate_data (String manualInvoiceNo, int td) throws InterruptedException {
//	
//	 Thread.sleep(2000);
//
//	 ba.retryMechanism(driver, getinvoicePostedTab());
//	 
//	
//	 ba.handleWebTable("//*[@role='table']/tbody/tr", manualInvoiceNo, td, "clickItem");
//
//
//	String unitcost= getunitCost().getAttribute("value");
//
//	String quantity= gettableQnty().getAttribute("value");
//	String ponumber=(String) js.executeScript("return arguments[0].value;", gettablePONumber());
//	
//	try {Assert.assertEquals(unitcost, "12.00000");
//
//	Assert.assertEquals(quantity, "200");
//	Assert.assertEquals(ponumber, "PO2020202");
//	
//	System.out.println("Details are verified successfully");
//	logger.info("Details are verified successfully");
//	}
//	catch (AssertionError e) {	
//		e.printStackTrace();
//		System.out.println("Validation failed");
//		logger.info("Validation failed");
//	}
//	
//	
//}
//
//}
