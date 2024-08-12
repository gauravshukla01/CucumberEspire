package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EproHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	private final By element4 = By
			.xpath("//*[@class='sideNavDropDown ng-star-inserted']//a[normalize-space()='Campaigns'][1]");

	public EproHomePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
	}

	public void ClkCampaign() throws InterruptedException {

		// step to click on campaign icon
				// *[text()=' Campaigns']
				// action class and move to element
				Actions action = new Actions(driver);
				
				
				
				
				// webelement for side nav
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
				// WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
				// action.moveToElement(ele);
				// click on workflow icon
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();

				WebElement campRetry = driver.findElement(By.xpath("//a[normalize-space()='Campaigns']"));
				
				while(campRetry.isDisplayed() != true) {
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
				}
			
			   // click on campaign icon
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();

	}

}
