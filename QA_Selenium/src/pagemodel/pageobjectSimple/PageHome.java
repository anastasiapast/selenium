package pagemodel.pageobjectSimple;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome {
	
	//������ ������
	@FindBy(name = "q")
	public WebElement searchBox;
	
	//������ ������ � Google
	//@FindBy(css = "input[value=\"Google Search\"]")
	//@FindBy(name = "btnK")
	//public WebElement searchBtn;
	
}
