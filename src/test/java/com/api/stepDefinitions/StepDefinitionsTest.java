package com.api.stepDefinitions;

import java.io.FileReader;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class StepDefinitionsTest {
	private final static Logger logger = Logger.getLogger(StepDefinitionsTest.class.getName());
	public static String apiEndPointUri;
	public static String testName;
	public static String CONTENT_TYPE;
	public static String STATUS_CODE;
	public static String FILE_PATH;
	public static String REQUESTBODY;
	public static String RESPONSEBODY;
	public static Response response;
	
	@Given("^I want to set URL as \"([^\"]*)\" for test case \"([^\"]*)\"$")
	public void setAPIEndpointURL(String URL, String testCaseName) {
		String apiHostName = "https://reqres.in";
		apiEndPointUri = String.format("%s%s", apiHostName, URL);
		testName = testCaseName;
		logger.info("Cucumber Hostname URL is :: " + apiEndPointUri);
		logger.info("Cucumber Test case name is :: " + testName);
	}

	@When("^I set header content type as \"([^\"]*)\"$")
	public void setHeader(String contentType) {
		if (contentType != null && !contentType.isEmpty()) {
			CONTENT_TYPE = contentType;
			logger.info("Content type is :: " + CONTENT_TYPE);
		} else {
			logger.info("Content type cannot be null or empty!");
		}
	}

	@And("^I hit the API with requestbody \"([^\"]*)\" and request method is \"([^\"]*)\"$")
	public void submitRequest(String requestBodyPath, String requestType) throws Throwable {
		RestAssured.baseURI=apiEndPointUri;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", CONTENT_TYPE);
		if (requestBodyPath != null && !requestBodyPath.isEmpty() && requestType.equalsIgnoreCase("POST")
				|| requestType.equalsIgnoreCase("PUT")) {
			JSONParser jsonParser = new JSONParser();
			FILE_PATH = System.getProperty("user.dir") + requestBodyPath;
					
			logger.info("Path of requestbody file is :: " + FILE_PATH);
			try (FileReader reader = new FileReader(FILE_PATH)) {
				Object obj = jsonParser.parse(reader);
				REQUESTBODY = obj.toString();
				logger.info("Request Body is :: " + REQUESTBODY);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			if (REQUESTBODY.length() > 0) {
				request.body(REQUESTBODY);
				response = request.post();
			} else {
				logger.info(" Request Body cannot be null or empty!");
			}
		} else if (requestType.equalsIgnoreCase("GET")) {
			response = request.get();
		}
		STATUS_CODE = String.valueOf(response.getStatusCode());
		RESPONSEBODY = response.getBody().asString();
	}

	@Then("^I try to verify the status code is \"([^\"]*)\"$")
	public void verifyStatusCode(String statusCode) {
		if (statusCode.equals(String.valueOf(STATUS_CODE))) {
			Assert.assertEquals(STATUS_CODE, statusCode);
			logger.info("Status Code is :: " + STATUS_CODE);
		} else {
			Assert.assertEquals(STATUS_CODE, statusCode);
			logger.info("Status Code is not as expected :: " + STATUS_CODE);
		}
	}

	@And("^I try to verify the response value \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verifyResponseValue(String responseKey, String value) throws Throwable {
		JSONObject jsonObject = new JSONObject(RESPONSEBODY);
		Object key = (Object) jsonObject.get(responseKey);
		compareResponseValues(String.valueOf(value), String.valueOf(key), responseKey);
	}

	private void compareResponseValues(String expected, String actual, String responseKey) {
		logger.info("Actual Value is  ::" + actual);
		logger.info("Expected Value is  ::" + expected);
		if (expected.equals(actual)) {
			Assert.assertEquals(actual, expected);

		} else {

			Assert.assertEquals(actual, expected);
		}
	}

}
