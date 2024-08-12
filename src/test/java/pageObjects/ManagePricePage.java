package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePricePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	private final By element1 = By.xpath("//span[normalize-space()='PCC UK Lead Supply']");
	private final By element2 = By.xpath("//*[@id='mat-select-value-15']");

	public ManagePricePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	
	
	}

}
