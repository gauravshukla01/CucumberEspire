package commonUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelData {

	ExcelReader reader;
	private String projectPath;
    private String filePath;
    
	public ExcelData() {

		reader = new ExcelReader();

	}

	public String getDataFromExcel(String excelName,String sheetName,int rowNumber,String columnName) throws InvalidFormatException, IOException {
	
		  projectPath = System.getProperty("user.dir");
		  filePath = projectPath + "/src/test/resources/Excel_Data/"+excelName;
		    
		  List<Map<String,String>> testData = reader.getData(filePath,sheetName);

		  @SuppressWarnings("unlikely-arg-type")
		  String value = testData.get(rowNumber).get(columnName);

		  return value;
	}

}
