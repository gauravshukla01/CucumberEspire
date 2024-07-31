package CommmonUtils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseAction {
	
	private WebDriver driver;
	 
    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }
 
    public boolean safeClick(By by, long timeout, long pollingInterval) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(pollingInterval))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class)
                    .ignoring(ElementClickInterceptedException.class);
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

}
