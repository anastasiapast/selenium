package fundtransfer.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.*;
import cucumber.api.java.en.*;


public class FundTransferStepDefs {
		
	private static File file = new File("C:/seleniumDrivers/chromedriver.exe");
    static {
    	System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());	
    }
	protected static WebDriver driver = new ChromeDriver();;
	
	@Given("the user is on Fund Transfer Page")
	public void theUserIsOnFundTransferPage() {
		driver.get("http://cookbook.seleniumacademy.com/fundTransfer.html");
	}

	@When("he enters \"([^\"]*)\" as payee name")
	public void heEntersPayeeName(String payeeName) {
		driver.findElement(By.id("payee")).sendKeys(payeeName);
	}

	@And("he enters \"([^\"]*)\" as amount")
	public void heEntersAmount(String amount) {
		driver.findElement(By.id("amount")).sendKeys(amount);
	}

	@And("he submits request for Fund Transfer")
	public void heSubmitsRequestForFundTransfer() {
		driver.findElement(By.id("transfer")).click();
	}

	@Then("ensure the fund transfer is complete with \"([^\"]*)\" message")
	public void ensureTheFundTransferIsComplete(String msg) {
		WebElement message = driver.findElement(By.id("message"));
		assertEquals(message.getText(), msg);
	}

	@Then("^ensure a transaction failure \"([^\"]*)\" is displayed$")
	public void ensureATransactionFailureMessage(String msg) {
		WebElement message = driver.findElement(By.id("message"));
		assertEquals(message.getText(), msg);
	}

	
	@After
	public void tearDown() {
		driver.close();
	}
	

}
