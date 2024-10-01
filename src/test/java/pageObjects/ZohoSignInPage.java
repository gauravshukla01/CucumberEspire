package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class ZohoSignInPage{
	
	public WebDriver driver;
	public WebDriverWait wait;
	BaseAction ba; 
	
    public final By emailId = By.xpath("//*[@id='login_id']");
    public final By nextButton = By.xpath("//*[@id='nextbtn']");
    public final By passWord = By.xpath("//*[@id='password']");
    public final By signInButton = By.xpath("//*[@id='nextbtn']");

    public ZohoSignInPage(WebDriver driver)
    {
    	this.driver = driver;
    	ba=  new BaseAction (driver);
    }
    
    public void openZohoSignInPage(String url){
        driver.get(url);
    }
    
    public void enterEmailId(String EMAIL){

    	wait = new WebDriverWait(driver,Duration.ofSeconds(20));

    //	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailId)));
    	
 WebElement emailid = driver.findElement(By.xpath("//*[@id='login_id']"));
    	//driver.findElement(emailId).sendKeys(EMAIL);
    	ba.retryMechanismWithSendKeys(driver, emailid, EMAIL);
    }
    
    public void clickNextButton(){
    	WebElement NextButton = driver.findElement(By.xpath("//*[@id='nextbtn']"));
        ba.retryMechanism(driver, NextButton);
    }
    
    public void enterPassword(String PASSWORD){
      //  driver.findElement(passWord).sendKeys(PASSWORD);
        
        WebElement EnterPass = driver.findElement(By.xpath("//*[@id='password']"));
        ba.retryMechanismWithSendKeys(driver, EnterPass, PASSWORD);
    }
    
    public void clickSignInButton(){
        //driver.findElement(signInButton).click();
    	WebElement SignInButton = driver.findElement(By.xpath("//*[@id='nextbtn']"));
        ba.retryMechanism(driver, SignInButton);
    }
}
