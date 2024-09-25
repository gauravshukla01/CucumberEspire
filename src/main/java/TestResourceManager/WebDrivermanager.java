package TestResourceManager;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivermanager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	

	public WebDrivermanager() {
		
	}

	public WebDriver getDriver() {
		
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		
		if(driver == null) {
			switch (driverType) {	
			
			case FIREFOX : 

				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions()
						.setAcceptInsecureCerts(true)
						.addPreference("browser.helperApps.alwaysAsk.force", false)
						.addPreference("dom.webnotifications.enabled", false)
						.addPreference("geo.enabled", false)
						.addPreference("geo.provider.use_corelocation", false)
						.addPreference("geo.prompt.testing", false)
						.addPreference("geo.prompt.testing.allow", false);
				
				driver = new FirefoxDriver(firefoxOptions);
				break;
				
			case CHROME : 
				
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.addArguments("--test-type--");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				String projectPath = System.getProperty("user.dir");
				String downloadFilePath = projectPath+"\\src\\test\\resources\\Downloads";
				 Map<String, Object> prefs = new HashMap<>();
			        prefs.put("download.default_directory", downloadFilePath); 
			        prefs.put("download.prompt_for_download", false); 
			        prefs.put("safebrowsing.enabled", true); 

			    chromeOptions.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(chromeOptions);
				break;
				
			case EDGE : 

				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(edgeOptions);
				break;
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();		
			//driver.get(appUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		}
		return driver;
	}

}