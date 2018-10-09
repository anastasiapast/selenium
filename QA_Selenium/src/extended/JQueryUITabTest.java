package extended;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUITabTest {
WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tabs/");
	}
	
	@Test
	void testWidget() throws Exception{

		try {
			JQueryUITab tab = new JQueryUITab(driver.findElement(By.
					cssSelector("div[id=tabs][class^=ui-tabs]")));
					
			assertEquals(tab.getTabCount(), 3);
			
			assertEquals(tab.getSelectedTab(), "Nunc tincidunt");
			
			tab.selectTab("Proin dolor");
			Thread.sleep(5000);
			assertEquals(tab.getSelectedTab(), "Proin dolor");
		} catch (Error e) {
			e.printStackTrace();
		}

	}
			
	@AfterMethod
	void close() {
		driver.close();
	}	
	
}
