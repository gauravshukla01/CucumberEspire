package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;
import dev.failsafe.internal.util.Durations;
import io.cucumber.messages.types.Duration;

public class EproLoginPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	private final By clkUsername = By.xpath("//input[@id='userName']");
	private final By clkPassword = By.xpath("//input[@id='password']");
	private final By clkSubmit = By.xpath("//button[@type='submit']");

	public EproLoginPage(WebDriver driver) {
		this.driver = driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		ba = new BaseAction(driver);
	}
	
 

	public void launchurl(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public void EnterUsernameAndPassword(String Username, String Password) {
         
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	  ba.retryMechanism(driver, submit);
	}



}
