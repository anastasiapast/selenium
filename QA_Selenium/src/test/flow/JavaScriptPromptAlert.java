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

public class JavaScriptPromptAlert {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void testPrompt(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/alertprompt.html");
		
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();
		
		try {
			Alert alert = driver.switchTo().alert();
			
			alert.sendKeys("Foo");
			
			alert.accept();
			
			WebElement message = driver.findElement(By.id("demo"));
			
			assertEquals(message.getText(), "Hello Foo! How are you today?");
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
		
		<h2>JavaScript Prompt</h2>
		
		<button onclick="myFunction()">Try it</button>
		
		<p id="demo"></p>
		
		<script>
		function myFunction() {
		    var txt;
		    var person = prompt("Please enter your name:", "Harry Potter");
		    if (person == null || person == "") {
		        txt = "User cancelled the prompt.";
		    } else {
		        txt = "Hello " + person + "! How are you today?";
		    }
		    document.getElementById("demo").innerHTML = txt;
		}
		</script>
		
		</body>
		</html>

	 */
}
