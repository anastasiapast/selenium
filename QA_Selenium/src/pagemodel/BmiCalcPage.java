package pagemodel;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BmiCalcPage {
	
	//Define vars - use the name or id attributes
	
	@FindBy(name = "height")
	@CacheLookup // - static element, not search it again; this tells method to cache the element once it's loaded
	private WebElement height; //id
	
	@FindBy(name = "weight")
	private WebElement weight; //id
	
	@FindBy(xpath = "//*[@id=\"middlecolumn\"]/form[1]/p/input[1]")
	private WebElement submitbtn;
	
	@FindBy(name = "bmi")
	private WebElement formula_result; //id
	
	private WebDriver driver;
	
	private String url = "http://www.javascriptkit.com/script/script2/bodymass.shtml";
	
	public BmiCalcPage() {
		File file = new File("C:/seleniumDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void load() {
		this.driver.get(url);
	}
	
	public void close() {
		this.driver.close();
	}
	
	public void calculateBmi (String heightStr, String weightStr) {
		
		height.clear();
		height.sendKeys(heightStr);
		
		weight.clear();
		weight.sendKeys(weightStr);
		
		submitbtn.click();
	}
	
	public String getBmi () {
		return formula_result.getAttribute("value");
	}
}
