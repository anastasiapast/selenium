package pagemodel.pageobject;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class HomePage extends LoadableComponent<HomePage>{
	
	static String url = "https://yandex.ru/pogoda/chelyabinsk";
	public static String title = "Прогноз погоды в Челябинске на 10 дней — Яндекс.Погода";
	
	public HomePage() {
		PageFactory.initElements(Browser.driver(), this);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(Browser.driver().getTitle().equals(title));
		
	}

	@Override
	protected void load() {
		Browser.open(url);
		
	}
	
	public void close(){
		Browser.close();
	}
	
	public Search Search() {
		Search search = new Search();
		return search;
	}



}
