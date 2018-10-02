package apitests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckActions {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	//Selecting multiple rows in a table
	@Test
	public void checkText() {
		
		driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-To-Enable-Multi-Rows-Selection-On-Table-Row-Selector/");
		
		//Selec all table rows
		List <WebElement> tableRows = driver.findElements(By.xpath("//table[@id='user-table']/tbody/tr"));
		
		//Select 2 and 4 row from table using Ctrl
		//Row Index start at 0
		Actions builder = new Actions(driver);
		builder.click(tableRows.get(1))
				.keyDown(Keys.CONTROL)
				.click(tableRows.get(3))
				.keyUp(Keys.CONTROL)
				.build().perform();
		
		//Verify Selected Row table shows two rows selected
		List<WebElement> rows = driver.findElements(By.className("selected"));
		System.out.println("Selected row count: " + rows.size());
		assertEquals(2, rows.size());
				
				
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	

}
