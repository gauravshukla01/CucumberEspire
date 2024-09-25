//package pageObjects;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import CommmonUtils.BaseClass;
//import stepDefinitions.Hooks;
//
//public class QuoteManagementPage {
//
//	private WebDriver driver;
//	private WebDriverWait wait;
//	private JavascriptExecutor js;
//	private BaseClass ba;
//
//	@FindBy(xpath = "//input[@placeholder='Search..']")
//	private WebElement ClearSearch;
//	@FindBy(xpath = "//div[contains(text(),'Quote Management')]")
//	private WebElement QuoteManagementTab;
//	@FindBy(xpath = "//*[@role='table']//tbody/tr")
//	private WebElement qQuoteManagementTableEntries;
//	@FindBy(xpath = "//div[@class='table-grid']//span[@class='mat-radio-container']")
//	private WebElement ClickRadioB;
//	@FindBy(xpath = "//button[normalize-space()='Accept Selected']")
//	private WebElement acceptQuote;
//	@FindBy(xpath = "//*[text()='Accept Quote']")
//	private WebElement finalAccept;
//
//	public WebElement getClearSearch() {
//		return ClearSearch;
//	}
//
//	public WebElement getquote1(int j) {
//		return driver.findElement(By.xpath("//*[@role='table']//tbody/tr[" + j + "]//a[@class='btn bg-orange']"));
//	}
//
//	public WebElement getClickRadioB() {
//		return ClickRadioB;
//	}
//
//	public WebElement getQuoteManagementTab() {
//		return QuoteManagementTab;
//	}
//
//	public WebElement getacceptQuote() {
//		return acceptQuote;
//	}
//
//	public WebElement getfinalAccept() {
//		return finalAccept;
//	}
// 
//	private static final Logger logger = LogManager.getLogger(QuoteManagementPage.class);
//	public QuoteManagementPage(WebDriver driver) {
//		this.driver = driver;
//		this.js = (JavascriptExecutor) driver;
//		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//		ba = new BaseClass(driver);
//		PageFactory.initElements(driver, this);
//
//	}
//
//	public void verifyQuote() throws InterruptedException {
//
//		// Click on Quote Management
//
//		wait.until(ExpectedConditions.elementToBeClickable(getClearSearch())).clear();
//
//		ba.retryMechanism(driver, wait.until(ExpectedConditions.elementToBeClickable(getQuoteManagementTab())));
//
//		// click on 1st quote
//
//		List<WebElement> quoteTableEntries = driver.findElements(By.xpath("//*[@role='table']//tbody/tr"));
//
//		System.out.println("quote table rows =" + quoteTableEntries.size());
//		int j = quoteTableEntries.size();
//
//		// WebElement quote1
//
//		ba.retryMechanism(driver, getquote1(j));
//
//		// click on radio button to select the quote and accept
//
//		js.executeScript("arguments[0].scrollIntoView();", ClickRadioB);
//		ba.retryMechanism(driver, getClickRadioB());
//
//		// WebElement acceptQuote
//
//		ba.retryMechanism(driver, getacceptQuote());
//		logger.info("Quote verified and selected");
//
//	}
//
//	public void acceptQuote() {
//
//		// click on final accept
//		ba.retryMechanism(driver, getfinalAccept());
//		logger.info("Quote Finally Accepted");
//
//	}
//
//	public void validateAcceptQuotePopup() {
//
//		ba.validatePopUp("Campaign Quote has been modified successfully.",
//				"Quote Accepted Popup validated successfully.");
//	}
//}