package otherResources;

import CommmonUtils.BaseAction;
import TestResourceManager.PageObjectManager;
import TestResourceManager.WebDrivermanager;

public class TestContext {


	private PageObjectManager pageObjectManager;
	private WebDrivermanager webdrivermanager;
	private BaseAction baseaction;

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

	public BaseAction getBaseAction() {
		return baseaction;
	}
}
