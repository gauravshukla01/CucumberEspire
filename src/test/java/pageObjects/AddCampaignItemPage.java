package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;
import otherResources.TestContext;

public class AddCampaignItemPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	TestContext testContext;

	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public AddCampaignItemPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		
	
	}

	
	public void addItemDetails() throws InterruptedException {
		
		// Click add item button
				WebElement addItemButton = driver.findElement(By.xpath(
						"//button[@class='mat-focus-indicator mat-tooltip-trigger fab-secondary mat-fab mat-button-base mat-secondary']"));
				ba.retryMechanism(driver, addItemButton);

				// Click ob prefilled templates
				Thread.sleep(2000);
				WebElement prefilledTemplates = driver.findElement(By.xpath("//span[@class='mat-button-wrapper']"));
				ba.retryMechanism(driver, prefilledTemplates);

				// enter number of item
				WebElement numbOfItem = driver.findElement(By.xpath("//input[@id='txt203']"));
				ba.retryMechanismWithSendKeys(driver, numbOfItem, "1");

				// enter quantity
				WebElement numbOfQuatity = driver.findElement(By.xpath("//input[@id='qua203']"));
				ba.retryMechanismWithSendKeys(driver, numbOfQuatity, "20");

				// clickcheckbox

				WebElement clickcheckbox = driver.findElement(By.xpath(
						"//label[@for='check203-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"));
				ba.retryMechanism(driver, clickcheckbox);

				// click on Plus sign

				WebElement clickonaddsign = driver.findElement(By.xpath("//tbody/tr[1]/td[11]/button[1]/span[1]/img[1]"));
				ba.retryMechanism(driver, clickonaddsign);

				// Click yes on popup

				// driver.switchTo().alert().accept();

				WebElement clickOnYes = driver.findElement(
						By.xpath("//*[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']"));
				ba.retryMechanism(driver, clickOnYes);


		
		
	}


	public void validateCreateCampaignPopup() {
		
		ba.validatePopUp("Campaign Items has been created successfully.","Campaign item creation popup validated successfully.");
	}
}
