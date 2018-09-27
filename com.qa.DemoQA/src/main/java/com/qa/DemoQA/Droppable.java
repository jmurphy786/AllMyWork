package com.qa.DemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Droppable {


	@FindBy(xpath = "//*[@id=\"draggableview\"]")
	private WebElement moveAble;
	
	@FindBy(xpath = "//*[@id=\"droppableview\"]")
	private WebElement dropAble;
	
	public void moveBar(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(moveAble).clickAndHold().moveToElement(dropAble).release().perform();
	}
}
