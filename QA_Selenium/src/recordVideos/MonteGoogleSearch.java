package recordVideos;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.http.entity.mime.MIME;
import org.monte.media.FormatKeys.MediaType;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.activation.registries.MimeTypeFile;

//Using Monte Media Library
public class MonteGoogleSearch {
	
	private WebDriver driver;
	private ScreenRecorder screenRecorder;
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//Create an instance of GraphicsConfiguration
		
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice()
				.getDefaultConfiguration();
		
		//Create an instance of ScreenRecorder
		screenRecorder = new ScreenRecorder(gc);
		
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		
		//Start the record
		screenRecorder.start();
	}
	
	@Test
	public void testGoogle() throws Exception {
		
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		
		//Can use submit instead of ENTER
		element.submit();
		
		try {
			(new WebDriverWait(driver, 10)).until(new
					ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver d) {
							return d.getTitle().toLowerCase().startsWith("cheese");
						}
					});
			
			assertEquals(driver.getTitle(), "Cheese - Поиск в Google");
			
		} 
		catch (Error e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void close() throws IOException {
		driver.close();
		
		//Stop the record
		screenRecorder.stop();;
	}


}
