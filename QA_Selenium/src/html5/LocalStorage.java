package html5;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalStorage {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5storage.html");
	}

	@Test
	public void testLocalStorage() throws Exception {
		
		String lastName;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Get the current value of localStorage.lastname, should be Smith
		lastName = (String) js.executeScript("return localStorage.lastname;");
		
		assertEquals(lastName, "Smith");
		
		js.executeScript("localStorage.lastname = 'Dustin';");
		
		lastName = (String) js.executeScript("return localStorage.lastname;");

		assertEquals(lastName, "Dustin");

	}
		
		
		@AfterTest
		public void close() {
			driver.quit();

		}

}
