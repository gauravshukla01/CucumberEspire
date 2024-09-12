package stepDefinitions;

import java.util.Optional;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import CommmonUtils.JiraClient;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import otherResources.TestContext;

public class Hooks{

	TestContext testContext;
	WebDriver driver ;

	public Hooks(TestContext tstContext) throws Exception {
		testContext = tstContext;
		driver = testContext.getWebDriverManager().getDriver();

	}

	@Before
	public void BeforeSteps() {
		// driver = testContext.getWebDriverManager().getDriver(); // Ensure driver is initialized here
	}



	@AfterStep 
	public void takeScreenshot(Scenario scenario) {
		//   WebDriver driver = testContext.getWebDriverManager().getDriver(); // Use the instance from TestContext
		try {
			if (driver != null) {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "image");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@After
	public void teardown(Scenario scenario) {
		
	    Optional<String> jiraIssueKey = scenario.getSourceTagNames()
	            .stream()
	            .filter(tag -> tag.matches(".*-EPA-\\d+"))  
	            .map(tag -> tag.substring(tag.indexOf("EPA-"))) 
	            .findFirst();

	    if (jiraIssueKey.isPresent()) {
	        String issueKey = jiraIssueKey.get();

	        System.out.println("Extracted Issue Key: " + issueKey);

	        if (scenario.isFailed()) {
	           
	            System.out.println("Scenario failed, updating Jira issue " + issueKey + " to In Progress (21).");
	            
	            JiraClient.updateJiraIssueStatus(issueKey, "21");
	        } else {
	           
	            System.out.println("Scenario passed, updating Jira issue " + issueKey + " to Done (41).");
	            
	            JiraClient.updateJiraIssueStatus(issueKey, "41");
	        }
	    } else {
	        System.out.println("No Jira issue key found for this scenario.");
	    }
	    
	    driver.quit();
	}



	}
	





