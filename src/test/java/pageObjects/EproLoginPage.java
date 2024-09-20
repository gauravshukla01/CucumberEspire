package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import CommmonUtils.BaseClass;

public class EproLoginPage extends BaseClass {

	private WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	private static final Logger logger = LogManager.getLogger(EproLoginPage.class);

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement textBoxUserName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement textBoxPassword;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSubmit;

	public EproLoginPage(WebDriver webdriver) {
		this.driver=webdriver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void LoginIntoApplication(String Username, String Password) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(textBoxUserName));
		textBoxUserName.sendKeys(Username);
		textBoxPassword.sendKeys(Password);
		Thread.sleep(3000);
		//clickOnElement(driver,buttonSubmit);

	}

	public void HandleCaptcha() throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();

	}

}
