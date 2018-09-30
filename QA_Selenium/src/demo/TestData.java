package demo;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "calc-data")
	Object[][] testData(){
		return new Object[][] {
			{"2 + 3", "5"}, // data set - 2 arguments for calcTest
			{"sqrt 16", "4"}, // data set - 2 arguments for calcTest
			{"1 - 0", "1"} // data set - 2 arguments for calcTest
		};
	}
}
