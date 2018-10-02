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

public class CheckDropDownsAndList {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	//Check the expected values are in DropDown
	@Test
	public void testDropdown(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/dropdown.html");
		
		//Select class instead of WebElement
		Select make = new Select(driver.findElement(By.tagName("select")));

		//Verify Dropdown does not support multiple selection
		assertFalse(make.isMultiple());
		
		//Verify Dropdown has 4 options
		assertEquals(make.getOptions().size(), 4);
		
		//We will verify Dropdown has expected values as listed in a array
		List<String> exp_options = Arrays.asList(new String[]{"Volvo",
				"Saab", "Opel", "Audi"});
		List<String> act_options = new ArrayList<String>();
		
		//Retrieve the option values from Dropdown 
		for (WebElement option : make.getOptions()) {
			act_options.add(option.getText());
		}
		
		assertTrue(Arrays.equals(exp_options.toArray(), act_options.toArray()));
		assertTrue(act_options.contains("Audi"));
		assertFalse(act_options.contains("Niva"));
		
		
		//We can select an option in Dropdown using Visible text
		make.selectByVisibleText("Opel");
		assertEquals(make.getFirstSelectedOption().getText(), "Opel");
		
		//or using value attribute
		make.selectByValue("audi");
		assertEquals(make.getFirstSelectedOption().getText(), "Audi");
		
		//or using Index
		make.selectByIndex(0);
		assertEquals(make.getFirstSelectedOption().getText(), "Volvo");
	}
	
	@Test
	public void testMultipleSelectList(){
		
		driver.get("file:///C:/Users/apastukhova/Desktop/list.html");
		
		//Select class instead of WebElement
		Select cars = new Select(driver.findElement(By.name("cars")));

		//Verify List supports multiple selection
		assertTrue(cars.isMultiple());
		
		//Verify Dropdown has 4 options
		assertEquals(cars.getOptions().size(), 4);
		
		//Select multiple options in the list using visible text
		cars.selectByVisibleText("Volvo");
		cars.selectByVisibleText("Saab");
		cars.selectByVisibleText("Audi");
		
		//We will verify List has selected values as listed in a array
		List<String> exp_sel_options = Arrays.asList(new String[]{"Volvo",
				"Saab", "Audi"});
		List<String> act_sel_options = new ArrayList<String>();
		
		for (WebElement option : cars.getAllSelectedOptions()) {
			act_sel_options.add(option.getText());
		}
		assertTrue(Arrays.equals(exp_sel_options.toArray(), act_sel_options.toArray()));

		assertEquals(3, cars.getAllSelectedOptions().size());
		
		//Deselect an option using visible text
		cars.deselectByVisibleText("Saab");
		assertEquals(2, cars.getAllSelectedOptions().size());
		
		//Deselect an option using value attribute of the option
		cars.deselectByValue("audi");
		assertEquals(1, cars.getAllSelectedOptions().size());
		
		//Deselect an option using Index of the option
		cars.deselectByIndex(0);
		assertEquals(0, cars.getAllSelectedOptions().size());

		
		
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	/* DropDown
	 * <!DOCTYPE html>
		<html>
		<body>
		
		<select>
		  <option value="volvo">Volvo</option>
		  <option value="saab">Saab</option>
		  <option value="opel">Opel</option>
		  <option value="audi">Audi</option>
		</select>
		  
		</body>
		</html>

	 */
	
	
	/* List
	 * <!DOCTYPE html>
		<html>
		<body>
		
		<h2>Allow Multiple Seletcions</h2>
		<p>Use the multiple attribute to allow the user to select more than one value.</p>
		
		<form action="/action_page.php">
		  <select name="cars" size="4" multiple>
		    <option value="volvo">Volvo</option>
		    <option value="saab">Saab</option>
		    <option value="fiat">Fiat</option>
		    <option value="audi">Audi</option>
		  </select>
		  <br><br>
		  <input type="submit">
		</form>
		
		<p>Hold down the Ctrl (windows) / Command (Mac) button to select multiple options.</p>
		
		</body>
</html>

	 */
	
}
