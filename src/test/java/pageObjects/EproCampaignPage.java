package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EproCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	private final By element5 = By.xpath("//img[@src='assets/images/assign-suppliers.svg']");
	private final By element = By.xpath("//div[@id='mat-select-value-13']");

	public EproCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void clkAddCampaign() {

		// click on add icon

		WebElement addcampaignButton = driver.findElement(element5);
		js.executeScript("arguments[0].scrollIntoView();", addcampaignButton);
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element5)).click();
		

//	         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"))).click();
		// click on business unit box //div[@id='mat-select-value-13']

		WebElement addcampaignButton2 = driver.findElement(element);
		js.executeScript("arguments[0].scrollIntoView();", addcampaignButton2);

		wait.until(ExpectedConditions.elementToBeClickable(addcampaignButton2)).click();

//	         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mat-select-value-13']"))).click();
	}

}
