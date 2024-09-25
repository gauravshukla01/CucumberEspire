//package pageObjects;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import CommmonUtils.BaseClass;
//
//public class AddCampaignItemPage extends BaseClass {
//
//
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public JavascriptExecutor js;
//	private static final Logger logger = LogManager.getLogger(EproLoginPage.class);
//
//	
//
//	@FindBy(xpath="//button[@class='mat-focus-indicator mat-tooltip-trigger fab-secondary mat-fab mat-button-base mat-secondary']")
//	private WebElement addItemButton;
//	
//	@FindBy(xpath="//span[@class='mat-button-wrapper']")
//	private WebElement prefilledTemplates;
//	
//	@FindBy(xpath="//input[@id='txt203']")
//	private WebElement numbOfItem;
//	
//	@FindBy(xpath="//input[@id='qua203']")
//	private WebElement numbOfQuatity;
//	
//	@FindBy(xpath="//label[@for='check203-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
//	private WebElement clickcheckbox;
//	
//	@FindBy(xpath="//tbody/tr[2]/td[11]/button[1]/span[1]/img[1]")
//	private WebElement clickonaddsign;
//	
//	@FindBy(xpath="//*[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")
//	private WebElement clickOnYes;
//
//
//
//
//	public WebElement getaddItemButton() {
//		return addItemButton;
//	}
//	public WebElement getprefilledTemplates() {
//		return prefilledTemplates;
//	}
//	public WebElement getnumbOfItem() {
//		return numbOfItem;
//	}
//	public WebElement getnumbOfQuatity() {
//		return numbOfQuatity;
//	}
//	public WebElement getclickcheckbox() {
//		return clickcheckbox;
//	}
//	public WebElement getclickonaddsign() {
//		return clickonaddsign;
//	}
//	public WebElement getclickOnYes() {
//		return clickOnYes;
//	}
//
//
//
//	public AddCampaignItemPage(WebDriver driver) {
//		this.driver=driver;
//		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//		this.js = (JavascriptExecutor) driver;
//		PageFactory.initElements(driver, this);
//
//	}
//	
//	public void addItemDetails(String NumberOfItems, String Quantity ) throws InterruptedException {
//
//		// Click add item button
//		clickOnElement(driver, addItemButton);
//
//		// Click ob prefilled templates
//		Thread.sleep(2000);
//		clickOnElement(driver, getprefilledTemplates());
//
//
//		// enter number of item
//		sendKeys(driver, getnumbOfItem(), NumberOfItems);
//
//
//		// enter quantity			
//		sendKeys(driver, getnumbOfQuatity(), Quantity);
//
//
//		// clickcheckbox
//		clickOnElement(driver, getclickcheckbox());
//
//
//
//		// click on Plus sign
//		
//		handleWebTable("//*[@role='table']/tbody/tr", "C5 test", 11, "clickItem");
//		//ba.retryMechanism(driver, getclickonaddsign());
//
//
//
//		// Click yes on popup
//		// driver.switchTo().alert().accept();
//		clickOnElement(driver, getclickOnYes());
//
//
//		logger.info("Campaign Item details entered");
//
//	}
//
//
//	public void validateCreateCampaignPopup() {
//
//		//	ba.validatePopUp("Campaign Items has been created successfully.","Campaign item creation popup validated successfully.");
//	}
//}
