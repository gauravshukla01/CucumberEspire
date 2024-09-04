package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommmonUtils.ExcelUtil;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleStepDefinition {
	ChromeOptions chromeOptions;
	WebDriver driver;
	@Given("User launches {string}")
	public void user_launches(String string) {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		WebDriverManager.chromedriver().setup();
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.get(string);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
		
	}

	@When("User Click on Search Box")
	public void user_click_on_search_box() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
     driver.findElement(By.xpath("//*[@id='APjFqb1']")).click();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			System.out.println("In google catch block");
//			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("user should get land")
	public void user_should_get_land() {

		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		System.out.println("We will get No such Element Exception");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Given("User launches the facebook page {string}")
	public void user_launches_the_facebook_page(String string) {

		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		WebDriverManager.chromedriver().setup();
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.get(string);
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@When("User Click on email box")
	public void user_click_on_email_box() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		driver.findElement(By.xpath("//*[@id='email1']")).sendKeys("Nitin");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			System.out.println("In Facebook catch block");
//			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("user should get land on create button")
	public void user_should_get_land_on_create_button() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		System.out.println("We will get No such Element Exception");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

}
