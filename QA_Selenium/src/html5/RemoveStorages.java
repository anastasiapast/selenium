package html5;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveStorages {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5storage.html");
	}

	@Test
	public void testSessionStorage() throws Exception {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Remove a specific key
		jsExecutor.executeScript("localStorage.removeItem(lastname);");

		//For Session storage
		jsExecutor.executeScript("sessionStorage.removeItem(lastname);");

		// Clear all items
		jsExecutor.executeScript("localStorage.clear();");
		
		//For Session storage
		jsExecutor.executeScript("sessionStorage.clear();");
	}
		
		
		@AfterTest
		public void close() {
			//driver.quit();

		}

}

