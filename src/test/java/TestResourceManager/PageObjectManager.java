package TestResourceManager;

import org.openqa.selenium.WebDriver;

import pageObjects.AmazonHomePage;
import pageObjects.DemoQATextBoxPage;
import pageObjects.ZohoSignInPage;

public class PageObjectManager {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    ZohoSignInPage zohoSignPage;
    DemoQATextBoxPage textBoxPage;

    public PageObjectManager(WebDriver webDriver) {
        driver = webDriver;
    }

    public AmazonHomePage getAmazonHomePage(){

        return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;

    }

    public ZohoSignInPage getZohoSignInPage(){

        return (zohoSignPage==null) ? zohoSignPage=new ZohoSignInPage(driver) : zohoSignPage;

    }
    
    public DemoQATextBoxPage getDemoQaTextBoxPage(){

        return (textBoxPage==null) ? textBoxPage=new DemoQATextBoxPage(driver) : textBoxPage;

    } 
}
