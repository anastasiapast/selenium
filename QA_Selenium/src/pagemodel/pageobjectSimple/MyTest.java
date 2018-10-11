package pagemodel.pageobjectSimple;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;


public class MyTest {
	
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@Test
	public void testGoogle() throws InterruptedException {
		
		driver.get("https://www.google.ru");
		PageHome homePage = new PageHome();
		PageFactory.initElements(driver, homePage);
		
		homePage.searchBox.sendKeys("Chelyabinsk");
		homePage.searchBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		PageResultSearch resultPage = new PageResultSearch();
		PageFactory.initElements(driver, resultPage);
		resultPage.logo.click();
		
		Thread.sleep(5000);
	}
	
	@AfterMethod
	void close() {
		driver.close();
	}

}
