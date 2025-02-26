package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class OrderHistoryPage {

	private ElementUtil eleUtil;

	public OrderHistoryPage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
	}

	private By orderMsg = By.xpath("//h2[text()='Thank you for your order!']");

	public String orderConfirmation() {
		return eleUtil.doGetText(orderMsg);
	}
}
