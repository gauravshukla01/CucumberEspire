package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class SalesInvoicePage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	
	

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
	     String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status , 2, "getText");
	      System.out.println("campaign_ID = "+campaign_ID);
	      
	      return campaign_ID;		
	}
	
	 public String getPDFPOname () throws InterruptedException {
		  // click on supporting docs link
	     ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Supporting Documents']")));
	    	
	     // get the pdf PO name from table
	    
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
	    String[] act = pdfName.split("_");
	     System.out.println("split pdf name = "+act[0]);
	     return act[0];
	     
	 }
	 
	public void goToSaleInvoicePg() {
		//navigating to Finance
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/img[@src='assets/images/finance-module.svg']"))).click();
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Invoices']"))).click();
	       //clear search
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
	}

	public void clickOnInvoiceNo(String pdfname) throws InterruptedException {
		   //click on invoice number
	      for (int i = 0; i < 3; i++) {
	   	   try {
	   		  ba.handleWebTable("//*[@role='table']/tbody/tr", pdfname, 2, "clickItem" ); // hard coded value
	   		  break;}
	   	   catch (StaleElementReferenceException e) {
	   		   e.printStackTrace();
	   	   }

	   	} // end of for loop
	     
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public void clickOnCheckboxs(String indexId) throws InterruptedException {
		//scroll to element
		WebElement lastele = driver.findElement(By.xpath("//*[text()='Check Proof of Delivery or Postal Docket ']"));
		js.executeScript("arguments[0].scrollIntoView(true);", lastele);
		
		// click on check box next to campaig id 
	      
	      for (int i = 0; i < 3; i++) {
	   	   try {
	   		   ba.handleWebTable("//*[@role='table']/tbody/tr", indexId.trim(), 2, "clickItem");  
	   		 
	   		   break;}
	   	   catch (StaleElementReferenceException e) {
	   		   e.printStackTrace();
	   	   }

	   	    } 
	      
	      // click on the check list check boxes
	     
	      ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Check Client PO or Acceptance of Quote ']")));
	      ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Check Proof of Delivery or Postal Docket ']")));
	      
	      
	}
	}

