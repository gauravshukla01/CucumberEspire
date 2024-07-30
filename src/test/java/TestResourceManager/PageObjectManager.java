package TestResourceManager;

import org.openqa.selenium.WebDriver;
import pageObjects.amazon.AmazonHomePage;
import pageObjects.amazon.DQTextBox;
import pageObjects.amazon.DemoQaLoginPg;


public class PageObjectManager {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    DemoQaLoginPg demoQaLoginPg;
    DQTextBox dqTextBox;

    public PageObjectManager(WebDriver webDriver) {
        driver = webDriver;
    }

    public AmazonHomePage getAmazonHomePage(){

        return (amazonHomePage==null) ? amazonHomePage=new AmazonHomePage(driver) : amazonHomePage;

    }

    public DemoQaLoginPg getDemoQaLoginPg(){

        return (demoQaLoginPg==null) ? demoQaLoginPg=new DemoQaLoginPg(driver) : demoQaLoginPg;

    }
    
    public DQTextBox getdqTextBox(){

        return (dqTextBox==null) ? dqTextBox=new DQTextBox(driver) : dqTextBox;

    }
    
}
