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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void testWithImplicitWait(){
		driver.get("file:///C:/Users/apastukhova/Desktop/implicit.html");
		
		//Set the Implicit Wait time out to 10 Seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			WebElement button = driver.findElement(By.tagName("button"));
			button.click();
			WebElement content = driver.findElement(By.id("demo"));
			System.out.println(content.getText());
			assertTrue(content.getText().contains("AJAX is not a programming language"));
		} catch (NoSuchElementException e) {
			fail("Element not found!");
			e.printStackTrace();
		}
	}
	
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/* Page implicit.html
		<!DOCTYPE html>
		<html>
		<style>
		table,th,td {
		  border : 1px solid black;
		  border-collapse: collapse;
		}
		th,td {
		  padding: 5px;
		}
		</style>
		<body>
		
		<h2>The XMLHttpRequest Object</h2>
		
		<button type="button" onclick="loadDoc()">Get my CD collection</button>
		<br><br>
		<table id="demo"></table>
		
		<script>
		function loadDoc() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      myFunction(this);
		    }
		  };
		  xhttp.open("GET", "cd_catalog.xml", true);
		  xhttp.send();
		}
		function myFunction(xml) {
		  var i;
		  var xmlDoc = xml.responseXML;
		  var table="<tr><th>Artist</th><th>Title</th></tr>";
		  var x = xmlDoc.getElementsByTagName("CD");
		  for (i = 0; i <x.length; i++) { 
		    table += "<tr><td>" +
		    x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue +
		    "</td><td>" +
		    x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue +
		    "</td></tr>";
		  }
		  document.getElementById("demo").innerHTML = table;
		}
		</script>
		
		</body>
		</html>


	 */
	
	
	/* cd_catalog.cml
	 */
	
}
