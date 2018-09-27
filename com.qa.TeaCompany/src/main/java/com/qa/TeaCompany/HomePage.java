package com.qa.TeaCompany;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement goMenu;
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914886\"]/div/h1")
	private WebElement checkWebsite;
	
	public void goToMenu() {
		goMenu.click();
	}
}
