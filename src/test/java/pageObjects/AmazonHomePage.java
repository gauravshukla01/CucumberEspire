package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the Amazon Home Page and provides methods to interact with the login elements.
 */
public class AmazonHomePage {

    // WebDriver instance to interact with the web page
    WebDriver driver;

    // Locators for the login elements on the Amazon Home Page
    public final By lnkLogin = By.xpath("//*[@id='nav-link-accountList-nav-line-1']");
    public final By txtBoxUserName = By.xpath("//*[@id='ap_email_login']");
    public final By btnContinue = By.xpath("//*[@id='continue']/span/input");
    public final By txtBoxPassword = By.xpath("//*[@id='ap_password']");
    public final By btnSignIn = By.xpath("//*[@id='signInSubmit']");

    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param webDriver the WebDriver instance to interact with the web page
     */
    public AmazonHomePage(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void openAmazonHomePage(String URL){
        driver.get(URL);
    }

    /**
     * Opens the login page by clicking the login link.
     */
    public void openLoginPage(){
        driver.findElement(lnkLogin).click();
    }

    /**
     * Enters the username in the username text box.
     *
     * @param userName the username to be entered
     */
    public void enterUserName(String userName){
        driver.findElement(txtBoxUserName).sendKeys(userName);
    }

    /**
     * Clicks the continue button to proceed to the password entry page.
     */
    public void clickContinue(){
        driver.findElement(btnContinue).click();
    }

    /**
     * Enters the password in the password text box.
     *
     * @param pwd the password to be entered
     */
    public void enterPassword(String pwd){
        driver.findElement(txtBoxPassword).sendKeys(pwd);
    }

    /**
     * Clicks the sign-in button to attempt to log in.
     */
    public void clickSignIn(){
        driver.findElement(btnSignIn).click();
    }
}
