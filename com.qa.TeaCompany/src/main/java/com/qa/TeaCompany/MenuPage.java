package com.qa.TeaCompany;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement checkIn;
	
	public void checkMeIN() 
	{
		checkIn.click();
	}
}

