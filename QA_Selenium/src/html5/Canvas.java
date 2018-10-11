package html5;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extended.WebElementExtender;

public class Canvas {		
	WebDriver driver;
		
		
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
	}

	@Test
	public void testCanvas() throws Exception {
		
		//Get the HTML5 Video Element
		WebElement canvas = driver.findElement(By.id("imageTemp"));
		
		//Select the Pencil tool
		Select drawtool = new Select(driver.findElement(By.id("dtool")));
		drawtool.selectByValue("pencil");
		
		//Create an Action chain to draw a shape on Canvas
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).
				moveByOffset(50, 10).
				moveByOffset(-10, -50).
				moveByOffset(-50, -10).release().perform();
		
		//Get a screen of Canvas 
		FileUtils.copyFile(WebElementExtender.captureElementBitmap(canvas), new File("C:\\tmp\\canvas.png"));
		
	}
		
		
		@AfterTest
		public void close() {
			driver.quit();

		}

	}