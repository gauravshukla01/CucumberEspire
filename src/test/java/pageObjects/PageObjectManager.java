package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

   private static WebDriver driver;

   public LoginPage loginPage;
   public HomePage homePage;
   
   public PageObjectManager(WebDriver webDriver) {
	   
		this.driver = webDriver;
	}


	public LoginPage getFreeCRMLoginPage(){

		return (loginPage==null) ? loginPage=new LoginPage(driver) : loginPage;

	} 
	
	public HomePage getFreeCRMHomePage(){

		return (homePage==null) ? homePage=new HomePage(driver) : homePage;

	} 
}
