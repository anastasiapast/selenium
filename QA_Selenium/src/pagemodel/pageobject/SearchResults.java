package pagemodel.pageobject;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchResults extends LoadableComponent<SearchResults>{

	private String query;
	
	public SearchResults(String query) {
		PageFactory.initElements(Browser.driver(), this);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(Browser.driver().getTitle().equals("Яндекс.Погода"));
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> getCities() {
		List<String> cities = new ArrayList<String>();
		List<WebElement> citiesList = Browser.driver().findElements(
				By.className("place-list__item"));
		for (WebElement city : citiesList) {
			cities.add(city.findElement(By.tagName("a")).getText());
		}
		System.out.println("cities cize - " + cities.size());
		return cities;		
	}
	
	public void close(){
		Browser.close();
	}
	
	public Search Search() {
		Search search = new Search();
		return search;
		
	}

}
