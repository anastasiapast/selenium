package performance;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.lang3.time.*;


public class Timer {
	
		WebDriver driver;
		
		
		@BeforeTest
		public void setUp() {
			File file = new File("C:/seleniumDrivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver = new ChromeDriver();
		}

		//Using System.currentTimeMillis();
		@Test
		public void testCurrentTime() throws Exception {
			
			//Get the Start time
			long startTime = System.currentTimeMillis();
			
			driver.get("https://www.google.com/");

			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
			
			//Get the End time
			long endTime = System.currentTimeMillis();
			
			//Measure total time
			long totalTime = endTime - startTime;
			System.out.println("Test 1 - Total Page Load Time: " + totalTime +
					" milliseconds");
			
			
		}
		
		
		//Using StopWatch
		@Test
		public void testStopWatch() throws Exception {
			
			//Get the StopWatch obj and start
			StopWatch pageLoad = new StopWatch();
			pageLoad.start();
			
			driver.get("https://www.google.com/");

			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
						
			//Stop the StopWatch
			pageLoad.stop();
			System.out.println("Test 2 - Total Page Load Time: " + pageLoad.getTime() +
					" milliseconds");
			
			
		}		
		
		@AfterTest
		public void close() {
			driver.quit();

		}

	}
