package com.web.testContext;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.web.pageObjects.PageObjectManager;

import commonUtils.BaseClass;
import testResourceManager.WebDrivermanager;

public class TestContext {
	
	private PageObjectManager pageObjectManager;
	private WebDrivermanager webdrivermanager;
	private BaseClass baseClass;
	WebDriver driver;
	public HashMap<String,String> Hmap;
	
	public TestContext() throws Exception{
		webdrivermanager = new WebDrivermanager();
		Hmap = new HashMap<String,String>();
		this.driver = webdrivermanager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		baseClass = new BaseClass(driver);
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public WebDrivermanager getWebDriverManager() {
		return webdrivermanager;
	}

	public BaseClass getBaseClass() {
		return baseClass;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

}
