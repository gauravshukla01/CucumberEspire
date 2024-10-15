package com.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.BaseClass;

public class HomePage {
	
	public WebDriver driver;
	
	BaseClass baseClass;
	
	public HomePage(WebDriver webdriver)
	{
        this.driver = webdriver;
        
        baseClass = new BaseClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='user-display']")
	private WebElement textUserName;
	
	@FindBy(xpath="//div/i[@class='settings icon']")
	private WebElement iconSetting;
	
	@FindBy(xpath="//i[@class='power icon']")
	private WebElement iconLogOut;
	
	public String getUserName() {
		
		baseClass.waitVisibilityOfElement(textUserName);
		String userName = textUserName.getText().trim();
		return userName;
		
	}
	
	public void logOutFromApplication() {
		baseClass.clickOnElement(driver, iconSetting);
		baseClass.waitInSec(1);
		baseClass.clickOnElement(driver, iconLogOut);
		baseClass.waitInSec(2);
	}

}
