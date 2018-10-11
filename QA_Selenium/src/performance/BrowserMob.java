package performance;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.browsermob.core.har.Har;
import org.browsermob.proxy.ProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserMob {
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	}

	//Using BrowserMob
	@SuppressWarnings("deprecation")
	@Test
	public void testNavTiming() throws Exception {
		
		//Start the BrowserMob Proxy
		ProxyServer server = new ProxyServer(9090);
		server.start();
		
		//Get the Selenium Proxy object
		Proxy proxy = server.seleniumProxy();
		
		//Config Desired capability for using Proxy Server
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		
		//Start the Browser up
		driver = new ChromeDriver(capabilities);
		
		//Create a new HAR with the label "google"
		server.newHar("bmi");		
		
		driver.get("http://www.javascriptkit.com/script/script2/bodymass.shtml");
		
		WebElement heightField = driver.findElement(By.name("height"));
		heightField.sendKeys("181");
		
		WebElement weightField = driver.findElement(By.name("weight"));
		weightField.sendKeys("80");
		
		//Click Calculate
		WebElement calculate = driver.findElement(By.xpath("//*[@id=\"middlecolumn\"]/form[1]/p/input[1]"));
		calculate.click();
		
		Thread.sleep(5000);
		
		//Get the HAR data
		Har har = server.getHar();
		
		//Write the HAR data to the file
		File harFile = new File("C:\\tmp\\bmi.har");
		har.writeTo(harFile);
		
		server.stop();
	}	
	
	@AfterTest
	public void close() {
		driver.quit();

	}

}

