package com.qa.DemoQA;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.DemoQA.Droppable;

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
		driver.get("https://web.archive.org/web/20180111102827/http://demoqa.com:80/droppable/");
		Droppable drop = PageFactory.initElements(driver, Droppable.class);
		drop.moveBar(driver);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
