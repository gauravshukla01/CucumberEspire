package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EproCreateCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public EproCreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void selectBusinessUnit() throws InterruptedException {

		
		Thread.sleep(4000);
		// click on select value within the box
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		
		
		WebElement selectBusinessU = driver.findElement(element1);
		js.executeScript("arguments[0].scrollIntoView();", selectBusinessU);

		wait.until(ExpectedConditions.elementToBeClickable(element1)).click();

//	         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"))).click();

		WebElement selectBusinessU2 = driver.findElement(element2);
		js.executeScript("arguments[0].scrollIntoView();", selectBusinessU2);

		wait.until(ExpectedConditions.elementToBeClickable(selectBusinessU2)).sendKeys(" Royal Bank of Scotland");

		Thread.sleep(6000);
	}
	
	
	

}
