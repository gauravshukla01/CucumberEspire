package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import otherResources.TestContext;
import pageObjects.AmazonHomePage;
import pageObjects.EproCampaignPage;
import pageObjects.EproCreateCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;

public class EproStepDefinition {
	
	
	
	TestContext testContext;
    AmazonHomePage amznHome;
    EproLoginPage eprologin;
    EproHomePage eprohome;
    EproCampaignPage eprocamppage;
    EproCreateCampaignPage eprocreatecamp;
    
    public EproStepDefinition(TestContext tstContext){
        testContext = tstContext;
        amznHome = testContext.getPageObjectManager().getAmazonHomePage();
        eprologin = testContext.getPageObjectManager().getEproLoginPage();
        eprohome =  testContext.getPageObjectManager().getEproHomePage();
        eprocamppage =  testContext.getPageObjectManager().getEproCampaignPage();
        eprocreatecamp =  testContext.getPageObjectManager().getEproCreateCampaignPage();
    }

	
	@Given("User launches {string}")
	public void User_launches (String url) {
		
		eprologin.launchurl(url);
	}
	
	
	
	@When("^user enters (.*) and(.*)$")
	public void user_enters_staginguser_and_paragon(String Username, String Password) {
	 eprologin.EnterUsernameAndPassword(Username, Password);
	   
	}
	
	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() throws InterruptedException {
		
		//eprologin.HandleCaptcha();
		eprologin.Clksubmit();
	}
	
	@When("user should get logged in")
	public void user_should_get_logged_in() {
		//add validation
	  System.out.println("User is now logged in");
	}

	@When("user clicks on campaigns")
	public void user_clicks_on_campaigns() throws InterruptedException {
	 eprohome.ClkCampaign();
	   
	}

	@When("user clicks on create campaign button")
	public void user_clicks_on_create_campaign_button() {
      eprocamppage.clkAddCampaign();
	}

	@When("user selects the business Unit")
	public void user_selects_the_business_unit() throws InterruptedException {
		
		eprocreatecamp.selectBusinessUnit();
	}

	@When("user select the customer and customer entity")
	public void user_select_the_customer_and_customer_entity() {
		 System.out.println("user select the customer and customer entity");
	}

	@When("user enters the campaign details")
	public void user_enters_the_campaign_details() {
		 System.out.println("user enters the campaign details");
	}

	@When("user clicks on save & submit button")
	public void user_clicks_on_save_submit_button() {
		 System.out.println("user clicks on save & submit button");
	}

	@Then("campaign is successfully created alert appears")
	public void campaign_is_successfully_created_alert_appears() {
		 System.out.println("campaign is successfully created alert appears");
	}


}
