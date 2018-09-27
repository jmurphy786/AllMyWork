import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class TestSite {
	WebDriver driver = null;
	private Actions action;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
	}
	
	@Test
	public void testSearch() throws InterruptedException {
		driver.get("https://www.phptravels.net/");
		MainPage drop = PageFactory.initElements(driver, MainPage.class);
		drop.searchDetails(driver);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
