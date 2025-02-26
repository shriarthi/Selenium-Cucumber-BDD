package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class OrderPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By itemTotal = By.cssSelector("div.summary_subtotal_label");
	private By finishbtn = By.id("finish");

	public String getItemTotal() {
		String text = eleUtil.doGetText(itemTotal).replace("Item total: $", "");
		return text;
	}

	public OrderHistoryPage doClickFinish() {
		eleUtil.doClick(finishbtn);
		return new OrderHistoryPage(driver);
	}
}
