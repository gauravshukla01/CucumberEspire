//package pageObjects;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
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
//
//public class SalesOrderPage {
//
//	private WebDriver driver;
//	private WebDriverWait wait;
//
//	private BaseClass ba;
//	SalesInvoicePage salesinvoicepage;
//
//	@FindBy(xpath = ("//*[@id='sideNav']"))
//	private WebElement sidenav;
//
//	@FindBy(xpath = ("//a/*[@src='assets/images/finance-module.svg']"))
//	private WebElement finance;
//
//	@FindBy(xpath = "//a/img[@src='assets/images/workflow.svg']")
//	private WebElement workflow;
//
//	@FindBy(xpath = "//a[normalize-space()='Campaigns']")
//	private WebElement campaigns;
//
//	@FindBy(xpath = "//input[@placeholder='Search..']")
//	private WebElement search;
//
//	@FindBy(xpath = ("//*[text()=' Sales Orders']"))
//	private WebElement salesorder;
//
//	@FindBy(xpath = "//*[text()=' Create Draft Invoice']")
//	private WebElement DraftInvoiceButton;
//
//	@FindBy(xpath = "//button/span[text()=' OK ']")
//	private WebElement OkButton;
//
//	@FindBy(xpath = "//*[text()='Close']")
//	private WebElement closeButton;
//
//	@FindBy(xpath = "//*[@role='table']/tbody/tr//div/input")
//	private WebElement poNoBox;
//
//	@FindBy(xpath = "//mat-tab-body/div[1]/div[1]/app-sales-order-line-management[1]/div[1]/div[1]/button[2]/span[1]/img[1]")
//	private WebElement CancelSOLinesButton;
//
//	@FindBy(xpath = "//*[@id='SoCancelReason']")
//	private WebElement reasonForCancel;
//
//	@FindBy(xpath = "//*[contains(text(),' Cancel Sales Order not invoiced to Client')]")
//	private WebElement SelectreasonForCancel;
//
//	@FindBy(xpath = "//*[@id='cancelReasonText']")
//	private WebElement reasonCancelText;
//
//	@FindBy(xpath = "//*[text()=' Confirm ']")
//	private WebElement reasonCancelConfirmButton;
//
//
//
//	public WebElement getCancelSOLinesButton() {
//		return CancelSOLinesButton;
//	}
//
//	public WebElement getreasonForCancel() {
//		return reasonForCancel;
//	}
//
//	public WebElement getSelectreasonForCancel() {
//		return SelectreasonForCancel;
//	}
//
//	public WebElement getreasonCancelText() {
//		return reasonCancelText;
//	}
//
//	public WebElement getreasonCancelConfirmButton() {
//		return reasonCancelConfirmButton;
//	}
//
//	public WebElement getfinance() {
//		return finance;
//	}
//
//	public WebElement getsidenav() {
//		return sidenav;
//	}
//
//	public WebElement getworkflow() {
//		return workflow;
//	}
//
//	public WebElement getcampaigns() {
//		return campaigns;
//	}
//
//	public WebElement getsearch() {
//		return search;
//	}
//
//	public WebElement getsalesorder() {
//		return salesorder;
//	}
//
//	public WebElement getDraftInvoiceButton() {
//		return DraftInvoiceButton;
//	}
//
//	public WebElement getOkButton() {
//		return OkButton;
//	}
//
//	public WebElement getcloseButton() {
//		return closeButton;
//	}
//
//	public WebElement getpoNum() {
//		return poNoBox;
//	}
//
//	public SalesOrderPage(WebDriver driver) {
//		this.driver = driver;
//
//		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//		ba = new BaseClass(driver);
//		PageFactory.initElements(driver, this);
//
//	}
//	private static final Logger logger = LogManager.getLogger(SalesOrderPage.class);
//
//	public void goToCampaingPg() {
//
//		// click on workflow icon
//
//		wait.until(ExpectedConditions.elementToBeClickable(getworkflow())).click();
//		// click on campaign icon
//		wait.until(ExpectedConditions.elementToBeClickable(getcampaigns())).click();
//
//		logger.info("Landed on campaign page");
//		// clear search
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
//
//	}
//
//	public void searchItem(String status) {
//		// click on the search icon to get the context on the base page
//
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
//
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(status);
//
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + status + "']"))).click();
//
//		logger.info("Item Searched and clicked");
//	}
//
//	public String getCampIdPOReciept(String status) throws InterruptedException {
//
//		String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status, 1, "getText");
//		System.out.println("campaign_ID = " + campaign_ID);
//		logger.info("Item Searched and clicked");
//		return campaign_ID;
//
//	}
//
//	public void clickOnCampID(String cmpId, int td) throws InterruptedException {
//
//		for (int i = 0; i < 3; i++) {
//			try {
//
//				ba.handleWebTable("//*[@role='table']/tbody/tr", cmpId, td, "clickItem");
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//			logger.info("Clicked on stored Camapign Id");
//		} // end of for loop
//
//	}
//
//	public String getIndexCampId(String status) throws InterruptedException {
//		// validating status as PO receipted
//		String indexId = ba.handleWebTable("//*[@role='table']/tbody/tr", status, 2, "getText");
//		System.out.println("campaign_Index_ID = " + indexId);
//		logger.info("fetched campaignId item number");
//		return indexId;
//	}
//
//	public void goToSaleOrderPg() throws InterruptedException {
//		// navigating to Finance
//
//		wait.until(ExpectedConditions.elementToBeClickable(getfinance())).click();
//
//		// click on Sales order
//		wait.until(ExpectedConditions.elementToBeClickable(getsalesorder())).click();
//		// clear search
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
//		logger.info("landed on sales order page");
//	}
//
//	public void createDraftInvoice(String campId) throws InterruptedException {
//		String status;
//		// enter PO number
//
//		wait.until(ExpectedConditions.elementToBeClickable(poNoBox)).clear();
//		ba.retryMechanismWithSendKeys(driver, poNoBox, "PO1010101");
//
//		logger.info("entered PO number");
//
//		// click on check box
//
//		for (int i = 0; i < 3; i++) {
//			try {
//				ba.handleWebTable("//*[@role='table']/tbody/tr", campId.trim(), 2, "clickItem"); // hard coded value
//				break;
//			} catch (StaleElementReferenceException e) {
//				e.printStackTrace();
//			}
//
//		} // end of for loop
//
//		// click on create draft invoice
//
//		ba.retryMechanism(driver, getDraftInvoiceButton());
//
//		logger.info("clicked create draft invoice");
//		// click on ok in pop-up
//		wait.until(ExpectedConditions.elementToBeClickable(getOkButton()));
//		ba.retryMechanism(driver, getOkButton());
//
//		// click on close in pop-up
//		wait.until(ExpectedConditions.elementToBeClickable(getcloseButton()));
//		ba.retryMechanism(driver, getcloseButton());
//
//		// Assertion for Receipt tab
//		status = ba.handleWebTable("//*[@role='table']/tbody/tr", campId.trim(), 19, "getText");
//		Assert.assertEquals("Draft Invoice", status);
//		System.out.println("Draft Invoice-Assert Verified");
//
//
//	}
//
//	public void clickOnReceiptedCampaign (String UTno) throws InterruptedException {
//
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
//		ba.retryMechanismWithSendKeys(driver, getsearch(), UTno);
//
//
//		ba.handleWebTable("//*[@role='table']/tbody/tr", "LEAD", 2, "clickItem");
//		Thread.sleep(2000);
//	}
//
//	public void clickOnCheckBoxToCancelSOLines (String utr) throws InterruptedException {
//
//		ba.handleWebTable("//*[@role='table']/tbody/tr", utr, 2, "clickItem");
//
//
//	}
//
//	public void SaleslineCancellationReason () {
//
//		ba.retryMechanism(driver, getCancelSOLinesButton());
//
//		ba.retryMechanism(driver, getreasonForCancel());
//
//		ba.retryMechanism(driver, getSelectreasonForCancel());
//
//		ba.retryMechanismWithSendKeys(driver, getreasonCancelText(), "Not Applicable");
//
//
//
//	}
//	public void SaleslineCancellationReasonConfirmation () {
//		ba.retryMechanism(driver, getreasonCancelConfirmButton());
//
//	}
//
//
//	public void VerifySOLineStatus (String UTnumber) throws InterruptedException {
//
//		try {
//		String soLineStatus = ba.handleWebTable("//*[@role='table']/tbody/tr", UTnumber, 19, "getText");
//		Assert.assertEquals(soLineStatus, "Cancelled Sales Order");
//		
//		System.out.println("SO Line successful cancellation validated successfully");
//		}
//		catch(Exception e) {
//		System.out.println("Validation fail");
//		}
//	}
//}
