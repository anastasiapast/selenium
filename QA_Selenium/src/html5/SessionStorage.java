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

public class SessionStorage {
	
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
		WebElement clickButton = driver.findElement(By.id("click"));
		WebElement clicksField = driver.findElement(By.id("clicks"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Get current value of sessionStorage.clickcount, should be null
		String clickCount = (String) jsExecutor
				.executeScript("return sessionStorage.clickcount;");
		assertEquals(null, clickCount);
		assertEquals("0", clicksField.getAttribute("value"));

		// Click the Button, this will increase the sessionStorage.clickcount
		// value by 1
		clickButton.click();

		// Get current value of sessionStorage.clickcount, should be 1
		clickCount = (String) jsExecutor
				.executeScript("return sessionStorage.clickcount;");
		assertEquals("1", clickCount);
		assertEquals("1", clicksField.getAttribute("value"));

	}
		
		
		@AfterTest
		public void close() {
			driver.quit();

		}

}