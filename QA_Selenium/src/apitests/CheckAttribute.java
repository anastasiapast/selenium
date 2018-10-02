package apitests;

import static org.testng.Assert.assertEquals;

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

public class CheckAttribute {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkWidth() {
		
		driver.get("https://artsandculture.google.com/");
		
		WebElement menu = driver.findElement(By.className("y04zAd"));
		
		assertEquals("24px", menu.getAttribute("width"));		
	}

	@Test
	public void checkCssWidth() {
		
		driver.get("https://artsandculture.google.com/");
		
		WebElement menu = driver.findElement(By.className("y04zAd"));
		
		String width = menu.getCssValue("width");
		
		System.out.println(width);
		
		assertEquals("24px", width);		
	}


	
		
	@AfterMethod
	void close() {
		driver.close();
	}	

}
