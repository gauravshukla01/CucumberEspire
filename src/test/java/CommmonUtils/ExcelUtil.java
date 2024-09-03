package CommmonUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {

    private static final String FILE_PATH = "/FailedSteps.xlsx";

    public static void logExceptionInExcel(String methodName, String exceptionMessage) {
        try (Workbook workbook = new XSSFWorkbook(); 
        		FileOutputStream outputStream = new FileOutputStream(FILE_PATH)) 
        {
            Sheet sheet = workbook.createSheet("Exceptions");

                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Step_Name");
                headerRow.createCell(1).setCellValue("Exception");

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(methodName);
            row.createCell(1).setCellValue(exceptionMessage);

            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
