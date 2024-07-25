package TestResourceManager;

import org.openqa.selenium.WebDriver;
import pageObjects.amazon.AmazonHomePage;

public class PageObjectManager {

    WebDriver driver;
    AmazonHomePage amazonHomePage;

    public PageObjectManager(WebDriver webDriver) {
        driver = webDriver;
    }

    public AmazonHomePage getAmazonHomePage(){

        return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;

    }

}
