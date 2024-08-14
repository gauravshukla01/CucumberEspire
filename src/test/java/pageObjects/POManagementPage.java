package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class POManagementPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public int rowNum;
	

	private final By element5 = By.xpath("//img[@src='assets/images/assign-suppliers.svg']");
	private final By element = By.xpath("//div[@id='mat-select-value-13']");

	public POManagementPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
	}
	
	public void goToFinance () throws InterruptedException {
		 // click on supporting docs link
		   String pdfName = null;
		   String[] act;
		
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//*[@id='mat-tab-label-2-2']")));
	       
	       // get the pdf PO name from table
     
	       for (int i = 0; i < 3; i++) {
	    	   try {
	    		   pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr","Purchase Order" , 2,"getText");// hard coded value
	    		   
	    		   break;}
	    	   catch (StaleElementReferenceException e) {
	    		   e.printStackTrace();
	    	   }

	    	    } // end of for loop
	       act = pdfName.split("_");
	       System.out.println("split pdf name = "+act[0]);
	       //ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
	      
	
	
	
		 //hover to select finance
	       
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
	     //  ba.retryMechanism(driver, driver.findElement(By.xpath("//*[@id='sideNav']")));
	       //click on finance
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Finance ']"))).click();
	     //  ba.retryMechanism(driver, driver.findElement(By.xpath("//span[text()=' Finance ']")));
	       //click on PO Management
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' PO Management']"))).click();
	     //  ba.retryMechanism(driver, driver.findElement(By.xpath("//a[text()=' PO Management']")));

	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']")))
					.sendKeys(act[0]);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();

			
	       for (int i = 0; i < 3; i++) {
	    	   try {
	    		  ba.handleWebTable("//*[@role='table']/tbody/tr", act[0], 1, "clickItem" ); // hard coded value
	    		  break;}
	    	   catch (StaleElementReferenceException e) {
	    		   e.printStackTrace();
	    	   }

	    	    } // end of for loop
	}   
	
	public void uploadPOD () throws InterruptedException {
	       // code to be analysed ///////////////////////////////////////////////////////////////////////////////
	       
	       int rowNum1 = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "UT01667-001", 2, "getRowNum");
	       System.out.println("rownum 2 in PO section ="+rowNum1);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='table']/tbody/tr["+rowNum1+"]/td/button//img[@src='assets/images/attach_user_guide.svg']"))).click();
	       Thread.sleep(3000);
	       // select the file to be uploaded send keys to below weblement
	     //*[@id='supportingDocumentFileUpload']
	       driver.findElement(By.xpath("//*[@id='supportingDocumentFileUpload']")).sendKeys("C:\\Users\\rahul\\Downloads\\ePO000895-LEADGB_V1.pdf");
	       // enter comments inthe text area
	     //*[@id='supportingDocumentDescription']
	       driver.findElement(By.xpath("//*[@id='supportingDocumentDescription']")).sendKeys("Coments");
	       ba.retryMechanism(driver, driver.findElement(By.xpath("(//*[@role='combobox'])[2]")));
	       
	     
	       // select pod option
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//span[text()=' Proof Of Delivery']")));
	       
	       // click the save button
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//button[@type='submit']")));
	    
	}
	
	public void validateReciept () throws InterruptedException {
	       // click on Receipt tab
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//*[@class='mat-tab-header']//div[text()='Receipt']")));
	       
	       // select the checkbox on receipt tab
	       ba.handleWebTable("//*[@role='table']/tbody/tr", "UT01667-001", 2, "clickItem");  // hard coded value
	       
	       // click the receipt action
	       ba.handleWebTable("//*[@role='table']/tbody/tr", "UT01667-001", 14, "clickItem");  // hard coded value
	       
	       // click on Close button on the popup
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//button/span[text()='Close']")));
	      
	       
	             //get data from table

	       //Scenario -2 completed
	      
	  }
	}


