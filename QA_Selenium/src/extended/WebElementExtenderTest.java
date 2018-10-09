package extended;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementExtenderTest {

	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void webTableTest() throws InterruptedException{

		driver.get("http://cookbook.seleniumacademy.com/Locators.html");

		
		try {
			WebElement table = driver.findElement(By.cssSelector("div.cart-info table"));
			
			WebElementExtender.highlightElement(table);
			
			Thread.sleep(5000);

			WebElementExtender.setAttribute(table, "id", "myID");	
	
			Thread.sleep(5000);
		} catch (Error e) {
			e.printStackTrace();
		}

	}
	
	@Test 
	public void testElementScreenshot() {
		
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");
		
		WebElement tableUser = driver.findElement(By.id("users"));
		
		try {
			FileUtils.copyFile(WebElementExtender.captureElementBitmap(tableUser), new File("C:\\tmp\\tableUser.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void close() {
		driver.close();
	}	
			

	
}
