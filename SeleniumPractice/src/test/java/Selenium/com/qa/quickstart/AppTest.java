package Selenium.com.qa.quickstart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
	private WebDriver driver;
	private String url = "http://thedemosite.co.uk/index.php";
	
	@Before
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	@Test
	public void mthodTest() {
		
		driver.manage().window().maximize();
	    driver.get(url);
	    driver.findElement(By.linkText("addauser")).click();
	    driver.findElement(By.linkText("username")).sendKeys("asda");
	    driver.findElement(By.linkText("password")).sendKeys("asda");	    
		WebElement goButton = driver.findElement(By.id("FormsButton2"));
		goButton.submit();
		
	    driver.findElement(By.linkText("login")).click();
	    driver.findElement(By.linkText("username")).sendKeys("asda");
	    driver.findElement(By.linkText("password")).sendKeys("asda");	
		WebElement goButton2 = driver.findElement(By.id("FormsButton2"));
		goButton2.submit();
		WebElement checkElement = driver.findElement(By.id("b"));
		
	    assertEquals("**Successful Login**", checkElement.getText());
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
