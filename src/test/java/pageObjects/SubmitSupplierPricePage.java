//package pageObjects;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import CommmonUtils.BaseClass;
//
//public class SubmitSupplierPricePage {
//	
//	
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public JavascriptExecutor js;
//	public BaseClass ba;
//	
//	
//	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
//	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");
//
//	public SubmitSupplierPricePage(WebDriver driver) {
//		this.driver = driver;
//		this.js = (JavascriptExecutor) driver;
//		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
//		ba = new BaseClass(driver);
//	
//		
//	}
//
//
//
//	private static final Logger logger = LogManager.getLogger(SubmitSupplierPricePage.class);
//	
//	public void addSupplierPriceDetails(String Supplier,String Estimate_ref_num, String delivery,String Paper_cost, String Production_cost) throws InterruptedException {
//	
//				// Select Paragon Dagenham from searchbox
//
//				WebElement ClickSearchBox = driver.findElement(By.xpath("//*[@id='SsupplierId']"));
//				// js.executeScript("arguments[0].scrollIntoView();", ClickSearchBox);
//				ba.retryMechanism(driver, ClickSearchBox);
//				WebElement Search = driver.findElement(By.xpath(
//						"//input[@class='mat-input-element mat-form-field-autofill-control mat-select-search-input cdk-text-field-autofill-monitored']"));
//
//				ba.retryMechanismWithSendKeys(driver, Search, "Paragon");
//				Thread.sleep(3000);
//				//WebElement selectDagenham = driver.findElement(By.xpath("//span[contains(text(),'Paragon CC (Dagenham)')]"));
//				// js.executeScript("arguments[0].scrollIntoView();", selectDagenham);
//				// ba.retryMechanismWithSendKeys(driver, ClickSearchBox, "paragon CC
//				// (Dagenham)");
//				ba.retryMechanism(driver, wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+Supplier+"')]"))));
//
//				// //enter estimate ref no
//				Thread.sleep(2000);
//				WebElement enterEstimateRefNo = driver.findElement(By.xpath("//input[@id='f']"));
//				ba.retryMechanismWithSendKeys(driver, enterEstimateRefNo, Estimate_ref_num);
//
//				Thread.sleep(2000);
//
//				WebElement deliveryCost = driver.findElement(By.xpath("(//input[@id='qt'])[1]"));
//				ba.retryMechanismWithSendKeys(driver, deliveryCost, delivery);
//
//				Thread.sleep(2000);
//				WebElement PaperCost = driver.findElement(By.xpath("(//input[@id='qt'])[2]"));
//				// js.executeScript("arguments[0].scrollIntoView();", PaperCost);
//				ba.retryMechanismWithSendKeys(driver, PaperCost, Paper_cost);
//
//				Thread.sleep(2000);
//				WebElement production = driver.findElement(By.xpath("(//input[@id='qt'])[3]"));
//				// js.executeScript("arguments[0].scrollIntoView();", production);
//				ba.retryMechanismWithSendKeys(driver, production, Production_cost);
//
//				Thread.sleep(2000);
//				WebElement submitcostPrice = driver.findElement(By.xpath("//button[@type='submit']"));
//				
//				logger.info("Supplier details entered");
//				
//				js.executeScript("arguments[0].scrollIntoView();", submitcostPrice);
//				ba.retryMechanism(driver, submitcostPrice);
//				
//				logger.info("Supplier details submitted");
//
//			
//
//		
//	}
//
//
//
//
//
//	public void validateSubmitSupplierCostPopup() {
//		ba.validatePopUp("Campaign Item Supplier Cost Price has been created successfully.", "Submit Supplier Cost popup validated successfully.");
//		
//	}	
//	
//	
//}
