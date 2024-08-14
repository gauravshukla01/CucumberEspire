package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class ManageCampaignPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
    public int i;
	
	
	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public ManageCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		
	}
	
	
	public void DetailsForsubmitCosting() throws InterruptedException {
		
		List<WebElement> listEle = driver.findElements(By.xpath("//*[@role='table']/tbody/tr"));

		System.out.println("row count ="+listEle.size());
		

		int rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "Created", 7, "getRowNum");
		System.out.println("row num =" + rowNum);
		i = rowNum;

		WebElement manageItemButton = driver.findElement(By.xpath("//*[@role='table']//tbody/tr[" + i
				+ "]//*[@class='mat-cell cdk-cell cdk-column-CampaignItemReference mat-column-CampaignItemReference ng-star-inserted']"));
		js.executeScript("arguments[0].scrollIntoView();", manageItemButton);
		// ba.retryMechanism(driver,submitCosting);
		// WebElement manageItemButton = driver.findElement(By.xpath("//*[text()='
		// UT01109-001 ']"));
		ba.retryMechanism(driver, manageItemButton);

		// Edit delivery =

		WebElement EditDelivery = driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-2']"));
		js.executeScript("arguments[0].scrollIntoView();", EditDelivery);

		ba.retryMechanism(driver, EditDelivery);

		//

		// Click checkbox nonApplicable

		WebElement ChckBoxNonApplicable = driver
				.findElement(By.xpath("//label[@for='mat-radio-8-input']//span[@class='mat-radio-container']"));
		ba.retryMechanism(driver, ChckBoxNonApplicable);

		//

		// Save & close
		WebElement saveAndClose = driver.findElement(By.xpath("//span[normalize-space()='Save & Close']"));
		ba.retryMechanism(driver, saveAndClose);

		/*
		 * //veiwAll100Entries WebElement pageEntry =
		 * driver.findElement(By.xpath("//div[@id='mat-select-value-29']")); WebElement
		 * clck100 = driver.findElement(By.xpath(" //span[normalize-space()='100']"));
		 * ba.retryMechanism(driver,pageEntry); ba.retryMechanism(driver,clck100);
		 */
		
    Thread.sleep(1000);
		// Submit for costing

		// List<WebElement> listEle =
		// driver.findElements(By.xpath("//*[@role='table']//tbody/tr"));

		// System.out.println(listEle.size());

		// click on submit costing Remove this
	}
	public void validateItemAddedPopup() {
		
		ba.validatePopUp("Campaign Item has been modified successfully.", "Campaign item modification popup validated successfully.");
	}
	
	public void ClicksubmitCostingButton() throws InterruptedException {
		WebElement submitCosting = driver.findElement(By.xpath(
				"//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/submit-for-costing-pound.svg']"));
		js.executeScript("arguments[0].scrollIntoView();", submitCosting);
		ba.retryMechanism(driver, submitCosting);
		//// tbody/tr[9]/td[11]/button[2]/span[1]/div[1]/img[1]
		// *[@role='table']//tbody/tr
		Thread.sleep(1000);
	}
public void validateSubmitCostPopup() {
		
		ba.validatePopUp("Submit Campaign Item Submitted", "Campaign item Cost submission popup validated successfully.");
	}
	
	
	public void selectSupplierPrice() throws InterruptedException {
		
		
		
		// click on manage prices
		
		
		//add value of i(rownum) in the hashmap
				WebElement ClckManagePrice = driver.findElement(By
						.xpath("//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/submit-supplier-price.svg']"));
				js.executeScript("arguments[0].scrollIntoView();", ClckManagePrice);
				ba.retryMechanism(driver, ClckManagePrice);

				Thread.sleep(2000);
				WebElement checkBox = driver.findElement(By.xpath("//campaign-item-supplier-price-table[@class='ng-star-inserted']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"));
				js.executeScript("arguments[0].scrollIntoView();", checkBox);
				checkBox.click();

				WebElement manageQuoteButton = driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-right fa-3x']"));
				ba.retryMechanism(driver, manageQuoteButton);
	}
	
	
	public void validateItemSelectedPopup() {
		
		ba.validatePopUp("\r\n"
				+ "Campaign Item selected cost price has been created successfully.", "Campaign item selection popup validated successfully.");
	}
				
				public void CreateQuote() {
				WebElement markup = driver.findElement(By.xpath("//input[@name='markUp']"));
				ba.retryMechanismWithSendKeys(driver, markup, "10");

				WebElement generateQuote = driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-right fa-3x']"));
				ba.retryMechanism(driver, generateQuote);
	}
				
				
				public void validateQuoteGeneratedPopup() {
					
					ba.validatePopUp("Campaign Item quote generated has been created successfully.", "Quote Generation popup validated successfully.");
				}
				
				
				
	
	public void clickSupplierPricebutton() {
		// Submit supplier price
		
		//add value of i(rownum) in the hashmap
				WebElement SupplierPrice = driver.findElement(
						By.xpath("//*[@role='table']//tbody/tr[" + i + "]//img[@src='assets/images/view-supplier-price.svg']"));
				js.executeScript("arguments[0].scrollIntoView();", SupplierPrice);
				ba.retryMechanism(driver, SupplierPrice);
	}
}
