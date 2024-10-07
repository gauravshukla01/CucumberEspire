package commonUtils;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonReportExtractor {

    public static void csvReport () {
        // Replace this with your actual file path
        String filePath = System.getProperty("user.dir")+"/test-output/JsonReport/ExtentJson.json";
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            // Read JSON file into JsonArray
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            System.out.println("Total test runs: " + jsonArray.size());

            // Iterate through each test run in the JSON array
            for (JsonElement testRunElement : jsonArray) {
                JsonObject testRun = testRunElement.getAsJsonObject();

                // Check if the test run has a "children" array
                if (testRun.has("children")) {
                    JsonArray childrenArray = testRun.getAsJsonArray("children");

                    // Iterate through each child (scenario) in "children"
                    for (JsonElement childElement : childrenArray) {
                        JsonObject childObject = childElement.getAsJsonObject();

                        // Check if the scenario has a "level" key and its value is 1
                        if (childObject.has("level") && childObject.get("level").getAsInt() == 1) {
                            String scenarioName = childObject.get("name").getAsString();
                            String scenarioStatus = childObject.get("status").getAsString();

                            // Log the scenario details to CSV including environment and browser
                            CsvReport.logToCsv(scenarioName, scenarioStatus);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
