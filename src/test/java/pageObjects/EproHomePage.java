package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class EproHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;

	@FindBy(xpath = "//*[@id='sideNav']")
	private WebElement sideNAV;
	@FindBy(xpath = "//li/a/img[@src='assets/images/workflow.svg']")
	private WebElement workflow;
	@FindBy(xpath = "//a[normalize-space()='Campaigns']")
	private WebElement clkCampaign;

	public WebElement getsideNAV() {
		return sideNAV;
	}

	public WebElement getworkflow() {
		return workflow;
	}

	public WebElement getclkCampaign() {
		return clkCampaign;
	}

	public EproHomePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		ba = new BaseAction(driver);
		PageFactory.initElements(driver, this);
	}

	public void ClkCampaign() throws InterruptedException {

		// Webelement for side nav
		Thread.sleep(3000);

		ba.retryMechanism(driver, getworkflow());

		// click on campaign icon

		ba.retryMechanism(driver, getclkCampaign());
	}

}
