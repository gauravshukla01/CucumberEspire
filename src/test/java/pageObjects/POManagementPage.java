package pageObjects;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import CommmonUtils.BaseAction;
 
public class POManagementPage {
 
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private BaseAction ba;
	private int rowNum;
 
	public POManagementPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
	}
 
	public void goToFinance() throws InterruptedException {
		// click on supporting docs link
		String pdfName = null;
		String[] act;
 
		ba.retryMechanism(driver, driver.findElement(By.xpath("//*[@id='mat-tab-label-2-2']")));
 
		// ba.retryMechanism(driver, supportdoc);
		// get the pdf PO name from table
 
		for (int i = 0; i < 3; i++) {
			try {
				pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr", "Purchase Order", 2, "getText");// hard coded
																											// value
 
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
 
		} // end of for loop
		act = pdfName.split("_");
		System.out.println("split pdf name = " + act[0]);
		// ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
 
		// hover to select finance
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
		// click on finance
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Finance ']"))).click();
		// click on PO Management
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' PO Management']"))).click();
		
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']")))
				.sendKeys(act[0]);
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
 
		for (int i = 0; i < 3; i++) {
			try {
				ba.handleWebTable("//*[@role='table']/tbody/tr", act[0], 1, "clickItem"); // hard coded value
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
 
		} // end of for loop
	}
 
	public void uploadPOD(String indexID) throws InterruptedException {
		// code to be analysed

        String user_dir = System.getProperty("user.dir");
		int rowNum1 = ba.getMatchRowNum("//*[@role='table']/tbody/tr", indexID, 2, "getRowNum");
		System.out.println("rownum 2 in PO section =" + rowNum1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='table']/tbody/tr[" + rowNum1
				+ "]/td/button//img[@src='assets/images/attach_user_guide.svg']"))).click();
		Thread.sleep(3000);
		// select the file to be uploaded send keys to below weblement
		
		driver.findElement(By.xpath("//*[@id='supportingDocumentFileUpload']"))
				.sendKeys(user_dir+"\\src\\test\\resources\\Upload_Files\\ePO000967-LEADGB_V1.pdf");
		// enter comments inthe text area
		driver.findElement(By.xpath("//*[@id='supportingDocumentDescription']")).sendKeys("Coments");
		ba.retryMechanism(driver, driver.findElement(By.xpath("(//*[@role='combobox'])[2]")));
 
		// select pod option
		ba.retryMechanism(driver, driver.findElement(By.xpath("//span[text()=' Proof Of Delivery']")));
 
		// click the save button
		ba.retryMechanism(driver, driver.findElement(By.xpath("//button[@type='submit']")));
 
	}
	
	public void download () {
		
		WebElement ele1 =driver.findElement(By.xpath("//div[contains(text(),'Supporting Documents')]"));
		ba.retryMechanism(driver, ele1);
		WebElement ele2 =driver.findElement(By.xpath(" //tbody/tr[1]/td[6]/button[1]/span[1]/img[1]"));
		ba.retryMechanism(driver, ele2);
		
	}
 
	public void validateReciept(String indexID) throws InterruptedException {
		// click on Receipt tab
		ba.retryMechanism(driver, driver.findElement(By.xpath("//*[@class='mat-tab-header']//div[text()='Receipt']")));
 
		// select the checkbox on receipt tab
		ba.handleWebTable("//*[@role='table']/tbody/tr", indexID, 2, "clickItem"); // hard coded value
 
		// click the receipt action
		ba.handleWebTable("//*[@role='table']/tbody/tr", indexID, 14, "clickItem"); // hard coded value
 
		// click on Close button on the popup
		ba.retryMechanism(driver, driver.findElement(By.xpath("//button/span[text()='Close']")));
 
		// get data from table
 
		// Scenario -2 completed
 
	}
}

