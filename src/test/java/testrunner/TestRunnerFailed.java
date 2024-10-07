package testrunner;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import TestResourceManager.FileReaderManager;
import commonUtils.BaseClass;
import commonUtils.EmailClient;
import commonUtils.JsonReportExtractor;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

			plugin = { "summary","pretty", "html:target1/cucumber-reports.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target1/cucumber-reports"
					},
			features = "@target/failed.txt"
	        ,glue={"stepDefinitions","commonUtils"}
	        ,dryRun = false
	        ,monochrome = true
	)

public class TestRunnerFailed extends AbstractTestNGCucumberTests {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		if(driver==null) {
		
		new BaseClass().launchBrowser();
		
		driver=BaseClass.getDriver();
		
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		
		if(driver !=null)
		{
		driver.quit();
		driver=null;
		}
	}
	
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	 }
	    @AfterSuite
	    public void createReportAndSend() {
	    	
	    	JsonReportExtractor.csvReport();
			
			 String reportPath = FileReaderManager.getInstance().getConfigReader().getEmailableReportPath();
			 String senderEmailAddress =FileReaderManager.getInstance().getConfigReader().getEmailSenderAddress();
			 String senderEmailPassword = FileReaderManager.getInstance().getConfigReader().getEmailSenderPassword();
			 String recieverEmailAddress = FileReaderManager.getInstance().getConfigReader().getEmailRecieverAddress();
			 String hostAddress = FileReaderManager.getInstance().getConfigReader().getEmailHostAddress();
			 String portNumber = FileReaderManager.getInstance().getConfigReader().getEmailHostPortNumber();
			 String emailSubject =  FileReaderManager.getInstance().getConfigReader().getEmailSubject();
			 String emailBody = FileReaderManager.getInstance().getConfigReader().getEmailBody();
			 
			 EmailClient.sendEmailWithReport(reportPath, senderEmailAddress, senderEmailPassword,recieverEmailAddress, hostAddress, portNumber,emailSubject,emailBody);
			 
	    }

}