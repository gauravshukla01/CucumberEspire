//package pageObjects;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class DemoQATextBoxPage {
//
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public JavascriptExecutor js;
//
//	public final By elementsButton = By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]");
//	public final By textBoxButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
//	public final By fullName = By.xpath("//input[@id='userName']");
//	public final By emailField = By.xpath("//input[@id='userEmail']");
//	public final By currentAdd = By.xpath("//textarea[@id='currentAddress']");
//	public final By permanentAdd = By.xpath("//textarea[@id='permanentAddress']");
//	public final By submitButton = By.xpath("//button[@id='submit']");
//
//	public DemoQATextBoxPage(WebDriver driver)
//	{
//		this.driver = driver;
//		
//		PageFactory.initElements(driver, this); // need to work on 1st august
//	}
//
//	public void openDemoQATextBoxPage(String url){
//		driver.get(url);
//	}
//
//	public void clickOnElementButton()
//	{
//		js = (JavascriptExecutor) driver;
//
//		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(elementsButton));
//
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(elementsButton)));
//
//		driver.findElement(elementsButton).click();
//		
//		
//	}
//
//	public void clickonTextBoxButton()
//	{
//		js = (JavascriptExecutor) driver;
//
//		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(textBoxButton));
//
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(textBoxButton)));
//
//		driver.findElement(textBoxButton).click();
//	}
//
//	public void enterFullNameField(String FULLNAME)
//	{
//		js = (JavascriptExecutor) driver;
//
//		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(fullName));
//
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fullName)));
//
//		driver.findElement(fullName).sendKeys(FULLNAME);
//	}
//
//	public void enterEmailAddress(String EMAILADDRESS) 
//	{
//		driver.findElement(emailField).sendKeys(EMAILADDRESS);
//	}
//
//	public void enterCurrentAdd(String CURRENTADD)
//	{
//		driver.findElement(currentAdd).sendKeys(CURRENTADD);
//	}
//
//	public void enterPermanentAdd(String PRMANENTADD)
//	{
//		driver.findElement(permanentAdd).sendKeys(PRMANENTADD);
//	}
//
//	public void clickonSubmitButton()
//	{
//		js = (JavascriptExecutor) driver;
//
//		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(submitButton));
//
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButton)));
//
//		driver.findElement(submitButton).click();
//	}
//
//}
