package pageObjects;

import java.util.concurrent.TimeUnit;

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

public class SalesInvoicePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private BaseAction ba;
	SalesOrderPage salesorderpage;

	@FindBy(xpath = ("//*[text()='Supporting Documents']"))
	private WebElement supportdoc;

	@FindBy(xpath = ("//*[text()=' Sales Invoices']"))
	private WebElement salesinvoice;

	@FindBy(xpath = "//*[text()='Check Client PO or Acceptance of Quote ']")
	private WebElement FirstCheckBox;

	@FindBy(xpath = "//*[text()='Check Proof of Delivery or Postal Docket ']")
	private WebElement SecondCheckBox;

	@FindBy(xpath = "//*[text()='Check Proof of Delivery or Postal Docket ']")
	private WebElement lastele;

	public WebElement getsupportdoc() {
		return supportdoc;
	}

	public WebElement getsalesinvoice() {
		return salesinvoice;
	}

	public WebElement getFirstCheckBox() {
		return FirstCheckBox;
	}

	public WebElement getSecondCheckBox() {
		return SecondCheckBox;
	}

	public WebElement getlastele() {
		return lastele;
	}

	public SalesInvoicePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		this.salesorderpage = new SalesOrderPage(driver);
		PageFactory.initElements(driver, this);

	}

	public String getCampIdDraftInvoiced(String status) throws InterruptedException {
		// validating status as PO receipted
		String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", status, 2, "getText");
		System.out.println("campaign_ID = " + campaign_ID);

		return campaign_ID;
	}

	public String getPDFPOname() throws InterruptedException {
		// click on supporting docs link
		ba.retryMechanism(driver, getsupportdoc());

		// get the pdf PO name from table

		String pdfName = null;
		for (int i = 0; i < 3; i++) {
			try {
				pdfName = ba.handleWebTable("//*[@role='table']/tbody/tr", "Draft Invoice", 2, "getText");
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		} // end of for loop

		// ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
		String[] act = pdfName.split("_");
		System.out.println("split pdf name = " + act[0]);
		return act[0];

	}

	public void goToSaleInvoicePg() {
		// navigating to Finance

		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getfinance())).click();
		// click on Sales order
		wait.until(ExpectedConditions.elementToBeClickable(getsalesinvoice())).click();
		// clear search
		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).clear();
		wait.until(ExpectedConditions.elementToBeClickable(salesorderpage.getsearch())).click();
	}

	public void clickOnInvoiceNo(String pdfname) throws InterruptedException {
		// click on invoice number
		for (int i = 0; i < 3; i++) {
			try {
				ba.handleWebTable("//*[@role='table']/tbody/tr", pdfname, 2, "clickItem"); // hard coded value
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}

		} // end of for loop

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void clickOnCheckboxs(String indexId) throws InterruptedException {
		// scroll to element

		js.executeScript("arguments[0].scrollIntoView(true);", getlastele());

		// click on check box next to campaig id

		for (int i = 0; i < 3; i++) {
			try {
				ba.handleWebTable("//*[@role='table']/tbody/tr", indexId.trim(), 2, "clickItem");

				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}

		}

		// click on the check list check boxes

		ba.retryMechanism(driver, getFirstCheckBox());
		ba.retryMechanism(driver, getSecondCheckBox());

	}

}
