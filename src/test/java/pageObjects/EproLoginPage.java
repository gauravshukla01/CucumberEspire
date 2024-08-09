package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;
import io.cucumber.messages.types.Duration;

public class EproLoginPage {

	public WebDriver driver;
	public WebDriver wait;
	public JavascriptExecutor js;

	private final By clkUsername = By.xpath("//input[@id='userName']");
	private final By clkPassword = By.xpath("//input[@id='password']");
	private final By clkSubmit = By.xpath("//button[@type='submit']");

	public EproLoginPage(WebDriver driver) {
		this.driver = driver;

		this.js = (JavascriptExecutor) driver;
	}

	public void launchurl(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public void EnterUsernameAndPassword(String Username, String Password) {

		driver.findElement(clkUsername).sendKeys(Username);
		driver.findElement(clkPassword).sendKeys(Password);

	}

	public void HandleCaptcha() throws InterruptedException {

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	@SuppressWarnings("deprecation")
	public void Clksubmit() {
		((FluentWait<WebDriver>) wait).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
		//Thread.sleep(1000);
	//	driver.findElement(clkSubmit).click();
	}

	public void ClkCampaign() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		Actions actions = new Actions(driver);

		// Click on sidBar
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click(); // Adjust the
																										// locator as
																										// needed
		//WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//	       action.moveToElement(ele);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
		Thread.sleep(1000);

		// Click on campaign button
		WebElement element4 = driver.findElement(
				By.xpath("//*[@class='sideNavDropDown ng-star-inserted']//a[normalize-space()='Campaigns'][1]"));

		js.executeScript("arguments[0].scrollIntoView();", element4);

		wait.until(ExpectedConditions.elementToBeClickable(element4)).click();

		Thread.sleep(80000);

	}

}
