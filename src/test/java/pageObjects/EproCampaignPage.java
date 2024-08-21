package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class EproCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public int rowNum;


	@FindBy(xpath = "//img[@src='assets/images/assign-suppliers.svg']") 
	private WebElement addIconButton;
	@FindBy(xpath = "//input[@placeholder='Search..']") 
	private WebElement clearSearch;
	@FindBy(xpath = "//*[@role='table']/tbody/tr") 
	private WebElement baseTable;
	
	
	
	
	public WebElement getaddIconButton() {
		return addIconButton;
	}
	
	public WebElement getclearSearch() {
		return clearSearch;
	}
	
	public WebElement getManageCAmp(String num) {
		return driver.findElement(By.xpath("//*[text()='" + num + "']"));
	}
	
	public WebElement getbaseTable() {
		return baseTable;
	}
	
	
	
	
	public EproCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
		 PageFactory.initElements(driver, this);
	}

	public void clkAddCampaign() {


		
		 // click on add icon
       wait.until(ExpectedConditions.elementToBeClickable(getaddIconButton())).click();
       // click on business unit box //div[@id='mat-select-value-13']

		
		
}
	
	
	public void clickOnCampaignId(String num) {
		
		// click on the search icon to get the context on the base page

		// String UTnumber = "UT01183";
		//String UTnumber = num;
		
		wait.until(ExpectedConditions.elementToBeClickable(getclearSearch())).clear();

		wait.until(ExpectedConditions.elementToBeClickable(getclearSearch()))
				.sendKeys(num);

		wait.until(ExpectedConditions.elementToBeClickable(getclearSearch())).click();

		
		ba.retryMechanism(driver, getManageCAmp(num));

		// click on Manage campaign
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click();

	}
	//*[@role='table']/tbody/tr
	
	public void clickOnSendPO() throws InterruptedException {
		 // click on send po button
	     
	       String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getText");
	       System.out.println("campaign_ID = "+campaign_ID);
	       rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getRowNum");
	       System.out.println("rowNum  = "+rowNum);
	      //*[@role='table']/tbody/tr[5]/td[11]/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']"))); 
			

	       ba.retryMechanism(driver, driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),' Yes')]")));
	       
	}
	
	public void clickOnCreatePO () {
		// click on create PO
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//table[@role='table']//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/generate_doc_create_po.svg']"))); // hard coded value
	       //click on close (popup)
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Close']")));
	       
	}
	
	
	
	
}