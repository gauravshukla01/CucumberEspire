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
	}

	public void ClkCampaign() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		// Actions actions = new Actions(driver);

		// Click on sidBar
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click(); // Adjust the
		// locator as // needed
		// WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//		       action.moveToElement(ele);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
		//Thread.sleep(3000);

		// Click on campaign button

		WebElement campaignButton = driver.findElement(element4);
		js.executeScript("arguments[0].scrollIntoView();", campaignButton);

		wait.until(ExpectedConditions.elementToBeClickable(element4)).click();

		Thread.sleep(4000);

	}

}
