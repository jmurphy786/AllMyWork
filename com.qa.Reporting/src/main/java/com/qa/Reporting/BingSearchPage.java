package com.qa.Reporting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchPage {
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeClass
	public static initial() {
	report = new ExtentReports("C:/Desktop/Empty/BingWebPageTest.html", true);
	}
	
	@Test
	public void searchTest() {
		test = report.startTest("Search Test");
		test.log(logStatus.INFO, "BING Opened");
		
		//instead of assertequals use
		test.log(logStatus.INFO, "Search started");
		
		if(bingPageSearch.search("Selenium").equals("Selenium")) {
			test.log(logStatus.PASS, "Search Test Was Found");
		}
		else {
			test.log(logStatus.FAIL, "Search Test Wasn't Found");
		}
		report.endTest(test);
	}
	
	@AfterClass
	public void end() {
		report.flush();
	}
	
	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	@FindBy(xpath = "//*[@id=\"sb_form_go\"]")
	private WebElement searchButton;
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchButton.submit();
	}
}
