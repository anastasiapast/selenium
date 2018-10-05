package data.driven;

import static org.junit.Assert.*;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNGSimpleDDT {
	
	WebDriver driver;
	static StringBuffer verificationErrors = new StringBuffer();
	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
					{"160","45","18","Underweight"},
					{"168","70","25","Normal"},
					{"181","89","27","Overweight"},
					{"178","100","32","Obesity"}
				};
	}
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/script/script2/bodymass.shtml");
	}

	@Test (dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String bmi, String bmiCategory) throws Exception {
		
		try {			
			//Set height parm to Height field
			WebElement heightField = driver.findElement(By.name("height"));
			heightField.clear();
			heightField.sendKeys(height);
			
			//Set weight parm to Weight field
			WebElement weightField = driver.findElement(By.name("weight"));
			weightField.clear();
			weightField.sendKeys(weight);
			
			//Click Calculate
			WebElement calculate = driver.findElement(By.xpath("//*[@id=\"middlecolumn\"]/form[1]/p/input[1]"));
			calculate.click();
			
			WebElement bmiResult = driver.findElement(By.name("bmi"));
			assertEquals(bmi, bmiResult.getAttribute("value"));
			
			//The same for category label....
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
		
		String verificationErrorsString = verificationErrors.toString();
		if(!"".equals(verificationErrorsString)) {
			fail(verificationErrorsString);
		}
	}

}
