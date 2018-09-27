package com.qa.DemoSite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.DemoSite.AddUser;
import com.qa.DemoSite.Login;

public class TestPage {
	
	WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void testSearch() throws InterruptedException {
		driver.get(Constant.URL);
		AddUser userPage = PageFactory.initElements(driver, AddUser.class);
		userPage.createUser("dwa", "dwa");
		Thread.sleep(1000);
		Login loginPage = PageFactory.initElements(driver, Login.class);
		loginPage.doLogin("dwa", "dwa");
		WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", checkElement.getText());
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
