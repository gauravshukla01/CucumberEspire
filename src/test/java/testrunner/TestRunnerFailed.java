package testrunner;



import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import commonUtils.CsvReport;
import commonUtils.EmailClient;
import commonUtils.JsonReportExtractor;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testResourceManager.FileReaderManager;

@CucumberOptions(

			plugin = { "summary","pretty", "html:target1/cucumber-reports.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target1/cucumber-reports"
					},
			features = "@target/failed.txt"
	        ,glue={"stepDefinitions","hooks"}
	        ,dryRun = false
	        ,monochrome = true
	)

public class TestRunnerFailed extends AbstractTestNGCucumberTests {
		
//	 @Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	 }
	    @AfterSuite
	    public void createReportAndSend() {
	    	
	    	Map<String, Integer> resultStatistics=new HashMap<String,Integer>();
	    	int totalTestCases=0;
	    	int passTestCases=0;
	    	int failedTestCases=0;
	    	int skippedTestCases=0;
	    	
	    	JsonReportExtractor.csvReport();
	    	
	    	resultStatistics=CsvReport.returnResultStatistics();
	    	
	    	for(Entry<String, Integer> entry : resultStatistics.entrySet()) {
	    		
	    		if(entry.getKey()=="TOTAL") {
	    			totalTestCases=entry.getValue();
	    		}
	    		else if(entry.getKey()=="PASS") {
	    			passTestCases=entry.getValue();
	    		}
	    		else if(entry.getKey()=="FAIL") {
	    			failedTestCases=entry.getValue();
	    		}
	    		else {
	    			skippedTestCases=entry.getValue();
	    		}
	    	}
			
			 String reportPath = FileReaderManager.getInstance().getConfigReader().getEmailableReportPath();
			 String senderEmailAddress =FileReaderManager.getInstance().getConfigReader().getEmailSenderAddress();
			 String senderEmailPassword = FileReaderManager.getInstance().getConfigReader().getEmailSenderPassword();
			 String recieverEmailAddress = FileReaderManager.getInstance().getConfigReader().getEmailRecieverAddress();
			 String hostAddress = FileReaderManager.getInstance().getConfigReader().getEmailHostAddress();
			 String portNumber = FileReaderManager.getInstance().getConfigReader().getEmailHostPortNumber();
			 String emailSubject =  FileReaderManager.getInstance().getConfigReader().getEmailSubject();
			 String body = FileReaderManager.getInstance().getConfigReader().getEmailBody();
			 
			 EmailClient.sendEmailWithReport(reportPath, senderEmailAddress, senderEmailPassword,recieverEmailAddress, hostAddress, portNumber,emailSubject,
					 totalTestCases,passTestCases,failedTestCases,skippedTestCases);
			 
	    }

}