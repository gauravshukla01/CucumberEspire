package CommmonUtils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {

	private WebDriver driver;

	public BaseAction(WebDriver driver) {
		this.driver = driver;
		// sample comment

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

	public void retryMechanism(WebDriver driver, WebElement ele) {

		int maxAttempts = 4; // Maximum number of times you want to retry

		int attempt = 1;
		boolean elementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		while (attempt <= maxAttempts) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
				element.click(); // Click the element once it becomes clickable

				elementClickable = true; // Set the flag to indicate it was clicked

				break; // Break the loop since the action was successful

			} catch (Exception e) {
				// Not clickable, maybe retry?

				System.out.println("RETRY done " + attempt);
				attempt++; // Increment the attempt count

			}
		}

	}

	public void retryMechanismWithSendKeys(WebDriver driver, WebElement ele, String Key) {

		int maxAttempts = 3; // Maximum number of times you want to retry

		int attempt = 1;
		boolean elementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		while (attempt <= maxAttempts) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
				element.sendKeys(Key); // Click the element once it becomes clickable

				elementClickable = true; // Set the flag to indicate it was clicked

				break; // Break the loop since the action was successful

			} catch (Exception e) {
				// Not clickable, maybe retry?

				System.out.println("RETRY done " + attempt);
				attempt++; // Increment the attempt count

			}
		}

	}

	// method for table navigations amd text extraction
	// input to this method is the xpath of the table till the tbody part
	public String getTextFrmTableBody(String baseXpath, String searchItem, int colIndex) throws InterruptedException {
		String finalText = null;

		// two loops.. first one iterates the total number of rows and second iterates
		// the cols within a specific row
		List<WebElement> listEle = driver.findElements(By.xpath(baseXpath));

		// get the number of cols
		Thread.sleep(3000);
		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));

		// iterate the rows of the table

		for (int i = 0; i < listEle.size(); i++) { // iterate the cols of the table
			for (int j = 1; j <= listCols.size(); j++) {
				int k = i + 1;
				WebElement test = listEle.get(i).findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + j + "]"));

				if (searchItem.equalsIgnoreCase(test.getText())) {
					WebElement targeEle = listEle.get(i)
							.findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + colIndex + "]"));
					finalText = targeEle.getText();
				} // end of if

			} // end of j loop

		} // end of for loop

		return finalText;
	}

	public String handleWebTable(String baseXpath, String searchItem, int colIndex, String actionRequired)
			throws InterruptedException {
		String finalText = null;
		WebElement test;
		// two loops.. first one iterates the total number of rows and second iterates
		// the cols within a specific row
		List<WebElement> listEle = driver.findElements(By.xpath(baseXpath));
		// get the number of cols
		Thread.sleep(3000);
		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));
		// iterate the rows of the table
		for (int i = 0; i < listEle.size(); i++) { // iterate the cols of the table
			for (int j = 1; j <= listCols.size(); j++) {
				int k = i + 1;
				try {
					test = listEle.get(i).findElement(By.xpath(baseXpath + "[" + k + "]" + "/td[" + j + "]"));
				} catch (org.openqa.selenium.NoSuchElementException e) {
					e.printStackTrace();
					break;
				}
				// WebElement test =
				// listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+j+"]"));

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

				} // end of if
			} // end of j loop

		} // end of for loop

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
				Thread.sleep(3000); // Consider replacing this with WebDriverWait for better synchronization
				List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));

				// Iterate over rows
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
							WebElement targetEle = listEle.get(i)
									.findElement(By.xpath(baseXpath + "[" + k + "]/td[" + colIndex + "]"));

							if (actionRequired.equalsIgnoreCase("getRowNum")) {
								rowNum = k;
								elementFound = true;
								return rowNum;
							}
						} // end of if
					} // end of inner loop
				} // end of outer loop

				elementFound = true; // Exit loop if no exceptions and iterations complete

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

}
