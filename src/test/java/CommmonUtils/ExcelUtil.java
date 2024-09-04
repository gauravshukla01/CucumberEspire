package CommmonUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {

    public static final String WORKING_DIR = System.getProperty("user.dir");
    public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
    public static final String EXCEL_REPORTS_FOLDER = WORKING_DIR + "/ExcelReports";
    public static final String REPORT_NAME = "FailedStepsReport_" + TIME_STAMP + ".xlsx";
    public static final String EXCEL_REPORTS_PATH = EXCEL_REPORTS_FOLDER + File.separator + REPORT_NAME;

    public static void logExceptionInExcel(String methodName, String exceptionMessage) {
        Workbook workbook = null;
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        Sheet sheet = null;

        try {
            // Create the directory if it doesn't exist
            File reportDir = new File(EXCEL_REPORTS_FOLDER);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            File excelFile = new File(EXCEL_REPORTS_PATH);

            if (excelFile.exists()) {
                // If the file exists, open it
                inputStream = new FileInputStream(excelFile);
                workbook = new XSSFWorkbook(inputStream);
                sheet = workbook.getSheetAt(0);
                inputStream.close(); // Close the input stream after loading the workbook
            } else {
                // If the file doesn't exist, create a new workbook and sheet
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Exceptions");

                // Create the header row
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Step_Name");
                headerRow.createCell(1).setCellValue("Exception");
            }

            // Find the next available row
            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(rowCount + 1);  // Properly increment the row

            // Write the step name and exception to the new row
            row.createCell(0).setCellValue(methodName);
            row.createCell(1).setCellValue(exceptionMessage);

            // Write the changes back to the file
            outputStream = new FileOutputStream(excelFile);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

