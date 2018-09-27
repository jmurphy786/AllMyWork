package com.qa.DemoSite;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class RunningTests {
	
WebDriver driver = null;
public static ExtentReports reports;
public static ExtentTest test;
private String my_username = "dwadwa";
private String my_password = "dwadwa";


@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
	driver = new ChromeDriver();
	reports = new ExtentReports("C:/Users/Admin/Desktop/Empty/BingWebPageTest.html", true);
	test = reports.startTest("My Details");
}

@Given("^my username and password$")
public void my_username_and_password(){

}

@When("^my username and password is entered$")
public void my_username_and_password_is_entered(){
	
    driver.get("http://thedemosite.co.uk/addauser.php");
	AddUser newUser = PageFactory.initElements(driver, AddUser.class);
	test.log(LogStatus.INFO, "Loaded WebPage");
	newUser.createUser(my_username, my_password);

}


@Then("^I am signed in$")
public void i_am_signed_in() throws Throwable {
	test.log(LogStatus.INFO, "Signed Up!");
}


@Given("^my username and password I used to signUp$")
public void my_username_and_password_I_used_to_signUp() throws InterruptedException{
	driver.get("http://thedemosite.co.uk/login.php");
	Login loginUser = PageFactory.initElements(driver, Login.class);
	test.log(LogStatus.INFO, "Logging In!");
	loginUser.doLogin(my_username, my_password);

}

@When("^dwadwadwa$")
public void dwadwadwa() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^I am logged in$")
public void i_am_logged_in() throws Throwable
{
	WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	if(checkElement.getText().equals("**Successful Login**")) {
		test.log(LogStatus.PASS, "We logged in!");
	}
	else {
		test.log(LogStatus.FAIL, "Didn't log in!");
	}
	Thread.sleep(2000);
}

@After
public void endSetup() {
	driver.close();
	reports.flush();
}

}
