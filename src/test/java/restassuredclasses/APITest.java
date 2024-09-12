package restassuredclasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITest {

    private String userId;
    private String token2;

    @BeforeClass
    public void loginAndExtractToken() {
       
    	LoginToEpro loginAPI = new LoginToEpro();

        String[] userData = loginAPI.loginAndExtractUserIdAndToken();
        userId = userData[0];
        token2 = userData[1];

        System.out.println("Extracted UserId: " + userId);
        System.out.println("Extracted Token 2: " + token2);
    }

    @Test
    public void createCampaignTest() {

    	CreateCampaign campaignAPI = new CreateCampaign();

        campaignAPI.createCampaign(userId, token2);
    }
}

