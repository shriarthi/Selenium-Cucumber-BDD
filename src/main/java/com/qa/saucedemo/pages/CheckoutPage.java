package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class CheckoutPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By checkoutBtn = By.id("checkout");

	public InformationPage clickOnChekout() {
		eleUtil.doClick(checkoutBtn);
		return new InformationPage(driver);
	}
}
