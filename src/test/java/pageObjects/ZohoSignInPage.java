package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoSignInPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
    public final By emailId = By.xpath("//*[@id='login_id']");
    public final By nextButton = By.xpath("//*[@id='nextbtn']");
    public final By passWord = By.xpath("//*[@id='password']");
    public final By signInButton = By.xpath("//*[@id='nextbtn']");

    public ZohoSignInPage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void openZohoSignInPage(String url){
        driver.get(url);
    }
    
    public void enterEmailId(String EMAIL){

    	wait = new WebDriverWait(driver,Duration.ofSeconds(20));

    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailId)));

    	driver.findElement(emailId).sendKeys(EMAIL);
    }
    
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    
    public void enterPassword(String PASSWORD){
        driver.findElement(passWord).sendKeys(PASSWORD);
    }
    
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}
