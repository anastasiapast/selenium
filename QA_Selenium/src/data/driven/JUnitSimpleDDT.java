package data.driven;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
public class JUnitSimpleDDT {
	
	WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	@Parameters
	public static Collection testData() {
		return Arrays.asList(
				new Object[][] {
					{"160","45","17.6","Underweight"},
					{"168","70","24.8","Normal"},
					{"181","89","27.2","Overweight"},
					{"178","100","31.6","Obesity"}
				});
	}
	
	public JUnitSimpleDDT (String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}
	
	@Before
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}

	@Test
	public void testBMICalculator() throws Exception {
		
		driver.get("https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm");
		
		WebElement switchMetric = driver.findElement(By.cssSelector("#aimtxt > table > tbody > tr > td > ul > li:nth-child(1) > a"));
		switchMetric.click();
		
		//Set height parm to Height field
		WebElement heightField = driver.findElement(By.id("htc"));
		heightField.clear();
		heightField.sendKeys(height);
		
		//Set weight parm to Weight field
		WebElement weightField = driver.findElement(By.id("kg"));
		weightField.clear();
		weightField.sendKeys(weight);
		
		//Click Calculate
		WebElement calculate = driver.findElement(By.cssSelector("#aimtxt > table > tbody > tr > td > table > tbody > tr > td > form > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(6) > td > span > input[type=\"button\"]"));
		calculate.click();
		
		
		//Get the result
		try {
			WebElement bmiResult = driver.findElement(By.id("yourbmi"));
			assertEquals(bmi, bmiResult.getAttribute("value"));
			
			//The same for category label....
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.err.println("Assertation Fail " + verificationErrors.toString());
		}
	}
	
	@After
	public void close() {
		driver.close();
	}

}
