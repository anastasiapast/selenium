package data.driven;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
public class ExcelTestData {
	
	static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	private String height;
	private String weight;
	private String bmi;
	private String error;
	
	
	public ExcelTestData (String height, String weight, String bmi, String error) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.error = error;
	}
	
	@BeforeClass
	public static void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/script/script2/bodymass.shtml");
	}

	//Return data from Excel
	@Parameters
	public static Collection testData() throws Exception{
		InputStream spreadsheet = new FileInputStream("C://Users//apastukhova//workspace//QA_Selenium_local//src//data//driven//ExcelData.xlsx");
		return new SpreadsheetData(spreadsheet).getData();
		
	}
	
	//Read CSV file
	public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
		
	}
	
	@Test
	public void testBMICalculator() throws Exception {
		try {				
		//Set height parm to Height field
			WebElement heightField = driver.findElement(By.name("height"));
			heightField.clear();
			if (!height.equals("<Blank>"))
				heightField.sendKeys(this.height);
			
			//Set weight parm to Weight field
			WebElement weightField = driver.findElement(By.name("weight"));
			weightField.clear();
			if (!weight.equals("<Blank>"))
				weightField.sendKeys(this.weight);
			
			//Click Calculate
			WebElement calculate = driver.findElement(By.xpath("//*[@id=\"middlecolumn\"]/form[1]/p/input[1]"));
			calculate.click();
			
			if (error.equals("<Blank>")) {
				WebElement bmiResult = driver.findElement(By.name("bmi"));
				assertEquals(this.bmi, bmiResult.getAttribute("value"));
			} else {
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				alert.accept();
				System.out.println("alert - " + alertMessage);
				System.out.println("error -" + this.error);
				assertEquals(alertMessage.trim(), this.error.trim());
				alert.accept();
			}
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.err.println("Assertation Fail " + verificationErrors.toString());
		}
	}
	
	@AfterClass
	public static void tearDown()  throws Exception{
		driver.quit();
		String verificationErrorsString = verificationErrors.toString();
		if(!"".equals(verificationErrorsString)) {
			fail(verificationErrorsString);
		}
	}

}
