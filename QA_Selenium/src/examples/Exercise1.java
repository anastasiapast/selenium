package examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise1 {

	boolean isNumeric(String s) {
		try{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@DataProvider(name = "string-data")
	Object[][] testData(){
		//positive tests
		return new Object[][] {
			{"2"}, 
			{"-123"},
			{"0"} 
		};
	}
	
	@DataProvider(name = "string-data-invalid")
	Object[][] invalidData(){
		//positive tests
		return new Object[][] {
			{"dgdg"}, 
			{"-12fgdfg3"},
			{"0?/fg"},
			{""},
			{null},
			{"2147483649"},
			{"-2147483649"},
			{"123.333"}
		};
	}
	
	@Test(dataProvider = "string-data")
	void checkStrings (String input) {
		Assert.assertTrue(isNumeric(input));
	}
	
	@Test(dataProvider = "string-data-invalid")
	void checkStringsInvalid (String input) {
		Assert.assertFalse(isNumeric(input));
	}
}
