package demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setUpClass() { // 1 time
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	}
	
	@AfterClass
	void tearDownClass() { // 1 time
		System.clearProperty("webdriver.chrome.driver");
	}
	
	@BeforeMethod
	void setUpMethod() { //2 times before each Test method
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	@AfterMethod
	void tearDownMethod() { // 2 times after each Test method
		driver.quit();
	}
	
	@Test
	void calcTest() {		 
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("2 + 3");
		element.submit();
		
		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), "5");
	}
	
	@Test
	void calcTest2() {	 
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("sqrt 16");
		element.submit();
		
		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), "4");
	}
	
	

}
