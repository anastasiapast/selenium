package pagemodel.pageobject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
	
	@Test
	public void testProductSearch() {		
		
		//Create an instance of Home page
		HomePage homePage = new HomePage();
		
		//Navigate to the Home page
		homePage.get();
		
		//Search for 'Chelyabinsk', the searchInStore method will
		//return SearchResults class
		SearchResults searchResult = homePage.Search().searchInStore("Chelyabinsk");

		//Verify there are 9 cities in result set
		Assert.assertEquals(searchResult.getCities().size(), 9);
		Assert.assertTrue(searchResult.getCities().contains("Chelyabinsk"));
	
		searchResult.close();
	}

}
