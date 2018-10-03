package test.flow.popup;


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

public class PopupByName {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void testWindowPopup(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/popup.html");
		
		String parentWindowId = driver.getWindowHandle();
		
		System.out.println(parentWindowId);
		
		//Click to open popup
		WebElement button = driver.findElement(By.id("myBtn"));
		button.click();
		
		try {
			//Switch to popup
			driver.switchTo().window("popUpWindow");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		//Verify the driver context is in Help Popup Browser Window
		assertTrue(driver.getTitle().contains("Popup Example"));
		
		//Close the popup
		driver.close();
		
		//Back to Parent window
		driver.switchTo().window(parentWindowId);
		
		System.out.println(driver.getTitle());
		
		//assertTrue(driver.getTitle().contains("popup"));
		
	
	}
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/* popup.html
		 * <!DOCTYPE html>
		<html>
		<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style>
		body {font-family: Arial, Helvetica, sans-serif;}
	
		/* The Modal (background) 
		.modal {
		    display: none; /* Hidden by default  
	    position: fixed; /* Stay in place 
	    z-index: 1; /* Sit on top  
	    padding-top: 100px; /* Location of the box  
	    left: 0;
	    top: 0;
	    width: 100%; /* Full width  
	    height: 100%; /* Full height  
	    overflow: auto; /* Enable scroll if needed 
	    background-color: rgb(0,0,0); /* Fallback color 
	    background-color: rgba(0,0,0,0.4); /* Black w/ opacity  
	}
	
		/* Modal Content 
		.modal-content {
		    background-color: #fefefe;
		    margin: auto;
		    padding: 20px;
		    border: 1px solid #888;
		    width: 80%;
		}
		
		/* The Close Button  
		.close {
		    color: #aaaaaa;
		    float: right;
		    font-size: 28px;
		    font-weight: bold;
		}
		
		.close:hover,
		.close:focus {
		    color: #000;
		    text-decoration: none;
		    cursor: pointer;
		}
		</style>
		</head>
		<body>
		
		<h2>Popup Example</h2>
		<input type="button" id="myBtn" value="Open a Popup Window" 
		onclick="window.open('https://www.quackit.com/javascript/examples/sample_popup.cfm','popUpWindow','height=500,width=400,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');">

	 */
	
}
