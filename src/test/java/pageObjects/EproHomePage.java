package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class EproHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	private final By element4 = By
			.xpath("//*[@class='sideNavDropDown ng-star-inserted']//a[normalize-space()='Campaigns'][1]");

	public EproHomePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
	}

	public void ClkCampaign() throws InterruptedException {

		// step to click on campaign icon
				// *[text()=' Campaigns']
				// action class and move to element
				Actions action = new Actions(driver);
				
				
				
				
				// webelement for side nav
				Thread.sleep(3000);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
				WebElement sideNAV = driver.findElement(By.xpath("//*[@id='sideNav']"));
				ba.retryMechanism(driver, sideNAV);
				// WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
				// action.moveToElement(ele);
				// click on workflow icon
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
				 WebElement workflow = driver.findElement(By.xpath("//*[text()=' Workflow ']"));
				ba.retryMechanism(driver, workflow);

			   
				
			/*	while(clkCampaign.isDisplayed() != true) {
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
				}
			*/
			   // click on campaign icon
			 //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
				WebElement clkCampaign = driver.findElement(By.xpath("//a[normalize-space()='Campaigns']"));
			   ba.retryMechanism(driver, clkCampaign);
	}


}
