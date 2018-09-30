package examples;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class Exercise3 {

	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	void getLinks() {
		driver.get("https://translate.google.com/");
				
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Assert.assertEquals(links.size(), 46);
		
		System.out.println(links.size());
		
		for (WebElement l:links) {
			System.out.println(l.getAttribute("href"));
		}
	}
	
	@Test
	void linkTest() {
		driver.get("https://www.google.com/");
		WebElement gmailLink = driver.findElement(By.linkText("Почта"));
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Почта")));
		Assert.assertEquals("https://mail.google.com/mail/?tab=wm", gmailLink.getAttribute("href"));
	}

	@AfterMethod
	void close() {
		driver.close();
	}
	
	
	
}
