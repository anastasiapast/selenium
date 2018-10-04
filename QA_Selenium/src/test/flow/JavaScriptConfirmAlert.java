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
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
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

public class JavaScriptConfirmAlert {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void testConfirmAccept(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/alertconfirm.html");
		
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
		
		try {
			Alert alert = driver.switchTo().alert();
						
			alert.accept();
			
			WebElement message = driver.findElement(By.id("demo"));
			
			assertEquals(message.getText(), "You pressed OK!");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void testDismissAccept(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/alertconfirm.html");
		
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
		
		try {
			Alert alert = driver.switchTo().alert();
						
			alert.dismiss();
			
			WebElement message = driver.findElement(By.id("demo"));
			
			assertEquals(message.getText(), "You pressed Cancel!");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}	
	}
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/*
	 <!DOCTYPE html>
		<html>
		<body>
		
		<h2>JavaScript Confirm Box</h2>
		
		
		<button onclick="myFunction()">Try it</button>
		
		<p id="demo"></p>
		
		<script>
		function myFunction() {
		    var txt;
		    if (confirm("Press a button!")) {
		        txt = "You pressed OK!";
		    } else {
		        txt = "You pressed Cancel!";
		    }
		    document.getElementById("demo").innerHTML = txt;
		}
		</script>
		
		</body>
		</html>

	 */
}
