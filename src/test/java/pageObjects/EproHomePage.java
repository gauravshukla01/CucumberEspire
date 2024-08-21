package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class EproHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	
	@FindBy(xpath = "//*[@id='sideNav']")
	private WebElement sideNAV;
	@FindBy(xpath = "//*[text()=' Workflow ']")
	private WebElement workflow;
	@FindBy(xpath = "//a[normalize-space()='Campaigns']")
	private WebElement clkCampaign;
	
	
	
	public WebElement getsideNAV() {
		return sideNAV;
	}

	public WebElement getworkflow() {
		return workflow;
	}

	public WebElement getclkCampaign() {
		return clkCampaign;
	}
	
	
	public EproHomePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
		 PageFactory.initElements(driver, this);
	}

	public void ClkCampaign() throws InterruptedException {

		// step to click on campaign icon
				// *[text()=' Campaigns']
				// action class and move to element
				Actions action = new Actions(driver);
				
				
				
				
				// webelement for side nav
				Thread.sleep(3000);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
				
				ba.retryMechanism(driver, getsideNAV());
				// WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
				// action.moveToElement(ele);
				// click on workflow icon
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
				
				ba.retryMechanism(driver, getworkflow());

			   
				
			/*	while(clkCampaign.isDisplayed() != true) {
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
				}
			*/
			   // click on campaign icon
			 //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
				
			   ba.retryMechanism(driver, getclkCampaign());
	}


}
