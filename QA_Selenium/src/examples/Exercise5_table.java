package examples;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise5_table {

	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void testTable() {
		driver.get("https://developer.mozilla.org/ru/docs/Learn/HTML/Tables/Basics");
				
		WebElement simpleTable = driver.findElement(By.className("learn-box"));
		
		//Get all rows
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		Assert.assertEquals(2, rows.size());
		
		//Print data from each row
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText() + "\t");
			}
			System.out.println();
		}		
	}

	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
