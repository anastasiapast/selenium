package apitests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckCheckbox {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	//Check the expected values are in DropDown
	@Test
	public void testCheckbox(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/checkbox.html");

		WebElement bike = driver.findElement(By.xpath("//input[@value='Bike']"));
		
		if(!bike.isSelected())
			bike.click();
		
		assertTrue(bike.isSelected());
		
		if(bike.isSelected())
			bike.click();
		
		assertFalse(bike.isSelected());
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/*
		<!DOCTYPE html>
		<html>
		<body>
		
		<h1>Show checkboxes:</h1>
		
		<form action="/action_page.php">
		  <input type="checkbox" name="vehicle1" value="Bike"> I have a bike<br>
		  <input type="checkbox" name="vehicle2" value="Car"> I have a car<br>
		  <input type="checkbox" name="vehicle3" value="Boat" checked> I have a boat<br><br>
		  <input type="submit" value="Submit">
		</form>
		
		</body>
		</html>
	 */
	
	
	
}
