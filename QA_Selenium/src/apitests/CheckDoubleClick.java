package apitests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckDoubleClick {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkText() {
		
		driver.get("file:///C:/Users/apastukhova/Desktop/double%20click.html");
		
		WebElement message = driver.findElement(By.id("demo"));
		
		//Verify text color is black 		
		assertEquals("rgba(0, 0, 0, 1)", message.getCssValue("color").toString());
		
		Actions builder = new Actions(driver);
		builder.doubleClick(message).build().perform();
		
		//Verify Color is Red
		assertEquals("rgba(255, 0, 0, 1)", message.getCssValue("color").toString());
		
				
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/*
	 * <html>
		<body>
		
		<p id="demo" ondblclick="myFunction()">Double-click me to change my text color.</p>
		
		<p>A function is triggered when the p element is double-clicked. The function sets the color of the p element to red.</p>
		
		<script>
		function myFunction() {
		    document.getElementById("demo").style.color = "red";
		}
		</script>
		
		</body>
	</html>

	 */

}
