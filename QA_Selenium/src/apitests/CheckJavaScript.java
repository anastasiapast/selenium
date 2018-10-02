package apitests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CheckJavaScript {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkJavaScript() throws Exception{
		
		driver.get("https://www.google.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String title = (String) js.executeScript("return document.title");
		
		assertEquals(title, "Google");
		
		long links = (Long) js.executeScript
				("var links = document.getElementsByTagName('A');  "
						+ "return links.length");
		assertEquals(links, 44);
		System.out.println(links);
		
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
