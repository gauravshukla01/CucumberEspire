package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import commonUtils.BaseClass;

public class LoginPage {

	public WebDriver driver;
	
	BaseClass baseClass;


    @FindBy(xpath="//input[@placeholder='Email']")
    private WebElement textBoxUserName;
    
    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement textBoxPassword;
    
    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    private WebElement buttonLogin;

	public LoginPage(WebDriver webdriver)
	{
		this.driver = webdriver;
		
		baseClass = new BaseClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToApplication(String appUrl) {
		driver.get(appUrl);
	}
	
	public String getPageTitle() {
				
		baseClass.waitInSec(2);
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public void enterCredentialsAndLoginIntoApplication(String userName,String password) {

		baseClass.sendKeys(driver, textBoxUserName, userName);
		baseClass.waitInSec(1);
		baseClass.sendKeys(driver, textBoxPassword, password);
		baseClass.waitInSec(1);
		baseClass.clickOnElement(driver, buttonLogin);
		baseClass.waitInSec(2);
		
	}
	
	public boolean isUserNameTextBoxDisplayed() {
		
		baseClass.waitVisibilityOfElement(textBoxUserName);
		
		return baseClass.isElementPresent(textBoxUserName);
	}

}



