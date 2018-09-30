package demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {

	public static void main(String[] args) {

		//register chrome driver - from seleniumhq site
		// without .exe extension - for Mac OS
		 File file = new File("/Users/anastasiapast/Documents/chromedriver");
		 if (file.exists()){
			 System.out.println("Exists");
		 }
		 System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("selenium training");
		element.submit();
	}

}
