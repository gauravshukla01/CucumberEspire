package TestResourceManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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

	public WebDriver getDriver() throws MalformedURLException {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws MalformedURLException {
		switch (environmentType) {	    
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() throws MalformedURLException {
		  ChromeOptions options = new ChromeOptions();
		    
		    // Optional: Add arguments if needed
		     options.addArguments("--headless"); // Uncomment if you need headless mode

		    // Define the URL of the Selenium Grid hub
		    URL hubUrl = new URL("http://localhost:4444/wd/hub");

		    // Create a RemoteWebDriver instance pointing to the hub with ChromeOptions
		    WebDriver driver = new RemoteWebDriver(hubUrl, options);

		    return driver;
	}

	@SuppressWarnings("deprecation")
	private WebDriver createLocalDriver() {
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
			//			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			//            chromeOptions.addArguments("--headless");
			String projectPath = System.getProperty("user.dir");
			String downloadFilePath = projectPath+"\\src\\test\\resources\\Downloads";
			 Map<String, Object> prefs = new HashMap<>();
		        prefs.put("download.default_directory", downloadFilePath); 
		        prefs.put("download.prompt_for_download", false); 
		        prefs.put("safebrowsing.enabled", true); 

		        chromeOptions.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(chromeOptions);
			configReader.getApplicationUrl();
			//            chromeOptions.setHeadless(true);
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
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
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
