package pagemodel.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	
	@FindBy(id = "header2input")
	private WebElement search;
	
	public Search() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	public SearchResults searchInStore(String query) {
		search.sendKeys(query);
		search.sendKeys(Keys.ENTER);
		
		return new SearchResults(query);
		
	}

}
