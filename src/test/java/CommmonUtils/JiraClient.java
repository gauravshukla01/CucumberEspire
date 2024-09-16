package CommmonUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class JiraClient {

    private static final String JIRA_URL = "https://nitinmore931.atlassian.net/rest/api/3/issue/";
    private static final String JIRA_USERNAME = "nitinmore931@gmail.com"; 
    private static final String TOKEN = "ATATT3xFfGF0cDoHBtxh07q7BVk6Eg-CBMQHBJA5tbqXSPvNXGcl0Br9PvAwNBmnq2qJ_iZyivqUicDgtW1OzOBML7n8aFppC2z_EWHayNsECoR9eXDpsGMVUqJOC9ZbPNJifIzHJrQBaKdnfY33RtpZPJFm21uIrrPmULbPnPe5t4_OGbcnlrA=3A925583";
    private static final String AUTH = "Basic " + Base64.getEncoder().encodeToString((JIRA_USERNAME + ":" + TOKEN).getBytes());

    public synchronized static void updateJiraIssueStatus(String issueId, String newStatus) {
        String transitionEndpoint = JIRA_URL + issueId + "/transitions";
        String payload = String.format("{ \"transition\": { \"id\": \"%s\" } }", newStatus);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(transitionEndpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", AUTH)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 204) {
                System.out.println("Jira issue updated successfully!");
            } else {
                System.out.println("Failed to update Jira issue. Response code: " + response.statusCode());
                System.out.println(response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void getAvailableTransitions(String issueId) {
        String transitionEndpoint = JIRA_URL + issueId + "/transitions";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(transitionEndpoint))
                .header("Authorization", AUTH)
                .header("Content-Type", "application/json") 
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Available transitions: ");
                System.out.println(response.body());
            } else {
                System.out.println("Failed to retrieve transitions. Response code: " + response.statusCode());
                System.out.println(response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //This method is only for extracting the transition id (Plz do not delete)
    
//    public static void main(String[] args) {
//      
//        String issueKey = "EPA-2";
//        
//        getAvailableTransitions(issueKey);
//        
//      updateJiraIssueStatus("EPA-1", "21");
//    }
}
