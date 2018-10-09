package pagemodel;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

public class LoadableComponentTest{
	
	@Test 
	public void testBMICalculator() {
		
		//Create an BmiCalcPage instance 
		LoadableComponentClass page = new LoadableComponentClass();
		
		page.get();
		
		page.calculateBmi("180", "81");
						
		
		assertEquals(page.getBmi(), "25");
		
		page.close();
	}
}
