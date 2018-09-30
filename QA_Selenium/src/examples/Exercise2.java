package examples;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2 {

WebDriver driver;
	
	@BeforeMethod
	void setUpMethod() { // 1 time
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	void login() {
		//step 1 - open sign in page
		driver.get("https://artsandculture.google.com/");
		driver.findElement(By.linkText("SIGN IN")).click();
		
		//step 2 - check that new tab is open and navigate to it
		Set<String> tabs = driver.getWindowHandles();
		for(String t : tabs) {
			driver.switchTo().window(t);
			if (driver.getTitle().equals("Sign in - Google Accounts")) {
				break;
			}
		}
		
		//step 3 - enter password and hit next
		driver.findElement(By.name("password")).sendKeys("77gunter8828");;
		//wait till passwordNext is clickable
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("passwordNext")));
		
		driver.findElement(By.name("passwordNext")).click();
		
		//step 4- after signed in - verify user image
		Assert.assertTrue(driver.findElement(By.xpath("//img[@title='Profile']")).isDisplayed());
		
	}
}
