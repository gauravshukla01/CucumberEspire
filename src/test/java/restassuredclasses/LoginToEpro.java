package restassuredclasses;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginToEpro {

    public String[] loginAndExtractUserIdAndToken() {
      
        RestAssured.baseURI = "https://uat.paragon-epro.com/MasterAPI";

        JSONArray jsonArray = new JSONArray();

        JSONObject login1 = new JSONObject();
        login1.put("IsImpersonate", false);
        login1.put("RefreshTokenFor", "master");
        login1.put("Username", "Staginguser_6");
        login1.put("Password", "Paragon@2024");
        login1.put("CaptureLoginTime", "1724229244081");

        JSONObject login2 = new JSONObject();
        login2.put("IsImpersonate", false);
        login2.put("RefreshTokenFor", "campaign");
        login2.put("Username", "Staginguser_6");
        login2.put("Password", "Paragon@2024");
        login2.put("CaptureLoginTime", "1724229244081");

        jsonArray.put(login1);
        jsonArray.put(login2);

        Response loginResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(jsonArray.toString())
                .post("/login");
        
        String loginResponseBody = loginResponse.getBody().asString();
        JSONArray responseArray = new JSONArray(loginResponseBody);
        JSONObject secondLoginObject = responseArray.getJSONObject(1);  
        String token2 = secondLoginObject.getString("Token");
        int userId = secondLoginObject.getInt("UserId");

        System.out.println("Campaign API Response Status Code: " + loginResponse.getStatusCode());
        return new String[]{String.valueOf(userId), token2};
    }
}



