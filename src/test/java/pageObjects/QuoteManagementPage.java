package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class QuoteManagementPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
    
	
	@FindBy(xpath="//input[@placeholder='Search..']")
	private WebElement ClearSearch;
	@FindBy(xpath="//div[contains(text(),'Quote Management')]")
	private WebElement QuoteManagementTab;
	@FindBy(xpath="//*[@role='table']//tbody/tr")
	private WebElement qQuoteManagementTableEntries;
	@FindBy(xpath="//div[@class='table-grid']//span[@class='mat-radio-container']")
	private WebElement ClickRadioB;
	
	
	
	
	
	public WebElement getClearSearch() {
		return ClearSearch;
	}
	public WebElement getquote1(int j) {
		return driver
				.findElement(By.xpath("//*[@role='table']//tbody/tr[" + j + "]//a[@class='btn bg-orange']"));
	}
	
	public WebElement getClickRadioB() {
		return ClickRadioB;
	}
	
	public WebElement getQuoteManagementTab() {
		return QuoteManagementTab;
	}
	
	
	
	

	public QuoteManagementPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
	
	
	}

	
	public void verifyQuote() throws InterruptedException {
		
		
		
		// Click on Quote Management
				//WebElement quoteManagement = driver.findElement(By.xpath("//div[contains(text(),'Quote Management')]"));
			//	ba.retryMechanism(driver, quoteManagement);
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(getClearSearch())).clear();

				ba.retryMechanism(driver, wait.until(ExpectedConditions.elementToBeClickable(getQuoteManagementTab())));

				// click on 1st quote

				List<WebElement> quoteTableEntries = driver.findElements(By.xpath("//*[@role='table']//tbody/tr"));

				System.out.println("quote table rows ="+quoteTableEntries.size());
				int j = quoteTableEntries.size();
				
				// WebElement quote1 =
				// driver.findElement(By.xpath("//a[normalize-space()='"+UTnumber+"-Q-008']"));
				ba.retryMechanism(driver, getquote1(j));

				// click on radio button to select the quote and accept
				Thread.sleep(2000);
				WebElement ClickRadioB = driver.findElement(By.xpath("//div[@class='table-grid']//span[@class='mat-radio-container']"));
				js.executeScript("arguments[0].scrollIntoView();", ClickRadioB);
				ba.retryMechanism(driver, ClickRadioB);

				WebElement acceptQuote = driver.findElement(By.xpath("//button[normalize-space()='Accept Selected']"));
				ba.retryMechanism(driver, acceptQuote);

	}
	
	public void acceptQuote() {
		
		
		// click on final accept
				WebElement finalAccept = driver.findElement(By.xpath("//*[text()='Accept Quote']"));
				ba.retryMechanism(driver, finalAccept);

	}


	


	public void validateAcceptQuotePopup() {
		
		ba.validatePopUp("Campaign Quote has been modified successfully.", "Quote Accepted Popup validated successfully.");
	}
}
