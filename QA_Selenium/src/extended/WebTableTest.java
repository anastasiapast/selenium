package extended;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableTest {

	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");
	}
	
	@Test
	void webTableTest() throws InterruptedException{

		try {
			WebTable table = new WebTable(driver.findElement(By.cssSelector("div.cart-info table")));
			
			assertEquals(table.getRowCount(), 3);
			
			assertEquals(table.getColumnCount(), 5);
			
			assertEquals(table.getCellData(3, 1), "iPhone");
			
			
			WebElement cellEdit = table.getCellEditor(3, 3, 0);
			cellEdit.clear();
			cellEdit.sendKeys("2");
			Thread.sleep(5000);
		} catch (Error e) {
			e.printStackTrace();
		}

	}
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
