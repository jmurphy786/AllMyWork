package com.qa.TeaCompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCase {

	private ChromeDriver driver;
	private ExtentReports reports;
	private ExtentTest test;
	private HomePage home;
	private WebElement checkInMenu;
	private WebElement inCheckout;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		reports = new ExtentReports("C:/Users/Admin/Desktop/Empty/BingWebPageTest.html", true);
		test = reports.startTest("My Details");
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address(){
	    driver.get(Constant.URL);
		home = PageFactory.initElements(driver, HomePage.class);
	    WebElement checkElement = driver.findElement(By.xpath( "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914886\"]/div/h1"));
	    if(checkElement.getText().equals("We're passionate about tea.")) {
	    	test.log(LogStatus.PASS, "Proper Website");
	    }
	    else 
	    {
	    	test.log(LogStatus.FAIL, "Not Proper Website");
	    }
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
	    home.goToMenu();
    	test.log(LogStatus.INFO, "Selected Menu");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
	    checkInMenu = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
	    if(checkInMenu.getText().equals("Menu")) 
	    {
	    	test.log(LogStatus.PASS, "Proper Website");
	    }
	    else 
	    {
	    	test.log(LogStatus.FAIL, "Not Proper Website");
	    }
	}

	@Given("^that the URL is correct$")
	public void the_correct_URL()
	{
		 driver.get(Constant.URLmenu);
		 checkInMenu = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
		 if(checkInMenu.getText().equals("Menu")) 
		    {
		    	test.log(LogStatus.PASS, "Proper Website");
		    }
		    else 
		    {
		    	test.log(LogStatus.FAIL, "Not Proper Website");
		    }
		
	}
	
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()  {
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.checkMeIN();
    	test.log(LogStatus.INFO, "Selected CheckIn");
    	
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  {
		inCheckout = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span"));
		if(inCheckout.getText().equals("Enter your billing information"))
	    {
	    	test.log(LogStatus.PASS, "Proper Website");
	    }
	    else 
	    {
	    	test.log(LogStatus.FAIL, "Not Proper Website");
	    }
	}
	
	@After
	public void endSetup() {
		driver.close();
		reports.flush();
	}

}
