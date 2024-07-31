package otherResources;

import TestResourceManager.PageObjectManager;
import TestResourceManager.WebDrivermanager;

public class TestContext {


	private PageObjectManager pageObjectManager;
	private WebDrivermanager webdrivermanager;


	public TestContext(){
		webdrivermanager = new WebDrivermanager();
		pageObjectManager = new PageObjectManager(webdrivermanager.getDriver());
	}


	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public WebDrivermanager getWebDriverManager() {
		return webdrivermanager;
	}

}
