package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.utils.ElementUtil;

public class LoginPage  {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// By Locators 
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	
	// Page actions
	public LoginPage doLogin(String un,String pwd) {
		System.out.println("login with : "+ un +" : "+ pwd);
		eleUtil.doSendKeys(username, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return new LoginPage(driver);
	}
}

