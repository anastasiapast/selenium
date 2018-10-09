package pagemodel;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestPageFactory {
		
	@Test 
	public void testBMICalculator() {
		
		//Create an BmiCalcPage instance 
		BmiCalcPage page = new BmiCalcPage();
		
		page.load();
		
		page.calculateBmi("180", "81");
						
		
		assertEquals(page.getBmi(), "25");
		
		page.close();
	}
		

	
}
