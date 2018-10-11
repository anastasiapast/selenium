package pagemodel.pageobject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	private static File file = new File("C:/seleniumDrivers/chromedriver.exe");
    static {
    	System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());	
    }
	private static WebDriver driver = new ChromeDriver();;
	
	public static WebDriver driver() {
		return driver;
	}
	
	public static void open(String url) {
		driver.get(url);
	}
	
	public static void close() {
		driver.close();
	}

}
