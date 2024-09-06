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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import CommmonUtils.BaseAction;

public class EproCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	@FindBy(xpath = "//img[@src='assets/images/assign-suppliers.svg']")
	private WebElement addIconButton;
	@FindBy(xpath = "//input[@placeholder='Search..']")
	private WebElement Search;
	@FindBy(xpath = "//*[@role='table']/tbody/tr")
	private WebElement baseTable;
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),' Yes')]")
	private WebElement yesBtn;
	@FindBy(xpath = "//*[text()='Close']")
	private WebElement closeBtn;

	public WebElement getaddIconButton() {
		return addIconButton;
	}

	public WebElement getSearch() {
		return Search;
	}

	public WebElement getManageCAmp(String num) {
		return driver.findElement(By.xpath("//*[text()='" + num + "']"));
	}

	public WebElement getbaseTable() {
		return baseTable;
	}

	public WebElement getSendForApproal(int rowNum) {
		return driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr[" + rowNum
				+ "]/td/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']"));
	}

	public WebElement getGenerate_doc_create_po(int rowNum) {
		return driver.findElement(By.xpath("//table[@role='table']//tbody/tr[" + rowNum
				+ "]/td/button[not(@hidden)]//img[@src='assets/images/generate_doc_create_po.svg']"));
	}

	public WebElement getyesBtn() {
		return yesBtn;
	}

	public WebElement getcloseBtn() {
		return closeBtn;
	}

	public EproCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
	}

	private static final Logger logger = LogManager.getLogger(EproCampaignPage.class);


	public void clkAddCampaign() {

		// click on add icon
		wait.until(ExpectedConditions.elementToBeClickable(getaddIconButton())).click();
		logger.info("Clicked on add campaign");
	}

	public void clickOnCampaignId(String num) {

		// click on the search icon to get the context on the base page

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).clear();

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).sendKeys(num);

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).click();
		// click on Manage campaign
		ba.retryMechanism(driver, getManageCAmp(num));

		logger.info("Clicked on campaignID");

	}

	public void clickOnCampID(String status) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).clear();

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).sendKeys(status);

		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).click();

		ba.handleWebTable("//*[@role='table']/tbody/tr", status, 1, "clickItem");
		
		//Assert for quote Accepted
		String	Assertstatus=ba.handleWebTable("//*[@role='table']/tbody/tr", status, 7, "getText");
			System.out.println(Assertstatus);
			//Assert.assertEquals(status, "PO Approved");
			Assert.assertEquals(status, Assertstatus);
			System.out.println("Quote Accepted Status Validated Successfully");
	  
		
		 logger.info("Clicked on campaignID");
		
		
	}

	public void SendPO() throws InterruptedException {
		// click on send po button

		int rowNum;
		rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getRowNum");

		ba.retryMechanism(driver, getSendForApproal(rowNum));

		ba.retryMechanism(driver, getyesBtn());
		
		//Assert for PO Approved
	String	status=ba.handleWebTable("//*[@role='table']/tbody/tr", "PO Approved", 7, "getText");
		Assert.assertEquals("PO Approved", status);
		System.out.println("PO Successfully Approved-Assert Verified");
		logger.info("Clicked on Send PO");
		
		
		/*
		 * // Create PO
		 * 
		 * ba.retryMechanism(driver, getGenerate_doc_create_po(rowNum));
		 * 
		 * // click on close (popup) ba.retryMechanism(driver, getcloseBtn());
		 * 
		 * //Assert for PO Created
		 * status=ba.handleWebTable("//*[@role='table']/tbody/tr", "PO Created", 7,
		 * "getText"); Assert.assertEquals("PO Created", status);
		 * System.out.println("PO Successfully Created-Assert Verified");
		 * 
		 * logger.info("Clicked on create PO");
		 */

	}
	
	public void CreatePO() throws InterruptedException {
		// Create PO
		int rowNum;
		rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "PO Approved", 2, "getRowNum");

				ba.retryMechanism(driver, getGenerate_doc_create_po(rowNum)); 

				// click on close (popup)
				ba.retryMechanism(driver, getcloseBtn());
				
				//Assert for PO Created
			String	status=ba.handleWebTable("//*[@role='table']/tbody/tr", "PO Created", 7, "getText");
				AssertJUnit.assertEquals("PO Created", status);
				System.out.println("PO Successfully Created-Assert Verified");

				 logger.info("Clicked on create PO");
	}
	
	public String getIndexValue() throws InterruptedException {
		String indcampaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", "PO Created", 2, "getText");
		System.out.println("campaign_ID = " + indcampaign_ID);

		return indcampaign_ID;

	}
}