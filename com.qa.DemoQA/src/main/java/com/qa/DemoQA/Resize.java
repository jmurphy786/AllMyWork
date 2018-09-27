package com.qa.DemoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resize {

	@FindBy(xpath = "//*[@id=\"resizable\"]/div[3]")
	private WebElement resizeBut;
	
	@FindBy(xpath = "//*[@id=\"resizable\"]/h3")
	private WebElement resizeIcon;
	
	
}
	