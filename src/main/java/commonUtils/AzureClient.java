package commonUtils;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Comparator;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONObject;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import io.cucumber.java.Scenario;
import testResourceManager.FileReaderManager;

public class AzureClient {
	
	private static final String AZURE_API_ENDPOINT_TO_CREATE_TASK = FileReaderManager.getInstance().getConfigReader().getAzureEndPointToCreateTask();
	private static final String AZURE_API_ENDPOINT_TO_UPDATE_TASK_STATUS = "https://dev.azure.com/{organization}/{project}/_apis/wit/workitems/{testCaseId}?api-version=6.0";
	//private static final String AZURE_KEY_VAULT_URL = FileReaderManager.getInstance().getConfigReader().getAzureKeyVaultUrl();
	//private static final String AZURE_KEY_NAME = FileReaderManager.getInstance().getConfigReader().getAzureKeyName();
	//private static final String AZURE_PERSONAL_ACCESS_TOKEN = getAzurePAT(AZURE_KEY_VAULT_URL,AZURE_KEY_NAME);
	private static final String AZURE_PERSONAL_ACCESS_TOKEN = FileReaderManager.getInstance().getConfigReader().getAzurePeronalToken();
	private static final String AZURE_ORGANIZATION_NAME = FileReaderManager.getInstance().getConfigReader().getAzureOrganizationName();
	private static final String AZURE_PROJECT_NAME = FileReaderManager.getInstance().getConfigReader().getAzureProjectName();
	private static final long AZURE_TEST_DEFECTS_EPIC_ID = FileReaderManager.getInstance().getConfigReader().getAzureTestDefectsEpicId();
	private static final String AZURE_PROJECT_ID = FileReaderManager.getInstance().getConfigReader().getAzureProjectId();
	private static final String AZURE_SESSION_ID = FileReaderManager.getInstance().getConfigReader().getAzureSessionId();
	private static final String BASE_URL = "https://dev.azure.com/"+AZURE_ORGANIZATION_NAME+"/"+AZURE_PROJECT_NAME+""; 
	

	    public synchronized static void createDefectInAzureDevOps(String description,Scenario scenario) {
		
	       try {
	    	 int bugWorkItemId = 0;
	        URL url = new URL(AZURE_API_ENDPOINT_TO_CREATE_TASK);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("accept", "application/json;api-version=5.1-preview.1;excludeUrls=true;enumsAsNumbers=true;msDateFormat=true;noArrayWrap=true");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("referer", BASE_URL+"/_workitems/create/Issue");
	        conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((":" + AZURE_PERSONAL_ACCESS_TOKEN).getBytes()));
	        conn.setDoOutput(true);  // Enable output for POST request

	        // Construct dynamic JSON payload
	        String issueTitle = "Failed Scenario - " + scenario.getName();
	        String dynamicDescription = "<div>Description- " + description + "<br></div>";

//	        String updatePackage = "[{\"id\":0,\"rev\":0,\"projectId\":\"e6c3f77c-7f48-4071-9b75-a3a33122027c\",\"isDirty\":true,\"tempId\":-3,\"fields\":{\"1\":\"" 
//	            + issueTitle + "\",\"2\":\"To Do\",\"9\":\"TS <rahul@espire.com>\",\"22\":\"Added to backlog\",\"25\":\"Issue\",\"33\":\"Rahul <rahul@espire.com>\",\"52\":\"" 
//	            + dynamicDescription + "\",\"49538556\":{\"type\":1},\"49538564\":2,\"-2\":2,\"-104\":2}}]";
	        
	        String updatePackage = "[{\"id\":0,\"rev\":0,\"projectId\":\""
	        		+ AZURE_PROJECT_ID+"\",\"isDirty\":true,\"tempId\":-1,\"fields\":{\"1\":\""
	        		+ issueTitle +"\",\"2\":\"To Do\",\"9\":\"TS Avinash <Avinash.TS@espire.com>\",\"22\":\"Added to backlog\",\"25\":\"Issue\",\"33\":\"TS Avinash <Avinash.TS@espire.com>\",\"52\":\""
	        		+ dynamicDescription+"\",\"49559537\":{\"type\":1},\"49559545\":2,\"-2\":2,\"-104\":2}}]";



	        // Construct JSON request body
	        JSONObject properties = new JSONObject();
	        properties.put("updatePackage", updatePackage);

	        // Add other JSON properties (page source, navigation, etc.)
	        JSONObject pageSource = new JSONObject();
	        pageSource.put("contributionPaths", new JSONArray().put("VSS").put("VSS/Resources"));
	        //pageSource.put("diagnostics", new JSONObject().put("sessionId", "fe9562a4-0343-47e8-acfe-439f6d9f12d2").put("activityId", "fe9562a4-0343-47e8-acfe-439f6d9f12d2"));
	        pageSource.put("diagnostics", new JSONObject().put("sessionId", AZURE_SESSION_ID).put("activityId", AZURE_SESSION_ID));
	        
	        JSONObject routeValues = new JSONObject();
	        routeValues.put("project", AZURE_PROJECT_NAME).put("parameters", "Issue").put("controller", "Apps").put("action", "ContributedHub");

	        properties.put("pageSource", pageSource);
	        properties.put("navigation", new JSONObject().put("topMostLevel", 8).put("routeValues", routeValues));

	        JSONObject context = new JSONObject();
	        context.put("properties", properties);
	        context.put("project", new JSONObject().put("id", AZURE_PROJECT_ID).put("name", AZURE_PROJECT_NAME));

	        JSONObject jsonBody = new JSONObject();
	        jsonBody.put("contributionIds", new JSONArray().put("ms.vss-work-web.update-work-items-data-provider"));
	        jsonBody.put("context", context);

	        String jsonBodyString = jsonBody.toString();
	        byte[] jsonBytes = jsonBodyString.getBytes("UTF-8");

	        // Set the Content-Length header
	        conn.setRequestProperty("Content-Length", String.valueOf(jsonBytes.length));

	        // Write the JSON body to the output stream
	        try (OutputStream os = conn.getOutputStream()) {
	            os.write(jsonBytes);
	            os.flush();
	        }

	        // Get the response code
	        int responseCode = conn.getResponseCode();
	        
	       
	        
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            System.out.println("Defect created successfully.");
	            
			
					JSONObject response = new JSONObject(new String(conn.getInputStream().readAllBytes()));
					
					// Navigate through the nested JSON structure
			    if (response.has("data")) {
				        JSONObject data = response.getJSONObject("data");
				        if (data.has("ms.vss-work-web.update-work-items-data-provider")) {
				            JSONObject providerData = data.getJSONObject("ms.vss-work-web.update-work-items-data-provider");
				            JSONArray workItemsArray = providerData.getJSONArray("data");
				            
				            if (workItemsArray.length() > 0) {
				                JSONObject workItem = workItemsArray.getJSONObject(0);
				                
				                // Check if "id" exists and retrieve it
				                if (workItem.has("id")) {
				                     bugWorkItemId = workItem.getInt("id");
				                  System.out.println("Issue Id = "+ bugWorkItemId );  
				                    // Now link the bug to the epic
			                    
				                  attachEpicToDefect( bugWorkItemId, AZURE_TEST_DEFECTS_EPIC_ID);
				                    
					// If there's a screenshot, attach it
					      String screenshotPath = null;
						try {
							screenshotPath = getLatestScreenshotPath();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    if (screenshotPath != null && !screenshotPath.isEmpty()) {
		
					    	uploadScreenshot(bugWorkItemId, screenshotPath);
					    	
					       }
	            
	        } else {
	            System.out.println("Failed to create defect. Response Code: " + responseCode);
	            try (InputStream errorStream = conn.getErrorStream()) {
	                if (errorStream != null) {
	                    System.out.println("Error Response: " + new String(errorStream.readAllBytes(), "UTF-8"));
	                }
	            }
	        } }}}}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
   	  

	    public static void updateTestCase(int testCaseId, String field, String newValue) {
	        String url = AZURE_API_ENDPOINT_TO_UPDATE_TASK_STATUS
	                .replace("{organization}", "your_organization")
	                .replace("{project}", "your_project")
	                .replace("{testCaseId}", String.valueOf(testCaseId));

	        try (CloseableHttpClient client = HttpClients.createDefault()) {
	            HttpPatch httpPatch = new HttpPatch(url);
	            String base64Credentials = Base64.getEncoder().encodeToString((":" + AZURE_PERSONAL_ACCESS_TOKEN).getBytes());
	            httpPatch.setHeader("Authorization", "Basic " + base64Credentials);
	            httpPatch.setHeader("Content-Type", "application/json-patch+json");

	            // Create the JSON patch document
	            String jsonPatch = "[{\"op\": \"add\", \"path\": \"/fields/" + field + "\", \"value\": \"" + newValue + "\"}]";
	            StringEntity entity = new StringEntity(jsonPatch);
	            httpPatch.setEntity(entity);

	            try (CloseableHttpResponse response = client.execute(httpPatch)) {
	                String responseBody = EntityUtils.toString(response.getEntity());
	                
	                if(response.getStatusLine().getStatusCode()==200) {
	                	System.out.println("Test case status updated successfully");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private static void attachEpicToDefect(int defectId, long epicId) throws IOException {        
	    	    
	    	String url = BASE_URL+"/_apis/wit/workitems/"+defectId+"?api-version=7.2-preview.3";
	    	CloseableHttpClient client = HttpClients.createDefault();   
	    	HttpPatch patch = new HttpPatch(url);      
	
	        String jsonBody = "[{\"op\":\"add\",\"path\":\"/relations/-\",\"value\":{\"rel\":\"System.LinkTypes.Dependency-forward\",\"url\":\"https://dev.azure.com/EspireAvinash/ParagonUIAutomation/_apis/wit/workItems/1\",\"attributes\":{\"comment\":\"Making a new link for the dependency\"}}}]";
	    	
	    	StringEntity entity = new StringEntity(jsonBody);    
	    	patch.setEntity(entity); 
	    	patch.setHeader("Content-Type", "application/json-patch+json"); 
	    	patch.setHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((":"+AZURE_PERSONAL_ACCESS_TOKEN).getBytes()));     
	    	CloseableHttpResponse response = client.execute(patch); 
	    	String responseString = EntityUtils.toString(response.getEntity());
	    	if (response.getStatusLine().getStatusCode() == 200)
	    	{ System.out.println("Successfully attached Epic to defect. Response: " + responseString);
	    	} 
	    	else { System.err.println("Failed to attach Epic. Status: " + response.getStatusLine().getStatusCode() + ", Response: " + responseString); 
	    	}
	    	client.close();
}
	    
	    private static void uploadScreenshot(int bugWorkItemId, String screenshotPath) throws IOException {
	        // Upload the screenshot and get the attachment URL
	        String attachmentUrl = uploadFileToAzureDevOps(screenshotPath);

	        if (attachmentUrl != null) {
	            // Attach the uploaded file to the work item (bug)
	            attachFileToWorkItem(bugWorkItemId, attachmentUrl);
	        }
	    }

	    // Method to upload a file to Azure DevOps and return the attachment URL
	    private static String uploadFileToAzureDevOps(String filePath) throws IOException {
	        File file = new File(filePath);
	        String uploadUrl = BASE_URL + "/_apis/wit/attachments?fileName=" + file.getName() + "&api-version=6.0";

	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            HttpPost post = new HttpPost(uploadUrl);
	            
	            // Base64 encode the PAT (Personal Access Token)
	            String auth = "Basic " + Base64.getEncoder().encodeToString((":" + AZURE_PERSONAL_ACCESS_TOKEN).getBytes());
	            post.setHeader(HttpHeaders.AUTHORIZATION, auth);
	            post.setHeader("Content-Type", "application/octet-stream");

	            // Build multipart entity with the file
	  //          MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	  //          builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, file.getName());
	  //          post.setEntity(builder.build());

	            // Execute the request
	            CloseableHttpResponse response = httpClient.execute(post);
	            String responseBody = EntityUtils.toString(response.getEntity());

	            if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
	                System.out.println("File uploaded successfully.");
	                // Extract attachment URL from the response
	                String attachmentUrl = extractAttachmentUrl(responseBody);
	                System.out.println("Attachment URL: " + attachmentUrl);
	                return attachmentUrl;
	            } else {
	                System.err.println("Failed to upload file. Response: " + responseBody);
	                return null;
	            }
	        }
	    }

	 // Method to attach the uploaded file to a work item
	    private static void attachFileToWorkItem(int workItemId, String attachmentUrl) throws IOException {
	        String workItemUrl = BASE_URL + "/_apis/wit/workitems/" + workItemId + "?api-version=6.0";

	        // Prepare the JSON body for attaching the file
	        String jsonBody = "[\n" +
	                "  {\n" +
	                "    \"op\": \"add\",\n" +
	                "    \"path\": \"/relations/-\",\n" +
	                "    \"value\": {\n" +
	                "      \"rel\": \"AttachedFile\",\n" +
	                "      \"url\": \"" + attachmentUrl + "\",\n" +
	                "      \"attributes\": {\n" +
	                "        \"comment\": \"Screenshot for bug\"\n" +
	                "      }\n" +
	                "    }\n" +
	                "  }\n" +
	                "]";

	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            HttpPatch patch = new HttpPatch(workItemUrl);

	            // Set headers for the request
	            String auth = "Basic " + Base64.getEncoder().encodeToString((":" + AZURE_PERSONAL_ACCESS_TOKEN).getBytes());
	            patch.setHeader(HttpHeaders.AUTHORIZATION, auth);
	            patch.setHeader("Content-Type", "application/json-patch+json");  // Ensure correct Content-Type

	            // Set JSON body for the request
	            StringEntity entity = new StringEntity(jsonBody);
	            patch.setEntity(entity);

	            // Execute the request
	            CloseableHttpResponse response = httpClient.execute(patch);
	            String responseBody = EntityUtils.toString(response.getEntity());

	            // Check if the request was successful
	            if (response.getStatusLine().getStatusCode() == 200) {
	                System.out.println("Attachment added to work item successfully.");
	            } else {
	                System.err.println("Failed to attach file to work item. Response: " + responseBody);
	            }
	        }
	    }

	 // Helper method to extract attachment URL from the JSON response
	    private static String extractAttachmentUrl(String responseBody) {
	        try {
	            // Parse the response JSON
	            JSONObject responseJson = new JSONObject(responseBody);

	            // Extract the "url" field from the response (assuming the response has a field named "url")
	            if (responseJson.has("url")) {
	                return responseJson.getString("url");  // Return the URL for the uploaded attachment
	            } else {
	                System.err.println("URL field not found in the response.");
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    private static String getLatestScreenshotPath() {
	        Path screenshotDir = Paths.get("Failed_testcase_screenshots");
	        if (!Files.exists(screenshotDir)) {
	            return null;  // No screenshot folder exists
	        }
 
	        // Find the most recent file in the screenshot folder
	        try {
	            return Files.list(screenshotDir)
	                .filter(Files::isRegularFile)
	                .max(Comparator.comparingLong(p -> p.toFile().lastModified()))  // Get the most recently modified file
	                .map(Path::toString)  // Return the file path as a string
	                .orElse(null);  // Return null if no file is found
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    private static String getAzurePAT(String azureKeyVaultUrl,String secreteName) {
	    	
	    	SecretClient secretClient = new SecretClientBuilder()
	                .vaultUrl(azureKeyVaultUrl)
	                .credential(new DefaultAzureCredentialBuilder().build())
	                .buildClient();
	    	
	    	String secretValue = secretClient.getSecret(secreteName).getValue();
	    	
	    	return secretValue;
	    	
	    }
	    
	    private static void getTestRuns(String organizationName,String projectName) {
	        String url = "https://dev.azure.com/{organization}/{project}/_apis/test/runs?api-version=6.0"
	                .replace("{organization}", organizationName)
	                .replace("{project}", projectName);

	        try (CloseableHttpClient client = HttpClients.createDefault()) {
	            HttpGet httpGet = new HttpGet(url);
	            String base64Credentials = Base64.getEncoder().encodeToString((":" + AZURE_PERSONAL_ACCESS_TOKEN).getBytes());
	            httpGet.setHeader("Authorization", "Basic " + base64Credentials);
	            httpGet.setHeader("Content-Type", "application/json");

	            try (CloseableHttpResponse response = client.execute(httpGet)) {
	                String responseBody = EntityUtils.toString(response.getEntity());
	                System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
	                System.out.println("Response Body: " + responseBody);

	                // Parse the response JSON to extract run IDs and result IDs
	                // You'll need a JSON library like org.json or Gson to parse the response
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
	      

	    

