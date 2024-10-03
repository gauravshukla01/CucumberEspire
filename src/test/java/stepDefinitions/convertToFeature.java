package stepDefinitions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class convertToFeature {
	
	public static void main(String[] args) throws CsvException {
        String csvFilePath = "C:\\Users\\chetan.patel\\Downloads\\Demo\\TestCase_Template 1.csv";

        // Create a new feature file with a timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String featureFilePath = "C:\\Users\\chetan.patel\\eclipse-workspace\\CucumberEspire\\src\\test\\resources\\Stories\\output_"
                + timestamp + ".feature";

        try {
            List<String[]> testCases = readTestCases(csvFilePath);
            String featureContent = convertToFeature(testCases);
            writeFeatureFile(featureContent, featureFilePath);
            System.out.println("Feature file generated successfully at: " + featureFilePath);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readTestCases(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }

    private static String convertToFeature(List<String[]> testCases) {
        StringBuilder featureBuilder = new StringBuilder();
        featureBuilder.append("Feature: Manual Invoice Creation\n\n");

        String tcId = null;
        String tcDescription = null;
        StringBuilder stepsBuilder = new StringBuilder();

        // Iterate through each row in the CSV
        for (int i = 1; i < testCases.size(); i++) {
            String[] caseData = testCases.get(i);
            String currentTcId = caseData[0].trim();         // Get TC_ID
            String currentTcDescription = caseData[1].trim(); // Get TC_Description
            String currentStep = caseData[2].trim();         // Get Steps

            // If a new TC_ID is encountered, process the previous test case
            if (!currentTcId.isEmpty() && tcId != null) {
                // Write the previous test case as a feature scenario
                appendScenario(featureBuilder, tcId, tcDescription, stepsBuilder.toString());
                stepsBuilder.setLength(0); // Clear steps for the new test case
            }

            // Update the test case ID and description when a new test case starts
            if (!currentTcId.isEmpty()) {
                tcId = currentTcId;
                tcDescription = currentTcDescription;
            }

            // Append steps for the current test case
            stepsBuilder.append(currentStep).append("\n");
        }

        // Handle the last test case (as the loop ends without processing the last one)
        if (tcId != null) {
            appendScenario(featureBuilder, tcId, tcDescription, stepsBuilder.toString());
        }

        return featureBuilder.toString();
    }

    // Helper method to append the scenario to the feature file content
    private static void appendScenario(StringBuilder featureBuilder, String tcId, String tcDescription, String steps) {
        // Create a unique scenario title
        featureBuilder.append("Scenario: ").append(tcDescription).append("\n");

        // Split steps by newline and format them as Gherkin steps
        String[] stepsArray = steps.split("\n");
        boolean isFirstStep = true;
        for (String step : stepsArray) {
            step = step.trim();
            if (!step.isEmpty()) {
                if (isFirstStep) {
                    featureBuilder.append("    Given ").append(step).append("\n");
                    isFirstStep = false;
                } else {
                    featureBuilder.append("    And ").append(step).append("\n");
                }
            }
        }

        // Add final verification step
        featureBuilder.append("    Then Verify invoice creation confirmation\n\n");
    }



    private static void writeFeatureFile(String content, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}


