package TestResourceManager;

import org.openqa.selenium.WebDriver;

import pageObjects.AmazonHomePage;
import pageObjects.DemoQATextBoxPage;
import pageObjects.EproCampaignPage;
import pageObjects.EproCreateCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;
import pageObjects.ZohoSignInPage;

public class PageObjectManager {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    ZohoSignInPage zohoSignPage;
    DemoQATextBoxPage textBoxPage;
    EproLoginPage eprologin;
    EproHomePage eprohome;
    EproCampaignPage eprocamp;
    EproCreateCampaignPage eprocreatecamp;

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
    public EproLoginPage getEproLoginPage(){

        return (eprologin==null) ? eprologin=new EproLoginPage(driver) : eprologin;

    } 
    
    public EproHomePage getEproHomePage(){

        return (eprohome==null) ? eprohome=new EproHomePage(driver) : eprohome;

    } 
    public EproCampaignPage getEproCampaignPage(){

        return (eprocamp==null) ? eprocamp=new EproCampaignPage(driver) : eprocamp;

    } 
    
    public EproCreateCampaignPage getEproCreateCampaignPage(){

        return (eprocreatecamp==null) ? eprocreatecamp =new EproCreateCampaignPage(driver) : eprocreatecamp;

    } 
    
    
    
    
    
}
