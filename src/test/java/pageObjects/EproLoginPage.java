package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;

import CommmonUtils.BaseAction;
import CommmonUtils.ExtentConfiguration;

public class EproLoginPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement clkUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement clkPassword;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clkSubmit;

	
	
	public EproLoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		ba = new BaseAction(driver);
	}

	
	
	public WebElement getClkUsername() {
		return clkUsername;
	}

	public WebElement getclkPassword() {
		return clkPassword;
	}

	public WebElement getclkSubmit() {
		return clkSubmit;
	}

	
	
	
	
	public void launchurl(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}
	
	

	public void EnterUsernameAndPassword(String Username, String Password) {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getClkUsername().sendKeys(Username);
		getclkPassword().sendKeys(Password);

	}
	
	

	public void HandleCaptcha() throws InterruptedException {

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}
	
	

	public void Clksubmit() {

		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.PASS);
		ba.retryMechanism(driver, getclkSubmit());
	}
	
	

}