package apitests;


import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

public class TakeScreen {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void takeScreenshot() throws Exception{
		
		driver.get("https://www.google.com");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Take a sceen
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\tmp\\main_page.png")); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
