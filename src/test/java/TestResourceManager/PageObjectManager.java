package TestResourceManager;

import org.openqa.selenium.WebDriver;
import pageObjects.amazon.AmazonHomePage;
import pageObjects.amazon.DemoQaLoginPg;


public class PageObjectManager {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    DemoQaLoginPg demoQaLoginPg;

    public PageObjectManager(WebDriver webDriver) {
        driver = webDriver;
    }

    public AmazonHomePage getAmazonHomePage(){

        return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;

    }

    public DemoQaLoginPg getDemoQaLoginPg(){

        return (demoQaLoginPg==null) ? demoQaLoginPg=new DemoQaLoginPg(driver) : demoQaLoginPg;

    }
}
