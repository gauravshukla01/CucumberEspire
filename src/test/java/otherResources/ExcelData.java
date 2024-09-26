package otherResources;

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



	public String getUserName(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		
		  projectPath = System.getProperty("user.dir");
		   filePath = projectPath + "//src//test//resources//Excel_Data//Epro.xlsx";
		    
		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String UserName = testData.get(rowNumber).get("UserName");

		return UserName;
	}



	public String getPassword(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Password = testData.get(rowNumber).get("Password");

		return Password;
	}



	public String getcampaign_Title(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String campaign_Title = testData.get(rowNumber).get("campaign_Title");

		return campaign_Title;
	}



	public String getCustomer_campaign_reference(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Customer_campaign_reference = testData.get(rowNumber).get("Customer_campaign_reference");

		return Customer_campaign_reference;
	}



	public String getVAT(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String VAT = testData.get(rowNumber).get("VAT");

		return VAT;
	}



	public String getPurchase_Order_number(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Purchase_Order_number = testData.get(rowNumber).get("Purchase_Order_number");

		return Purchase_Order_number;
	}



	public String getPurchase_Order_value(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Purchase_Order_value = testData.get(rowNumber).get("Purchase_Order_value");

		return Purchase_Order_value;
	}


	public String getNumber_of_items(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Number_of_items = testData.get(rowNumber).get("Number_of_items");

		return Number_of_items;
	}



	public String getQuantity(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Quantity = testData.get(rowNumber).get("Quantity");

		return Quantity;
	}


	public String getSupplier(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Supplier = testData.get(rowNumber).get("Supplier");

		return Supplier;
	}



	public String getEstimate_Reference_number(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Estimate_Reference_number = testData.get(rowNumber).get("Estimate_Reference_number");

		return Estimate_Reference_number;
	}



	public String getDelivery(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Delivery = testData.get(rowNumber).get("Delivery");

		return Delivery;
	}



	public String getPaper_cost(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Paper_cost = testData.get(rowNumber).get("Paper_cost");

		return Paper_cost;
	}




	public String getProduction_cost(int rowNumber,String Sheetname) throws InvalidFormatException, IOException {

		List<Map<String,String>> testData = 
				reader.getData(filePath,Sheetname);

		String Production_cost = testData.get(rowNumber).get("Production_cost");

		return Production_cost;
	}


}
