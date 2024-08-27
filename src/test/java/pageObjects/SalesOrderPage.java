package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class SalesOrderPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public String campaign_ID = null;
	SalesInvoicePage salesinvoicepage;
	
	

	@FindBy(xpath=("//*[@id='sideNav']"))
	private WebElement sidenav;
	
	@FindBy(xpath=("//a/*[@src='assets/images/finance-module.svg']"))
	private WebElement finance;
	
	@FindBy(xpath="//a/img[@src='assets/images/workflow.svg']")
	private WebElement workflow;
	
	@FindBy(xpath="//a[normalize-space()='Campaigns']")
    private WebElement campaigns;
	
	@FindBy(xpath="//input[@placeholder='Search..']")
	private WebElement search;
	
	@FindBy(xpath=("//*[text()=' Sales Orders']"))
	private WebElement salesorder;
	
	@FindBy(xpath="//*[text()=' Create Draft Invoice']")
	private WebElement DraftInvoiceButton;
	
	@FindBy(xpath="//button/span[text()=' OK ']")
	private WebElement OkButton;
	
	@FindBy(xpath="//*[text()='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath="//*[@role='table']/tbody/tr//div/input")
	WebElement poNoBox;
	
	
	public WebElement getfinance()
	{
		return finance;
	}
	
	public WebElement getsidenav()
	{
		return sidenav;
	}

	public WebElement getworkflow()
	{
		return workflow;
	}
	
	public WebElement getcampaigns()
	{
		return campaigns;
	}
	
	public WebElement getsearch()
	{
		return search;
	}
	
	public WebElement getsalesorder()
	{
		return salesorder;
	}
	
	public WebElement getDraftInvoiceButton()
	{
		return DraftInvoiceButton;
	}
	
	public WebElement getOkButton()
	{
		return OkButton;
	}
	
	public WebElement getcloseButton()
	{
		return closeButton;
	}
	
	public WebElement getpoNum()
	{
		return poNoBox;
	}
	public SalesOrderPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
	
	}

	/*public void goToCampaingPg() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(getsidenav())).click();
	      // click on workflow icon
	      wait.until(ExpectedConditions.elementToBeClickable(getworkflow())).click();
	      
	      // click on campaign icon
	      wait.until(ExpectedConditions.elementToBeClickable(getCampIcon())).click();
	 //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();	
	}
	
	public void clickOnCampId(String num) {
		 // click on the search icon to get the context on the base page
	      
		try {
			
			ba.retryMechanism(driver, eproCreatCamppg.getclearSearch());
		} catch (Exception e) {
			e.printStackTrace();
		}
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
	      
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(num);
	      
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
	      
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
	      wait.until(ExpectedConditions.elementToBeClickable(getsidenav())).click();
	       
	       // click on workflow icon
	       wait.until(ExpectedConditions.elementToBeClickable(getfinance())).click();
	       
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(getsalesorder())).click();
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
		      wait.until(ExpectedConditions.elementToBeClickable(getDraftInvoiceButton())); // hard coded value
		     
		     ba.retryMechanism(driver, getDraftInvoiceButton());
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		      
		      // click on ok in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(getOkButton()));
		      ba.retryMechanism(driver, getOkButton());
		    
		      // click on close in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(getcloseButton()));
		      ba.retryMechanism(driver, getcloseButton());
		}*/
	
	public void goToCampaingPg() {
		
	      // click on workflow icon
	      //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/img[@src='assets/images/workflow.svg']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(getworkflow())).click();
	      // click on campaign icon
	      wait.until(ExpectedConditions.elementToBeClickable(getcampaigns())).click();
	      
	      //clear search
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
	 
	}
	
	public void searchItem(String status) {
		 // click on the search icon to get the context on the base page
	      
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
	      
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).sendKeys(status);
	      
	      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
	      
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
	
	       wait.until(ExpectedConditions.elementToBeClickable(getfinance())).click();
	       
	       // click on Sales order
	       wait.until(ExpectedConditions.elementToBeClickable(getsalesorder())).click();
	       //clear search
		      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).clear();
		      wait.until(ExpectedConditions.elementToBeClickable(getsearch())).click();
		    
	       
	}
	
	public void createDraftInvoice(String campId) throws InterruptedException {
			
		//enter PO number  
		      
				//WebElement poNoBox = driver.findElement(By.xpath("//*[@role='table']/tbody/tr//div/input"));
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
		     
		     ba.retryMechanism(driver, getDraftInvoiceButton());
		     		      
		      // click on ok in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(getOkButton()));
		      ba.retryMechanism(driver, getOkButton());
		    
		      // click on close in pop-up
		      wait.until(ExpectedConditions.elementToBeClickable(getcloseButton()));
		      ba.retryMechanism(driver, getcloseButton());
		}
	
	
	
	}

