package extended.objectmap;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ObjectMapTest {
	
	WebDriver driver;
	public ObjectMap map;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/script/script2/bodymass.shtml");
	}
	
	@Test
	public void testBMICalculator() throws Exception {		
		try {			
			//Get the Object Map file
			map = new ObjectMap("C:\\Users\\apastukhova\\workspace\\QA_Selenium_local\\src\\extended\\objectmap\\objectmap.properties");
			
			//Get the Height element
			WebElement heightField = driver.findElement(map.
					getLocator("heightField"));
			heightField.sendKeys("181");
			
			//Get the Weight element
			WebElement weightField = driver.findElement(map.
					getLocator("weightField"));
			weightField.sendKeys("80");
			
			//Click Calculate
			WebElement calculate = driver.findElement(map.
					getLocator("calculate"));
			calculate.click();
			
			WebElement bmiResult = driver.findElement(map.
					getLocator("bmiResult"));
			assertEquals("24", bmiResult.getAttribute("value"));
			
		}
		catch (Error e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	void close() {
		driver.close();
	}	

}
