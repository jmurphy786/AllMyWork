package com.qa.ShoppingStuff;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class index {
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
	private WebElement hoverDress;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
	private WebElement casualDress;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul")
	private WebElement hoverBoard;
	
	public void hover(Actions action, WebDriver driver) {
		action.moveToElement(hoverDress).perform();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"))); 
		System.out.println(myDynamicElement.isDisplayed());
		casualDress.click();
	}
	
}