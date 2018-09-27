package com.qa.Shopping;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindDress {

	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement inputDress;
	
	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement select;
	public void getDress(String input) {
		inputDress.sendKeys(input);
		select.click();
	}
}
