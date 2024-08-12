package otherResources;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommmonUtils.BaseAction;
import TestResourceManager.PageObjectManager;
import TestResourceManager.WebDrivermanager;

public class TestContext {


	private PageObjectManager pageObjectManager;
	private WebDrivermanager webdrivermanager;
	private BaseAction baseaction;
	WebDriver driver;
	public HashMap<String,String> Hmap;

	public TestContext(){
		// webdrivermanager = new WebDrivermanager();
		driver = new ChromeDriver();
		Hmap = new HashMap<String,String>();
		//pageObjectManager = new PageObjectManager(webdrivermanager.getDriver());
		pageObjectManager = new PageObjectManager(driver);
	}


	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public WebDrivermanager getWebDriverManager() {
		return webdrivermanager;
	}

	public BaseAction getBaseAction() {
		return baseaction;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
