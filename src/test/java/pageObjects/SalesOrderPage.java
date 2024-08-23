package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class SalesOrderPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	

	public SalesOrderPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
	}

	public void goToCampaingPg() {
		
	      // click on workflow icon
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/img[@src='assets/images/workflow.svg']"))).click();
	      
	      // click on campaign icon
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
	      
	      //clear search
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
	 
	}
	
	public void searchItem(String status) {
		 // click on the search icon to get the context on the base page
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).sendKeys(status);
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
	      
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + status + "']"))).click(); 
	      
	}
	
	public String getCampIdPOReciept (String status) throws InterruptedException { 
	      
	     String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status , 1, "getText");
	     System.out.println("campaign_ID = "+campaign_ID); 
	      return campaign_ID;		
	}
 
	public void clickOnCampID(String cmpId, int td) throws InterruptedException {
       
		 for (int i = 0; i < 3; i++) {
	    	   try {
	    		   
	    			ba.handleWebTable("//*[@role='table']/tbody/tr", cmpId , td, "clickItem");
	    		  break;}
	    	   catch (StaleElementReferenceException e) {
	    		   e.printStackTrace();
	    	   }

	    	    } // end of for loop
		
		
	}
	
	public String getIndexCampId (String status) throws InterruptedException { 
	      //validating status as PO receipted   
	     String indexId = ba.handleWebTable("//*[@role='table']/tbody/tr", status , 2, "getText");
	      System.out.println("campaign_Index_ID = "+indexId);
	      
	      return indexId;		
	}
	
	public void goToSaleOrderPg() throws InterruptedException {
		//navigating to Finance
	
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/*[@src='assets/images/finance-module.svg']"))).click();
	       
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Orders']"))).click();
	       //clear search
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
		    
	       
	}
	
	public void createDraftInvoice(String campId) throws InterruptedException {
			
		//enter PO number  
		      
				WebElement poNoBox = driver.findElement(By.xpath("//*[@role='table']/tbody/tr//div/input"));
				wait.until(ExpectedConditions.elementToBeClickable(poNoBox)).clear();
				ba.retryMechanismWithSendKeys(driver, poNoBox, "PO1010101");
				
		// click on check box 
		
	      for (int i = 0; i < 3; i++) {
	    	   try {
	    		   ba.handleWebTable("//*[@role='table']/tbody/tr", campId.trim(), 2, "clickItem");  // hard coded value
	    		  break;}
	    	   catch (StaleElementReferenceException e) {
	    		   e.printStackTrace();
	    	   }

	    	    } // end of for loop
	      
		       // click on create draft invoice
		    //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Create Draft Invoice']"))); // hard coded value
		     
		     ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()=' Create Draft Invoice']")));
		     		      
		      // click on ok in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()=' OK ']")));
		      ba.retryMechanism(driver, driver.findElement(By.xpath("//button/span[text()=' OK ']")));
		    
		      // click on close in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Close']")));
		      ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Close']")));
		}
	
	
	}

