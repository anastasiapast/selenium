package apitests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckText {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkText() {
		
		driver.get("https://support.google.com/websearch/answer/2649515?p=ws_m_handwrite&visit_id=636739922359870241-3858928816&rd=1");
		
		WebElement message = driver.findElement(By.tagName("h1"));
		
		//Get the element text
		String messageText = message.getText();
		
		//Test it
		Assert.assertEquals("Search by handwriting", messageText);
		
		//String API methods
		Assert.assertTrue(messageText.contains("by"));
		Assert.assertTrue(messageText.startsWith("Search"));
		Assert.assertTrue(messageText.endsWith("handwriting"));
		
	}
	
	@Test
	public void checkSpanText() {
		
		driver.get("https://www.packtpub.com/web-development/selenium-testing-tools-cookbook");
		
		WebElement div = driver.findElement(By.className("book-info-nb-page"));
		
		String divText = div.getText();
		
		System.out.println(divText);
	}
	
	
	
	//PAGE 45
	
	@AfterMethod
	void close() {
		driver.close();
	}	

}
