package restassuredclasses;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONArray;


public class CreateCampaign {

	public void createCampaign(String userId, String token2) {
		
	    RestAssured.baseURI = "https://uat.paragon-epro.com/CampaignAPI";

	    JSONObject campaignBody = new JSONObject();
	    
	    campaignBody.put("CampaignItems", new JSONArray());
	    campaignBody.put("ProofsEnabled", false);
	    campaignBody.put("CampaignId", 0);
	    campaignBody.put("CampaignNumber", "new number");
	    campaignBody.put("BusinessUnitId", 1);
	    campaignBody.put("BusinessUnitVATRegistrationMappingId", 12);
	    campaignBody.put("CustomerEntityId", 4);
	    campaignBody.put("CurrencyId", 8);
	    campaignBody.put("BrandId", JSONObject.NULL);
	    campaignBody.put("SellOnCostCentreId", JSONObject.NULL);
	    campaignBody.put("CostCentreId", JSONObject.NULL);
	    campaignBody.put("ProductTypeId", JSONObject.NULL);
	    campaignBody.put("IsBlanketPO", false);
	    campaignBody.put("BlanketPOId", JSONObject.NULL);
	    campaignBody.put("AvailableBlanketPOValue", JSONObject.NULL);
	    campaignBody.put("SalesRepresentativeId", 1);
	    campaignBody.put("AccountManagerId", 262);
	    campaignBody.put("CustomerContactId", JSONObject.NULL);
	    campaignBody.put("CustomerId", 4);
	    campaignBody.put("VATTypeId", 1);
	    campaignBody.put("CampaignName", "PostmanTest_ClientDemo46");
	    campaignBody.put("DeliveryDate", "2024-09-19T18:30:00.000Z");
	    campaignBody.put("Status", "Active");
	    campaignBody.put("Active", true);
	    campaignBody.put("TrackingStatusId", 1);
	    campaignBody.put("IsDistribution", JSONObject.NULL);
	    campaignBody.put("CampaignDeliveryDate", "09/30/2024");

	    Response campaignResponse = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token2) 
	            .header("id", userId) 
	            .contentType(ContentType.JSON)
	            .body(campaignBody.toString())
	            .post("/api/campaigns");

	    System.out.println("Campaign API Response Status Code: " + campaignResponse.getStatusCode());
	    System.out.println("Campaign API Response Body: " + campaignResponse.prettyPrint());
	}

}
