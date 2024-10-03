package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import commonUtils.BaseClass;

public class LoginPage extends BaseClass {

	public static WebDriver driver;


    @FindBy(xpath="//input[@placeholder='Email']")
    private WebElement textBoxUserName;
    
    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement textBoxPassword;
    
    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    private WebElement buttonLogin;

	public LoginPage(WebDriver webdriver)
	{
		LoginPage.driver = webdriver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
				
		waitInSec(2);
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public void enterCredentialsAndLoginIntoApplication(String userName,String password) {

		sendKeys(driver, textBoxUserName, userName);
		waitInSec(1);
		sendKeys(driver, textBoxPassword, password);
		waitInSec(1);
		clickOnElement(driver, buttonLogin);
		waitInSec(2);
		
	}
	
	public boolean isUserNameTextBoxDisplayed() {
		
		waitVisibilityOfElement(textBoxUserName);
		
		return isElementPresent(textBoxUserName);
	}

}



