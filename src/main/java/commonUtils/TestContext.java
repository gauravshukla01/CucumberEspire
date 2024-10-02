//package CommmonUtils;
//
//import java.util.HashMap;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import TestResourceManager.WebDrivermanager;
//import pageObjects.*;
//
//public class TestContext {
//
//
//	private PageObjectManager pageObjectManager;
//	private WebDrivermanager webdrivermanager;
//	private BaseClass baseaction;
//	WebDriver driver;
//	public HashMap<String,String> Hmap;
//
//	public TestContext(){
//		webdrivermanager = new WebDrivermanager();
//		//driver = new ChromeDriver();
//		Hmap = new HashMap<String,String>();
//		pageObjectManager = new PageObjectManager(webdrivermanager.getDriver());
//		//pageObjectManager = new PageObjectManager(driver);
//	}
//
//
//	public PageObjectManager getPageObjectManager() {
//		return pageObjectManager;
//	}
//
//	public WebDrivermanager getWebDriverManager() {
//		return webdrivermanager;
//	}
//
//	public BaseClass getBaseAction() {
//		return baseaction;
//	}
//	
//	public WebDriver getWebDriver() {
//		return driver;
//	}
//}
package commonUtils;


