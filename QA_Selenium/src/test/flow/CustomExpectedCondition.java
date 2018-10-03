package test.flow;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomExpectedCondition {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void testExplicitWait(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/implicit.html");

		try {
			WebElement button = driver.findElement(By.tagName("button"));
			button.click();
			
			//Create Wait using WebDriverWait
			//This will wait for 5 sec till the element is found
			WebElement content = (new WebDriverWait(driver, 5))
					.until(new ExpectedCondition<WebElement>() {
						@Override
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("demo"));
						}
					});
			assertTrue(content.getText().contains("AJAX is not a programming language"));
		} 
		catch (NoSuchElementException e) {
			fail("Element not found!");
			e.printStackTrace();
		}	}
	
	
	//PAGE 80
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
