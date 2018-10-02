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

public class CheckRadio {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	//Check the expected values are in DropDown
	@Test
	public void testRadioButton(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/radio.html");
		
		//Get the Radiobutton 
		WebElement milk = driver.findElement(By.xpath("//input[@value='Milk']"));
				
		//Check if its already selected?
		if (!milk.isSelected())
			milk.click();
		
		assertTrue(milk.isSelected());
		
		//Get all radiobuttons from Radio Group
		List<WebElement> drinks = driver.findElements(By.name("group2"));
		for (WebElement drink : drinks) {
			if (drink.getAttribute("value").equals("Beer"))
			{
				if(!drink.isSelected())
					drink.click();
				
				assertTrue(drink.isSelected());
				break;
			}
		}
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/*
	 * 
<html>
<head>
<title>My Page</title>
</head>
<body>
<form name="myform" action="http://www.mydomain.com/myformhandler.cgi" method="POST">
<div align="center"><br>
<input type="radio" name="group1" value="Milk"> Milk<br>
<input type="radio" name="group1" value="Butter" checked> Butter<br>
<input type="radio" name="group1" value="Cheese"> Cheese
<hr>
<input type="radio" name="group2" value="Water"> Water<br>
<input type="radio" name="group2" value="Beer"> Beer<br>
<input type="radio" name="group2" value="Wine" checked> Wine<br>
</div>
</form>
</body>
</html>
	 */
	
	
	
}
