//package pageObjects;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import CommmonUtils.BaseClass;
//
//public class EproHomePage {
//
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public JavascriptExecutor js;
//	public BaseClass ba;
//
//	
//	@FindBy(xpath = "//li/a/img[@src='assets/images/workflow.svg']")
//	private WebElement workflow;
//	@FindBy(xpath = "//a[normalize-space()='Campaigns']")
//	private WebElement clkCampaign;
//
//	
//	public WebElement getworkflow() {
//		return workflow;
//	}
//
//	public WebElement getclkCampaign() {
//		return clkCampaign;
//	}
//
//	public EproHomePage(WebDriver driver) {
//		this.driver = driver;
//		this.js = (JavascriptExecutor) driver;
//		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//		ba = new BaseClass(driver);
//		PageFactory.initElements(driver, this);
//	}
//
//	  private static final Logger logger = LogManager.getLogger(EproHomePage.class);
//	public void ClkCampaign() throws InterruptedException {
//
//		ba.retryMechanism(driver, getworkflow());
//
//		// click on campaign icon
//
//		ba.retryMechanism(driver, getclkCampaign());
//		logger.info("Clicked on Campaign");
//
//	}
//
//}
