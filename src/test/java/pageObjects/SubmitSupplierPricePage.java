package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class SubmitSupplierPricePage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	
	
	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public SubmitSupplierPricePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
	
		
	}



	
	
	public void addSupplierPriceDetails() throws InterruptedException {
	
				// Select Paragon Dagenham from searchbox

				WebElement ClickSearchBox = driver.findElement(By.xpath("//*[@id='SsupplierId']"));
				// js.executeScript("arguments[0].scrollIntoView();", ClickSearchBox);
				ba.retryMechanism(driver, ClickSearchBox);
				WebElement Search = driver.findElement(By.xpath(
						"//input[@class='mat-input-element mat-form-field-autofill-control mat-select-search-input cdk-text-field-autofill-monitored']"));

				ba.retryMechanismWithSendKeys(driver, Search, "Paragon");

				WebElement selectDagenham = driver.findElement(By.xpath("//span[contains(text(),'Paragon CC (Dagenham)')]"));
				// js.executeScript("arguments[0].scrollIntoView();", selectDagenham);
				// ba.retryMechanismWithSendKeys(driver, ClickSearchBox, "paragon CC
				// (Dagenham)");
				ba.retryMechanism(driver, selectDagenham);

				// //enter estimate ref no
				Thread.sleep(2000);
				WebElement enterEstimateRefNo = driver.findElement(By.xpath("//input[@id='f']"));
				ba.retryMechanismWithSendKeys(driver, enterEstimateRefNo, "ERN09876");

				Thread.sleep(2000);

				WebElement deliveryCost = driver.findElement(By.xpath("(//input[@id='qt'])[1]"));
				ba.retryMechanismWithSendKeys(driver, deliveryCost, "123");

				Thread.sleep(2000);
				WebElement PaperCost = driver.findElement(By.xpath("(//input[@id='qt'])[2]"));
				// js.executeScript("arguments[0].scrollIntoView();", PaperCost);
				ba.retryMechanismWithSendKeys(driver, PaperCost, "1234");

				Thread.sleep(2000);
				WebElement production = driver.findElement(By.xpath("(//input[@id='qt'])[3]"));
				// js.executeScript("arguments[0].scrollIntoView();", production);
				ba.retryMechanismWithSendKeys(driver, production, "12");

				Thread.sleep(2000);
				WebElement submitcostPrice = driver.findElement(By.xpath("//button[@type='submit']"));
				
				
				
				js.executeScript("arguments[0].scrollIntoView();", submitcostPrice);
				ba.retryMechanism(driver, submitcostPrice);
				
			

				System.out.println("Submit button is clicked after supplier submit");

		
	}	
	
	
}
