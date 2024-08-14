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

public class SalesInvoicePage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public String[] act = null;
	public String campaign_ID = null;
	

//	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
//	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public SalesInvoicePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
	
	}
	
	public String getCampIdDraftInvoiced (String status) throws InterruptedException { 
	      //validating status as PO receipted   
	      campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status , 2, "getText");
	      System.out.println("campaign_ID = "+campaign_ID);
	      
	      return campaign_ID;		
	}
	
	 public void getPDFPOname () throws InterruptedException {
		  // click on supporting docs link
	     ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Supporting Documents']")));
	    	
	     // get the pdf PO name from table
	     Thread.sleep(3000);
	     String pdfName = null;
	     for (int i = 0; i < 3; i++) {
	    	 try {
	    		  pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr","Draft Invoice" , 2,"getText");
	    		 break;
	    	 }
	    	  catch (StaleElementReferenceException e) {
	      		   e.printStackTrace();
	      	   }
	     }// end of for loop
	    
	     //ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
	     act = pdfName.split("_");
	     System.out.println("split pdf name = "+act[0]);
	     
	 }
	 
	public void goToSaleInvoicePg() {
		//navigating to Finance
	      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
	       //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//	     action.moveToElement(ele);
	       // click on workflow icon
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Finance ']"))).click();
	       
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Invoices']"))).click();
	}

	public void clickOnInvoiceNo() throws InterruptedException {
		   //click on invoice number
	      for (int i = 0; i < 3; i++) {
	   	   try {
	   		  ba.handleWebTable("//*[@role='table']/tbody/tr", act[0], 2, "clickItem" ); // hard coded value
	   		  break;}
	   	   catch (StaleElementReferenceException e) {
	   		   e.printStackTrace();
	   	   }

	   	} // end of for loop
	     
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public void clickOnCheckboxs() throws InterruptedException {
		 // click on check box next to campaig id 
	      
	      for (int i = 0; i < 3; i++) {
	   	   try {
	   		   ba.handleWebTable("//*[@role='table']/tbody/tr", campaign_ID.trim(), 2, "clickItem");  // hard coded value
	   		 
	   		   break;}
	   	   catch (StaleElementReferenceException e) {
	   		   e.printStackTrace();
	   	   }

	   	    } //
	      
	      // click on the check list check boxes
	      //first check box //*[@id='mat-checkbox-23-input'] second check box: //*[@id='mat-checkbox-24-input'] //*[@id='buttonIsPost']
	      
	      ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Check Client PO or Acceptance of Quote ']")));
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Check Proof of Delivery or Postal Docket ']")));
	      
	      
	}
	}

