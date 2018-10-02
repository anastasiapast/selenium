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

public class CheckDragDrop {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkText() {
		
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		
		try
		{
			assertEquals(target.getText(), "You did great!");
		} catch (Error e) {
			e.printStackTrace();
		}

	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
