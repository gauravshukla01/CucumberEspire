package commonUtils;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestResourceManager.WebDrivermanager;
import io.cucumber.java.Scenario;

public class BaseClass {

    public static WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
    public BaseClass() {
    
		this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(5));

	}
	
    public void launchBrowser() throws Exception {
    	
    	driver= new WebDrivermanager().getDriver();
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }

	public boolean safeClick(By by, long timeout, long pollingInterval) {
		try {
			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofMillis(pollingInterval)).ignoring(NoSuchElementException.class)
					.ignoring(ElementNotInteractableException.class).ignoring(ElementClickInterceptedException.class);
			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});

			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				return true;
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Click intercepted by another element: " + by.toString());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable: " + by.toString());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		return false;
	}

	public static void uploadFile(WebDriver driver, WebElement fileInputElement, String filePath) {
		
		if (fileInputElement != null && fileInputElement.isDisplayed() && fileInputElement.isEnabled()) {
			fileInputElement.sendKeys(filePath);
		} else {
			throw new IllegalArgumentException("File input element is not displayed or not enabled.");
		}

	}

	public void clickOnElement(WebDriver driver, WebElement ele) {

			try {
				
				waitVisibilityOfElement(ele);
				waitElementToBeClickable(ele);
				ele.click();

			} catch (Exception e) {

				logger.warn("Failed to click on element");
				logger.error("Exception description : " + e.getMessage());

			}
		}

	public void sendKeys(WebDriver driver, WebElement ele, String keys) {

		try {
			
			wait.until(ExpectedConditions.visibilityOf(ele));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();
			ele.sendKeys(keys);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public String getTextFrmTableBody(String baseXpath, String searchItem, int colIndex) throws InterruptedException {
		String finalText = null;

		List<WebElement> listEle = driver.findElements(By.xpath(baseXpath));

		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));


		for (int i = 0; i < listEle.size(); i++) { 
			for (int j = 1; j <= listCols.size(); j++) {
				int k = i + 1;
				WebElement test = listEle.get(i).findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + j + "]"));

				if (searchItem.equalsIgnoreCase(test.getText())) {
					WebElement targeEle = listEle.get(i)
							.findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + colIndex + "]"));
					finalText = targeEle.getText();
				} 

			} 

		} 

		return finalText;
	}

	public String handleWebTable(String baseXpath, String searchItem, int colIndex, String actionRequired)
			throws InterruptedException {
		
		String finalText = null;
		WebElement test;

		List<WebElement> listEle = driver.findElements(By.xpath(baseXpath));

		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));

		for (int i = 0; i < listEle.size(); i++) { 
			for (int j = 1; j <= listCols.size(); j++) {
				int k = i + 1;
				try {
					test = listEle.get(i).findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + j + "]"));
				} catch (org.openqa.selenium.NoSuchElementException e) {
					e.printStackTrace();
					break;
				}

				if (searchItem.equalsIgnoreCase(test.getText())) {
					WebElement targeEle = listEle.get(i)
							.findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + colIndex + "]"));

					if (actionRequired.equalsIgnoreCase("getText")) {
						finalText = targeEle.getText();
						return finalText;

					}
					if (actionRequired.equalsIgnoreCase("clickItem")) {
						targeEle.click();
						finalText = "dummy";
						return finalText;
					}

				} 
			} 

		} 

		return finalText;
	}

	public int getMatchRowNum(String baseXpath, String searchItem, int colIndex, String actionRequired)
			throws InterruptedException {
		
		int rowNum = 0;
		WebElement test;
		int retryCount = 0;
		boolean elementFound = false;

		while (retryCount < 3 && !elementFound) {
			try {
				List<WebElement> listEle = driver.findElements(By.xpath(baseXpath));
				List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));

				for (int i = 0; i < listEle.size(); i++) {
					for (int j = 1; j <= listCols.size(); j++) {
						int k = i + 1;
						try {
							test = listEle.get(i).findElement(By.xpath(baseXpath + "[" + k + "]/td[" + j + "]"));
						} catch (org.openqa.selenium.NoSuchElementException e) {
							e.printStackTrace();
							break;
						}

						if (searchItem.equalsIgnoreCase(test.getText().trim())) {
							 listEle.get(i)
									.findElement(By.xpath(baseXpath + "[" + k + "]/td[" + colIndex + "]"));

							if (actionRequired.equalsIgnoreCase("getRowNum")) {
								rowNum = k;
								elementFound = true;
								return rowNum;
							}
						} 
					} 
				} 

				elementFound = true;

			} catch (StaleElementReferenceException e) {
				retryCount++;
				System.out.println("StaleElementReferenceException caught. Retrying... Attempt " + retryCount);
				Thread.sleep(2000); // Adding a delay before retry
			}
		}

		if (!elementFound) {
			throw new RuntimeException("Element not found due to StaleElementReferenceException after 3 retries");
		}

		return rowNum;
	}
	
	public void validatePopUp (String PopUpText,String ValidationMessage) {

		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".snackbar-text")));
		String popupText = popup.getText();
		try {
			Assert.assertEquals(PopUpText, popupText);       
			System.out.println(ValidationMessage);
		} 
		catch (AssertionError e) {	
			e.printStackTrace();
		}
	

}

	public void waitVisibilityOfElement(WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.info(" webElement not visible");
        }
    }
		
    public void waitElementToBeClickable(WebElement element) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.info(" webElement not visible");
        }
    }
    
    public void waitInvisibilityOfLoading() {
    	
        waitInSec(1);
        
        try {
                    
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[normalize-space()='Loading...'][@aria-hidden='false']")));
        } catch (Exception e) {
        	logger.info(" webElement state error");
        }

        waitInSec(1);
    }
    
    public void waitInSec(int secToWait) {
        int sec = secToWait * 1000;
        
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
    
    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void contextClick(WebElement element) {

        Actions uiActionsRoller = new Actions(driver);

        uiActionsRoller.moveToElement(element)
                .doubleClick(element)
                .build()
                .perform();
    }
    
    public void sendKeysByChar(WebElement element, String textString) {
        if (textString.length() > 0) {

            for (int i = 0; i < textString.length(); i++) {
                char textChar = textString.charAt(i);
                String convertChartoString = new StringBuilder().append(textChar).toString();
                element.sendKeys(convertChartoString);
                waitInSec(1);
            }
        }
    }
    
    public void acceptAlert() {
        try {

            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();

            alert.accept();
        } catch (Exception e) {
        	logger.warn("Failed to acceptt alert");
			logger.error("Exception description : " + e.getMessage());
        }
    }
    
    public void switchToiframe(String xpath){
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
    
    public static void saveScreenshotToFile(Scenario scenario) throws IOException {
        // Create a folder named "Failed_Screenshot" under the project directory if it doesn't exist
        Path screenshotDir = Paths.get("Failed_testcase_screenshots");
        if (!Files.exists(screenshotDir)) {
            Files.createDirectory(screenshotDir);
        }

        // Save the screenshot with a name that includes the scenario name and timestamp
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  //      String fileName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".jpg";
        String fileName = scenario.getName()+"FailedScreenshot" + System.currentTimeMillis() + ".jpg";
		
        File destinationFile = new File(screenshotDir.toFile(), fileName);
        FileUtils.copyFile(screenshot, destinationFile);
    }
}

