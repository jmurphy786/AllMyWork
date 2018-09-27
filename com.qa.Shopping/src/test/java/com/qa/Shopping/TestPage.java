package com.qa.Shopping;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.Shopping.FindDress;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestPage {
	WebDriver driver = null;
	private Actions action;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeClass
	public static void initial() {
	reports = new ExtentReports("C:/Users/Admin/Desktop/Empty/BingWebPageTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
	}
	
	@Test
	public void testSearch() throws InterruptedException {
		test = reports.startTest("Search Test");
		test.log(LogStatus.INFO, "Search Opened");
		driver.get("http://automationpractice.com/index.php");
		FindDress userPage = PageFactory.initElements(driver, FindDress.class);
		userPage.getDress("dress");
		test.log(LogStatus.INFO, "Select Dress");
		Thread.sleep(1000);
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]"));
		String str = checkElement.getText();
		String[] output =  str.split(" ");
		if(output[0].equals("7")) {
			test.log(LogStatus.PASS, "Search Test Was Found");
		}
		else {
			test.log(LogStatus.FAIL, "Search Test Wasn't Found");
		}
		assertEquals("7", output[0]);
	}
	

	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@AfterClass
	public static void end() {
		reports.flush();
	}
}
