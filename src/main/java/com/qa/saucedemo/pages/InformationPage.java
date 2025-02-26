package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class InformationPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public InformationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By zipCode = By.id("postal-code");
	private By continueBtn = By.xpath("//input[@value='Continue']");

	public OrderPage yourInformation(String fName, String lName, String zip) {
		eleUtil.doSendKeys(firstName, fName);
		eleUtil.doSendKeys(lastName, lName);
		eleUtil.doSendKeys(zipCode, zip);
		eleUtil.doClick(continueBtn);
		return new OrderPage(driver);
	}

}
