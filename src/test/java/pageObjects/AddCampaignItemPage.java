package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;
import otherResources.TestContext;

public class AddCampaignItemPage {


	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	TestContext testContext;

	

	@FindBy(xpath="//button[@class='mat-focus-indicator mat-tooltip-trigger fab-secondary mat-fab mat-button-base mat-secondary']")
	private WebElement addItemButton;
	@FindBy(xpath="//span[@class='mat-button-wrapper']")
	private WebElement prefilledTemplates;
	@FindBy(xpath="//input[@id='txt203']")
	private WebElement numbOfItem;
	@FindBy(xpath="//input[@id='qua203']")
	private WebElement numbOfQuatity;
	@FindBy(xpath="//label[@for='check203-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	private WebElement clickcheckbox;
	@FindBy(xpath="//tbody/tr[2]/td[11]/button[1]/span[1]/img[1]")
	private WebElement clickonaddsign;
	@FindBy(xpath="//*[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary1']")//added 1
	private WebElement clickOnYes;




	public WebElement getaddItemButton() {
		return addItemButton;
	}
	public WebElement getprefilledTemplates() {
		return prefilledTemplates;
	}
	public WebElement getnumbOfItem() {
		return numbOfItem;
	}
	public WebElement getnumbOfQuatity() {
		return numbOfQuatity;
	}
	public WebElement getclickcheckbox() {
		return clickcheckbox;
	}
	public WebElement getclickonaddsign() {
		return clickonaddsign;
	}
	public WebElement getclickOnYes() {
		return clickOnYes;
	}



	public AddCampaignItemPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		 PageFactory.initElements(driver, this);

	}


	public void addItemDetails() throws InterruptedException {

		// Click add item button
		ba.retryMechanism(driver, getaddItemButton());


		// Click ob prefilled templates
		
		ba.retryMechanism(driver, getprefilledTemplates());


		// enter number of item
		ba.retryMechanismWithSendKeys(driver, getnumbOfItem(), "1");


		// enter quantity			
		ba.retryMechanismWithSendKeys(driver, getnumbOfQuatity(), "20");


		// clickcheckbox
		ba.retryMechanism(driver, getclickcheckbox());



		// click on Plus sign
		
		ba.handleWebTable("//*[@role='table']/tbody/tr", "C5 test", 11, "clickItem");
		//ba.retryMechanism(driver, getclickonaddsign());



		// Click yes on popup
		// driver.switchTo().alert().accept();
		ba.retryMechanism(driver, getclickOnYes());




	}


	public void validateCreateCampaignPopup() {

		//	ba.validatePopUp("Campaign Items has been created successfully.","Campaign item creation popup validated successfully.");
	}
}
