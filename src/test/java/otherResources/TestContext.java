package otherResources;

import TestResourceManager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestContext {


    private PageObjectManager pageObjectManager;


    public TestContext(){
        //webDriverManager = new WebDriverManager();
        WebDriver driver = new EdgeDriver();
        pageObjectManager = new PageObjectManager(driver);
    }


    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }


}
