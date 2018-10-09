package extended;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;


public class JQueryUITab {
	
	private WebElement _jQueryUITab;

	public WebElement get_jQueryUITab() {
		return _jQueryUITab;
	}

	public void set_jQueryUITab(WebElement _jQueryUITab) {
		this._jQueryUITab = _jQueryUITab;
	}
	
	public JQueryUITab(WebElement jQueryUITab) {
		set_jQueryUITab(jQueryUITab);
	}
	
	public int getTabCount() {
		List <WebElement> tabs = _jQueryUITab.findElements(By.
				cssSelector(".ui-tabs-nav > li"));
		return tabs.size();
	}
	
	public String getSelectedTab() {
		WebElement tab = _jQueryUITab.findElement(By.
				cssSelector(".ui-tabs-nav > li[class*='ui-tabs-selected']"));
		return tab.getText();
	}

	public void selectTab(String tabName) throws Exception {
		
		int ind = 0;
		boolean found = false;
		List<WebElement> tabs = _jQueryUITab.findElements(By.
				cssSelector(".ui-tabs-nav > li"));
		
		for (WebElement tab : tabs) {
			if (tabName.equals(tab.getText().toString())) {
				@SuppressWarnings("deprecation")
				WrapsDriver wrappedElement = (WrapsDriver) _jQueryUITab;
				JavascriptExecutor driver = (JavascriptExecutor) wrappedElement
						.getWrappedDriver();
				driver.executeScript(
						"jQuery(arguments[0]).tabs().tabs('select',arguments[1]);",
						_jQueryUITab, ind);
				found = true;
				break;
			}
			ind++;
		}
		if (found == false)
			throw new IllegalArgumentException("Could not find tab '" + tabName
					+ "'");

	}
}
