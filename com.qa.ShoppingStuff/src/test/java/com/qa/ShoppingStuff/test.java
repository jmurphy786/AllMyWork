package com.qa.ShoppingStuff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class test {
	WebDriver driver = null;
	Actions builder = null;
	index indexPage = null;
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		Actions action = new Actions(driver);
		builder = new Actions(driver);
		indexPage = PageFactory.initElements(driver, index.class);
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		indexPage.hover(builder, driver);
		//Thread.sleep(1000);
		//indexPage.casualDressClick(builder, driver);
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(20000);
		driver.close();
	}
	
}