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

public class ElementStatus {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	//Methods:
	//1. isEnabled()
	//2. isSelected()
	//3. isDisplayed()
	
	
	@Test
	void testIsElementEnabled(){

		driver.get("file:///C:/Users/apastukhova/Desktop/checkbox.html");

		WebElement car = driver.findElement(By.xpath("//input[@value='Car']"));
		
		if(!car.isDisplayed())
			fail("Car is not displayed");
		
		if(car.isEnabled()) {
			
			if(!car.isSelected()) {
				car.click();
			}
		}
		else {
			fail("Car is disabled!");
		}
	
	}

	

			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
