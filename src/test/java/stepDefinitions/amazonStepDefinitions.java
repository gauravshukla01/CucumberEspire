package stepDefinitions;

import CommmonUtils.CollectionsTransformation;

import io.cucumber.java.en.*;
import otherResources.TestContext;
import pageObjects.amazon.AmazonHomePage;
import java.util.List;
import java.util.Map;

public class amazonStepDefinitions {

    TestContext testContext;
    AmazonHomePage amznHome;
    public amazonStepDefinitions(TestContext tstContext){
        testContext = tstContext;
        amznHome = testContext.getPageObjectManager().getAmazonHomePage();
    }

    @Given("User launches {string}")
    public void user_launches(String url) throws InterruptedException {

        amznHome.openAmazonHomePage(url);
        System.out.println("Launch amazon");

    }
    @When("username and password are entered")
    public void username_and_password_password_are_entered(final io.cucumber.datatable.DataTable dataTable) {

        Map<String, List<String>> map = CollectionsTransformation.dataTableToMapOfList(dataTable);

        System.out.println("Enter Credentials");

    }


    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        System.out.println("Click on submit");
    }
    @Then("user should get logged in")
    public void user_should_get_logged_in() {
        System.out.println("user should be logged in");
    }

}
