package com.qa.DemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userInput;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement userPass;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submitBut;
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement toLog;
	
	public void createUser(String userName, String Pass) {
		userInput.sendKeys(userName);
		userPass.sendKeys(Pass);
		submitBut.submit();
		toLog.click();
	}
	
}
