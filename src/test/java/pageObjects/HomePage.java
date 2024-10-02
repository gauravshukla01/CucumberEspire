package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.BaseClass;

public class HomePage extends BaseClass {
	
	public static WebDriver driver;
	
	public HomePage(WebDriver webdriver)
	{
        HomePage.driver = webdriver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='user-display']")
	private WebElement textUserName;
	
	@FindBy(xpath="//div/i[@class='settings icon']")
	private WebElement iconSetting;
	
	@FindBy(xpath="//i[@class='power icon']")
	private WebElement iconLogOut;
	
	public String getUserName() {
		
		waitVisibilityOfElement(textUserName);
		String userName = textUserName.getText().trim();
		return userName;
		
	}
	
	public void logOutFromApplication() {
		clickOnElement(driver, iconSetting);
		waitInSec(1);
		clickOnElement(driver, iconLogOut);
		waitInSec(2);
	}

}
