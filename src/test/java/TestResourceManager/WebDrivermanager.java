package TestResourceManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import otherResources.ConfigFileReader;

public class WebDrivermanager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private ChromeOptions chromeOptions;
	private ConfigFileReader configReader;
	
//	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
//	private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

	public WebDrivermanager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		configReader = FileReaderManager.getInstance().getConfigReader();
	}

	public WebDriver getDriver() throws Exception {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws Exception {
		switch (environmentType) {	    
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() throws Exception {
		
		chromeOptions = new ChromeOptions();
		
		driver = new ChromeDriver(chromeOptions);
		
		driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), chromeOptions);
		
//		configReader.getApplicationUrl();
		
		return driver;
	}

	private WebDriver createLocalDriver() throws Exception {
		switch (driverType) {	    
		case FIREFOX : 
			//			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//            firefoxOptions.addArguments("--headless");
			driver = new FirefoxDriver(firefoxOptions);
			//            firefoxOptions.setHeadless(true);
			break;
		case CHROME : 
			//			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
//						driver = new ChromeDriver();
//			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--remote-allow-origins=*");
//			            chromeOptions.addArguments("--headless");
//			            chromeOptions.setHeadless(true);
			driver = new ChromeDriver(chromeOptions);
			driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), chromeOptions);
			configReader.getApplicationUrl();
			
			break;
		case EDGE : 
			//			System.setProperty(EDGE_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			//			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			//            edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
			//            edgeOptions.setHeadless(true);
			break;
		}

		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance()
				.getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
//		driver.close();
//		driver.quit();
		
		  if (driver != null) {
	            driver.quit();
	        }
	}


}
