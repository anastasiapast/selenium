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
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsProcess {
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	void setUp() {
		//Kill Chrome instances
		WindowsUtils.killByName("chrome.exe");
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void simple(){
		driver.get("https://www.ya.ru");
	}
	
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
	
	
	
}
