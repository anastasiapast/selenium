package pagemodel.pageobjectSimple;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageResultSearch {
	
	//Логотип-ссылка
	@FindBy(css = "a#logo")
	public WebElement logo;
}
