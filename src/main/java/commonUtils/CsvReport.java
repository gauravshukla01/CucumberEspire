package commonUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CsvReport {

    // Format for the timestamp
    public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

    // Load properties file paths dynamically
    private static final String PROPERTIES_FILE = System.getProperty("user.dir") + "/src/test/resources/extent.properties";
    private static final String CONFIG_PROPERTIES = System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties";
    private static Properties properties = new Properties();

    static {
        try {
            // Load the extent.properties file
            properties.load(Files.newBufferedReader(Paths.get(PROPERTIES_FILE)));
        } catch (IOException e) {
            System.err.println("Failed to load extent.properties file: " + e.getMessage());
        }
        try {
            // Load the config.properties file
            properties.load(Files.newBufferedReader(Paths.get(CONFIG_PROPERTIES)));
        } catch (IOException e) {
            System.err.println("Failed to load config.properties file: " + e.getMessage());
        }
    }

    // Method to check if CSV reporting is enabled
    private static boolean isCsvEnabled() {
        return Boolean.parseBoolean(properties.getProperty("csv.report.enabled", "false"));
    }

    // Get the path to the CSV report file
    private static String getCsvFilePath() {
        String timestampedDir = "CsvReport_" + TIME_STAMP.replace(".", "_").replace(":", "_").replace(" ", "_");
        String path = properties.getProperty("csv.report.out", "target1/test-output/" + timestampedDir + "/ExtentCsvReport.csv");

        // Create the directory if it doesn't exist
        String directoryPath = path.substring(0, path.lastIndexOf("/"));
        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }

        return path;
    }

    // Check if we should append to the CSV file or overwrite
    private static boolean isAppendEnabled() {
        return Boolean.parseBoolean(properties.getProperty("csv.report.append", "false"));
    }

    // Method to log test results to the CSV report
    public static void logToCsv(String testName, String status) {
        if (isCsvEnabled()) {
            System.out.println("Logging to CSV: " + testName + " - " + status); // Debug message
            try {
                // Get the path to the CSV file
                String csvFilePath = getCsvFilePath();

                // Create or append to the CSV file
                boolean fileExists = Files.exists(Paths.get(csvFilePath));
                boolean isFileEmpty = fileExists && Files.size(Paths.get(csvFilePath)) == 0;

                try (FileWriter writer = new FileWriter(csvFilePath, true)) { // Set to true for appending
                    // Write header if the file is empty or created for the first time
                    if (!fileExists || isFileEmpty) {
                        writer.append("Testcases,Status,ApplicationEnvironment,Browser\n"); // Write the headers correctly
                    }
                    // Write test name, status, environment, and browser to the CSV
                    writer.append(testName)
                          .append(",")
                          .append(status)
                          .append(",")
                          .append(properties.getProperty("applicationEnvironment", "Unknown"))
                          .append(",")
                          .append(properties.getProperty("browser", "Unknown"))
                          .append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error writing to CSV: " + e.getMessage()); // Debug message
            }
        } else {
            System.out.println("CSV logging is not enabled."); // Debug message
        }
    }
}
