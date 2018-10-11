package performance;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTiming {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}

	//Using Navigation Timing
	@Test
	public void testNavTiming() throws Exception {
		
		driver.get("https://www.google.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Get the Load Event end
		long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
		
		//Get the Navigation Event Start
		long loadEventStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

		System.out.println("Page Load Time is " + (loadEventEnd - loadEventStart)/1000 +
				" seconds");		
	}	
	
	@AfterTest
	public void close() {
		driver.quit();

	}

}

