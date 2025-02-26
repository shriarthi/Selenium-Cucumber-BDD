package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class CheckoutPage {

	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
			
			//2. Page Constructor 
	public CheckoutPage(WebDriver driver) {
	this.driver = driver;
	eleUtil = new ElementUtil(driver);
	}
			
	private By checkoutBtn = By.id("checkout");	
	
	
}
