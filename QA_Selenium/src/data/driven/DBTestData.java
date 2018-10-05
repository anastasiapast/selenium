package data.driven;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.Parameterized;

//Access driver doesn't work with Java 8 and higher
@RunWith(value = Parameterized.class)
public class DBTestData {
	
	static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	private String height;
	private String weight;
	private String bmi;
	
	
	public DBTestData (String height, String weight, String bmi) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}
	
	@BeforeClass
	public static void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/script/script2/bodymass.shtml");
	}

	@Parameters
	public static Collection testData() throws Exception{
		return getTestData("C://Users//apastukhova//workspace//QA_Selenium_local//src//data//driven//BmiTesting.mdb",
				"SELECT Height, Weight, Bmi FROM TestData");		
	}
	
	public static Collection<String[]> getTestData(String mdbFile, 
			String sqlQuery) throws IOException, SQLException, ClassNotFoundException {
		
		ArrayList<String[]> records = new ArrayList<String[]>();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + mdbFile;
		
		Connection conn = DriverManager.getConnection(myDB, "", "");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		rs = stmt.executeQuery(sqlQuery);
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		
		int cols = rsMetaData.getColumnCount();
		
		while (rs.next())
		{
			String fields[] = new String[cols];
			int col = 0;
			for(int colIdx = 1; colIdx <= cols; colIdx++) {
				fields[col] = rs.getString(colIdx);
				col++;
			}
			records.add(fields);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return records;
		
	}
	
	@Test
	public void testBMICalculator() throws Exception {
		try {				
		//Set height parm to Height field
			WebElement heightField = driver.findElement(By.name("height"));
			heightField.clear();
			heightField.sendKeys(this.height);
			
			//Set weight parm to Weight field
			WebElement weightField = driver.findElement(By.name("weight"));
			weightField.clear();
			weightField.sendKeys(this.weight);
			
			//Click Calculate
			WebElement calculate = driver.findElement(By.xpath("//*[@id=\"middlecolumn\"]/form[1]/p/input[1]"));
			calculate.click();

			WebElement bmiResult = driver.findElement(By.name("bmi"));
			assertEquals(this.bmi, bmiResult.getAttribute("value"));
			
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
