package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class SalesOrderPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public String campaign_ID = null;
	

//	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
//	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public SalesOrderPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
	}

	public void goToCampaingPg() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
	      //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//	    action.moveToElement(ele);
	      // click on workflow icon
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
	      
	      // click on campaign icon
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
	 //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();	
	}
	
	public void clickOnCampId(String num) {
		 // click on the search icon to get the context on the base page
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).sendKeys(num);
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
	      
	      // click on the specific campaign -- //*[text()='UT01108']
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + num + "']"))).click(); // hard coded value
	      
	}
	public String getCampIdPOReciept (String status) throws InterruptedException { 
	      //validating status as PO receipted   
	      campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status , 2, "getText");
	      System.out.println("campaign_ID = "+campaign_ID);
	      
	      return campaign_ID;		
	}

	
	
	public void goToSaleOrderPg() {
		//navigating to Finance
	      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
	       //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//	     action.moveToElement(ele);
	       // click on workflow icon
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Finance ']"))).click();
	       
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Orders']"))).click();
	}
	
	public void createDraftInvoice() throws InterruptedException {
		  // click on check box 
	
		      for (int i = 0; i < 3; i++) {
		    	   try {
		    		   ba.handleWebTable("//*[@role='table']/tbody/tr", campaign_ID.trim(), 2, "clickItem");  // hard coded value
		    		  break;}
		    	   catch (StaleElementReferenceException e) {
		    		   e.printStackTrace();
		    	   }

		    	    } // end of for loop
		       
		      
		       // click on create draft invoice
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Create Draft Invoice']"))); // hard coded value
		     
		     ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()=' Create Draft Invoice']")));
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		      
		      // click on ok in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()=' OK ']")));
		      ba.retryMechanism(driver, driver.findElement(By.xpath("//button/span[text()=' OK ']")));
		    
		      // click on close in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Close']")));
		      ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Close']")));
		}
	
	
	}

