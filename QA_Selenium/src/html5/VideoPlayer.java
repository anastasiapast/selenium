package html5;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VideoPlayer {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html5_video.asp");
	}

	@Test
	public void testVideoPlayer() throws Exception {
		
		File scrFile = null;
		
		//Get the HTML5 Video Element
		WebElement video = driver.findElement(By.id("video1"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Get the source of video
		String source = (String) js.
				executeScript("return arguments[0].currentSrc;", video);
		
		//Get the video duartion
		double duration = (Double) js.
				executeScript("return arguments[0].duration;", video);
		
		System.out.println(duration);
		
		assertEquals(source, "https://www.w3schools.com/html/mov_bbb.mp4");
		assertEquals(duration, 10.026667);
		
		//Play the video
		js.executeScript("return arguments[0].play();", video);
		
		Thread.sleep(5000);
		
		//Pause the video
		js.executeScript("return arguments[0].pause();", video);
		
		//Take a screenshot
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\tmp\\video.png"));
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();

	}

}
