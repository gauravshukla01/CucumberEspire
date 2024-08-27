package pageObjects;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import CommmonUtils.BaseAction;
 
public class POManagementPage {
 
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private BaseAction ba;
	
	@FindBy(xpath="//*[@id='mat-tab-label-2-2']")
	private WebElement Supporting_docs;
	@FindBy(xpath="//li/a/img[@src='assets/images/finance-module.svg']")
	private WebElement FinancePg;
	@FindBy(xpath="//a[text()=' PO Management']")
	private WebElement PO_Management;
	@FindBy(xpath="//input[@placeholder='Search..']")
	private WebElement Search;
	@FindBy(xpath="//*[@id='supportingDocumentFileUpload']")
	private WebElement UploadDoc;
	@FindBy(xpath="//*[@id='supportingDocumentDescription']")
	private WebElement supportingDocDesc;
	@FindBy(xpath="(//*[@role='combobox'])[2]")
	private WebElement combobox_2;
	@FindBy(xpath="//span[text()=' Proof Of Delivery']")
	private WebElement Pod_option;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save_btn;
	@FindBy(xpath="//*[@class='mat-tab-header']//div[text()='Receipt']")
	private WebElement Receipt_Tab;
	@FindBy(xpath="//button/span[text()='Close']")
	private WebElement close_Btn;
	
	
	public WebElement getSupporting_docs() {
		return Supporting_docs;
	}
		
	public WebElement getFinancePg() {
		return FinancePg;
	}
	
	public WebElement getPO_Management() {
		return PO_Management;
	}
	
	public WebElement getSearch() {
		return Search;
	}
	
	public WebElement getUploadDoc() {
		return UploadDoc;
	}
	
	public WebElement getsupportingDocDesc() {
		return supportingDocDesc;
	}
	
	public WebElement getcombobox_2() {
		return combobox_2;
	}
	
	public WebElement getPod_option() {
		return Pod_option;
	}
	
	public WebElement getsave_btn() {
		return save_btn;
	}
	
	public WebElement getReceipt_Tab() {
		return Receipt_Tab;
	}
 
	public WebElement getreceipt_Btn(int rowNum) {
		return driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr[" + rowNum
				+ "]/td/button[@id='receiptButton']"));
	}
	
	
	public WebElement getattach_user_guide(int rowNum1) {
		return driver.findElement(By.xpath("//*[@role='table']/tbody/tr[" + rowNum1
				+ "]/td/button//img[@src='assets/images/attach_user_guide.svg']"));
	}
	
	public WebElement geclose_Btn() {
		return close_Btn;
	}
	
	public POManagementPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
	}
 
	public void goToFinance() throws InterruptedException {
		// click on supporting docs link
		String pdfName = null;
		String[] act;
 
		ba.retryMechanism(driver, getSupporting_docs());
 
		// get the pdf PO name from table
		// ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
		for (int i = 0; i < 3; i++) {
			try {
				pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr", "Purchase Order", 2, "getText"); 
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			} 
		} // end of for loop
		
		act = pdfName.split("_");
		
		//Go to PO Management Page
		// click on finance
		wait.until(ExpectedConditions.elementToBeClickable(getFinancePg())).click();
		// click on PO Management
		wait.until(ExpectedConditions.elementToBeClickable(getPO_Management())).click();
		
        //Search for pdf PO name and click
		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).clear();
 
		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).sendKeys(act[0]);
 
		wait.until(ExpectedConditions.elementToBeClickable(getSearch())).click();
 
		for (int i = 0; i < 3; i++) {
			try {
				ba.handleWebTable("//*[@role='table']/tbody/tr", act[0], 1, "clickItem");
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		} // end of for loop
	}
 
	public void uploadPOD(String indexID) throws InterruptedException {

        String user_dir = System.getProperty("user.dir");
        
        //get the required row no
		int rowNum1 = ba.getMatchRowNum("//*[@role='table']/tbody/tr", indexID, 2, "getRowNum");
		
		//click to upload the file
		wait.until(ExpectedConditions.elementToBeClickable(getattach_user_guide(rowNum1))).click();
		
		// select the file to be uploaded send keys to below weblement
		getUploadDoc().sendKeys(user_dir+"\\src\\test\\resources\\Upload_Files\\ePO000967-LEADGB_V1.pdf");
		
		// enter comments inthe text area
		getsupportingDocDesc().sendKeys("Coments");
		
		ba.retryMechanism(driver, getcombobox_2());
 
		// select pod option
		ba.retryMechanism(driver, getPod_option());
 
		// click the save button
		ba.retryMechanism(driver, getsave_btn());
 
	}
 
	public void validateReciept(String indexID) throws InterruptedException {
		// click on Receipt tab
		ba.retryMechanism(driver, getReceipt_Tab());
 
		// select the checkbox on receipt tab
		ba.handleWebTable("//*[@role='table']/tbody/tr", indexID, 2, "clickItem"); // hard coded value
 
		// click the receipt action
		
		int rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", indexID, 2, "getRowNum");
		
		ba.retryMechanism(driver, getreceipt_Btn(rowNum));
		
		// click on Close button on the popup
		ba.retryMechanism(driver, geclose_Btn());
 
		// Scenario -2 completed
 
	}
}

