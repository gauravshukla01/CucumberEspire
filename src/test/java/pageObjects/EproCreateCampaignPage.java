package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;
import otherResources.TestContext;

public class EproCreateCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	TestContext testContext;

	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public EproCreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		
	}

	public void fillRequiredDetails() throws InterruptedException {


		// retry mechanism implementation
		WebElement element = driver.findElement(By.xpath("//*[@id='BusinessUnitId']"));
		ba.retryMechanism(driver,element);
		WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
		ba.retryMechanism(driver,element1);



		WebElement customertxtBox = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-28 ng-star-inserted']"));
		ba.retryMechanism(driver,customertxtBox);
		WebElement stagingClient_1 = driver.findElement(By.xpath("//*[text()=' StagingClient_1 ']"));
		ba.retryMechanism(driver, stagingClient_1);


		WebElement customer_entities = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-30 ng-star-inserted']"));
		ba.retryMechanism(driver,customer_entities);
		WebElement AdminClient = driver.findElement(By.xpath("//span[normalize-space()='AdminClient 1 - GBP']"));
		ba.retryMechanism(driver,AdminClient);

		/*
		 * WebElement Account_Manager =
		 * driver.findElement(By.xpath("//*[@id='title']"));
		 * ba.retryMechanism(driver,Account_Manager);
		 */        
		/*
		 * WebElement Staging_user =
		 * driver.findElement(By.xpath("//span[normalize-space()='Staging User3']"));
		 * ba.retryMechanism(driver,Staging_user);
		 */


		WebElement Campaign_title = driver.findElement(By.xpath("//input[@id='title']"));
		ba.retryMechanismWithSendKeys(driver, Campaign_title, "Test_3");

		WebElement customer_camping_ref = driver.findElement(By.xpath("//input[@id='reference']"));
		ba.retryMechanismWithSendKeys(driver, customer_camping_ref, "CR124324332");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement date = driver.findElement(By.xpath("//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']"));
		ba.retryMechanism(driver,date);
		WebElement Value_31 = driver.findElement(By.xpath("//*[contains(@aria-label,'August 31, 2024')]"));
		ba.retryMechanism(driver,Value_31);



		/*   WebElement sales_representative = driver.findElement(By.xpath("//div[@id='mat-select-value-23']"));
        retryMechanism(driver,sales_representative);
        WebElement David_Reynolds = driver.findElement(By.xpath("//span[normalize-space()='David Reynolds']"));
        retryMechanism(driver,David_Reynolds);
		 */

		WebElement VAT = driver.findElement(By.xpath("//div[@id='mat-select-value-27']"));
		js.executeScript("arguments[0].scrollIntoView();", VAT);
		ba.retryMechanism(driver,VAT);
		WebElement vat20 = driver.findElement(By.xpath("//span[normalize-space()='VAT20']"));
		ba.retryMechanism(driver,vat20);


		WebElement purchase_order_number = driver.findElement(By.xpath("//input[@id='ponumber']"));
		js.executeScript("arguments[0].scrollIntoView();", purchase_order_number);
		ba.retryMechanismWithSendKeys(driver, purchase_order_number, "PO12421331");

		WebElement purchase_order_value = driver.findElement(By.xpath("//input[@id='povalue']"));
		js.executeScript("arguments[0].scrollIntoView();", purchase_order_value);
		ba.retryMechanismWithSendKeys(driver, purchase_order_value, "2");


		/*  WebElement cost_centre = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-51 ng-star-inserted']"));
        ba.retryMechanism(driver,cost_centre);
        WebElement regionalmarketing = driver.findElement(By.xpath("//span[contains(text(),'MFE - DM – Regional Marketing')]"));
        ba.retryMechanism(driver,regionalmarketing);
		 */

	}

	public String submitCreateCampaignDetails() throws InterruptedException {

		WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", SUBMIT);
		ba.retryMechanism(driver,SUBMIT);
		
		try {	WebElement  clearSearch = driver.findElement(By.xpath("//div[@class='input-group-append']"));
		ba.retryMechanism(driver, clearSearch);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		 String campaign_Number = ba.handleWebTable("//*[@role='table']/tbody/tr", "Created", 1, "getText");
	        
	        
	        //add this to hashmap
		 
		 
	        System.out.println("Campaign number = "+campaign_Number);
	        
  return campaign_Number;
	}




}
