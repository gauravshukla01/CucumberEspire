package pageObjects;

import java.util.List;

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

import CommmonUtils.BaseAction;

public class ManageCampaignPage {

	private WebDriver driver;
	private JavascriptExecutor js;
	private BaseAction ba;
	private int i;

	// WebElement

	@FindBy(xpath = ("//*[@id='mat-expansion-panel-header-2']"))
	private WebElement EditDelivery;

	@FindBy(xpath = ("//label[@for='mat-radio-8-input']//span[@class='mat-radio-container']"))
	private WebElement ChckBoxNonApplicable;

	@FindBy(xpath = ("//span[normalize-space()='Save & Close']"))
	private WebElement saveAndClose;

	@FindBy(xpath = ("//campaign-item-supplier-price-table[@class='ng-star-inserted']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"))
	private WebElement checkBox;

	@FindBy(xpath = ("//*[text()='Manage Quotes ']"))
	private WebElement manageQuoteButton;

	@FindBy(xpath = ("//input[@name='markUp']"))
	private WebElement markup;

	@FindBy(xpath = ("//i[@class='fas fa-chevron-circle-right fa-3x']"))
	private WebElement generateQuote;

	// Getter method for WebElement

	public WebElement getEditDelivery() {
		return EditDelivery;
	}

	public WebElement getChckBoxNonApplicable() {
		return ChckBoxNonApplicable;
	}

	public WebElement getsaveAndClose() {
		return saveAndClose;
	}

	public WebElement getcheckBox() {
		return checkBox;
	}

	public WebElement getmanageQuoteButton() {
		return manageQuoteButton;
	}

	public WebElement getmarkup() {
		return markup;
	}

	public WebElement getgenerateQuote() {
		return generateQuote;
	}

	public WebElement getmanageItemButton(int i) {
		return driver.findElement(By.xpath("//*[@role='table']//tbody/tr[" + i
				+ "]//*[@class='mat-cell cdk-cell cdk-column-CampaignItemReference mat-column-CampaignItemReference ng-star-inserted']"));
	}

	public WebElement getsubmitCosting(int i) {
		return driver.findElement(By.xpath(
				"//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/submit-for-costing-pound.svg']"));
	}

	public WebElement getClckManagePrice()

	{
		return driver.findElement(By
				.xpath("//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/submit-supplier-price.svg']"));
	}

	public WebElement getSupplierPrice() {
		return driver.findElement(
				By.xpath("//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/view-supplier-price.svg']"));
	}

	public ManageCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);

	}
	
	
	 private static final Logger logger = LogManager.getLogger(ManageCampaignPage.class);


	public void DetailsForsubmitCosting() throws InterruptedException {

		int rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "Created", 7, "getRowNum");

		i = rowNum;

		js.executeScript("arguments[0].scrollIntoView();", getmanageItemButton(i));
		ba.retryMechanism(driver, getmanageItemButton(i));

		// Edit delivery
		js.executeScript("arguments[0].scrollIntoView();", EditDelivery);
        
		Thread.sleep(1000);
		ba.retryMechanism(driver, EditDelivery);

		// Click checkbox nonApplicable
		ba.retryMechanism(driver, ChckBoxNonApplicable);

		// WebElement saveAndClose
		ba.retryMechanism(driver, saveAndClose);
		
		logger.info("Edit delivery option as NA and save and close");

	}

	public void validateItemAddedPopup() {

		ba.validatePopUp("Campaign Item has been modified successfully.",
				"Campaign item modification popup validated successfully.");
	}

	public void ClicksubmitCostingButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", getsubmitCosting(i));
		ba.retryMechanism(driver, getsubmitCosting(i));
		logger.info("Clicked on submit for costing");

	}

	public void validateSubmitCostPopup() {

		ba.validatePopUp("Submit Campaign Item Submitted",
				"Campaign item Cost submission popup validated successfully.");
	}

	public void selectSupplierPrice() throws InterruptedException {

		// click on manage prices

		// add value of i(rownum) in the hashmap
		ba.retryMechanism(driver, getClckManagePrice());

		// WebElement checkBox
		ba.retryMechanism(driver, checkBox);
		// checkBox.click();

		ba.retryMechanism(driver, getmanageQuoteButton());
		logger.info("Select manage price");
	}

	public void validateItemSelectedPopup() {

		ba.validatePopUp("Campaign Item selected cost price has been created successfully.",
				"Campaign item selection popup validated successfully.");
	}

	public void CreateQuote() {

		// Add markup value
		ba.retryMechanismWithSendKeys(driver, markup, "10");

		// Generate Quote
		ba.retryMechanism(driver, generateQuote);
		logger.info("Quote created");
	}

	public void validateQuoteGeneratedPopup() {

		ba.validatePopUp("Campaign Item quote generated has been created successfully.",
				"Quote Generation popup validated successfully.");
	}

	public void clickSupplierPricebutton() {
		// Submit supplier price

		js.executeScript("arguments[0].scrollIntoView();", getSupplierPrice());
		ba.retryMechanism(driver, getSupplierPrice());
		logger.info("Clicked on supplier price button");

	}
}
