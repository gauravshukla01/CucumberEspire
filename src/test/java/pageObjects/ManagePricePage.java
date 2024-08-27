package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePricePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	public ManagePricePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	
	
	}

}
