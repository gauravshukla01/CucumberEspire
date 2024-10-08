package commonUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import testResourceManager.FileReaderManager;

public class CsvReport {

    
    public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

   
    private static final String PROPERTIES_FILE = System.getProperty("user.dir") + "/src/test/resources/extent.properties";
    private static Properties properties = new Properties();
    
    
    private static HashMap<String, String> hm = new HashMap<>();

    static {
        try {
           
            properties.load(Files.newBufferedReader(Paths.get(PROPERTIES_FILE)));
        } catch (IOException e) {
            System.err.println("Failed to load extent.properties file: " + e.getMessage());
        }
    }

    
    private static boolean isCsvEnabled() {
        return Boolean.parseBoolean(properties.getProperty("csv.report.enabled", "false"));
    }

   
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

    //Append or overwrite- csv
    private static boolean isAppendEnabled() {
        return Boolean.parseBoolean(properties.getProperty("csv.report.append", "true"));
    }

    
    public static void logToCsv(String testName, String status) {
        if (isCsvEnabled()) {
            System.out.println("Logging to CSV: " + testName + " - " + status); // Debug message
            
           
            hm.put(testName, status);
            writeToCsvFile();
        } else {
            System.out.println("CSV logging failed"); // Debug message
        }
    }
  
    private static void writeToCsvFile() {
        String csvFilePath = getCsvFilePath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, isAppendEnabled()))) {
            // If the file doesn't & not appending
            if (Files.exists(Paths.get(csvFilePath))) {
                writer.write("Testcases,Status,ApplicationEnvironment,Browser");
                writer.newLine();
            }

            // Write the results from the HashMap
            for (Map.Entry<String, String> entry : hm.entrySet()) {
                writer.write(entry.getKey() + "," +
                             entry.getValue() + "," +
                             FileReaderManager.getInstance().getConfigReader().getApplicationEnvironment() + "," + 
                             FileReaderManager.getInstance().getConfigReader().getBrowser());
                writer.newLine();
            }
            System.out.println("Data has been written to " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage()); // Debug message
        }
    }
    
    public static Map<String,Integer> returnResultStatistics() {
    	
    	HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
    	
    	int totalNumberOfTestCases=hm.size();
    	int totalNumberOfPassedTestCases=0;
    	int totalNumberOfFailedTestCases=0;
    	int totalNumberOfSkippedTestCases=0;
    	for(Map.Entry<String, String> entry : hm.entrySet()) {
    		if(entry.getValue().equalsIgnoreCase("PASS")) {
    			totalNumberOfPassedTestCases++;	
    		}
    		
    		else if(entry.getValue().equalsIgnoreCase("FAIL")){
    			totalNumberOfFailedTestCases++;	
    		}
    		
    		else {
    			totalNumberOfSkippedTestCases++;
    		}
    	}
    	
    	resultMap.put("TOTAL", totalNumberOfTestCases);
    	resultMap.put("PASS", totalNumberOfPassedTestCases);
    	resultMap.put("FAIL", totalNumberOfFailedTestCases);
    	resultMap.put("SKIPPED", totalNumberOfSkippedTestCases);
    	
    	return resultMap;
    	
    }
}
