package examples;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise4_jQuery {

	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDefaultSelectedCheckboxes() {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_checked");
		
		//Expected list of selected checkboxes
		List<String> checked = Arrays.asList(new String[]{"vehicle"});
		
		//Create an instance of JavaScript Executor from driver
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Locate all the Checkbox which are checked by calling jQuery
		//find() method
		//find() method returns elements in array
		List<WebElement> elements = (List<WebElement>) js.executeScript("return $(jQuery.find(':checked'))");
		System.out.println(elements.size());
		
		//Verify one Checkbox is selected
		Assert.assertEquals(elements.size(), 1);
		
		//Verify correct Checkbox is selected
		for (WebElement element:elements) {
			Assert.assertTrue(checked.contains(element.getAttribute("name")));
		}
	}

	@AfterMethod
	void close() {
		driver.close();
	}
	
	
	
}
