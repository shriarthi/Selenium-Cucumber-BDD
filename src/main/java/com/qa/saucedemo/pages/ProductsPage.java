package com.qa.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.saucedemo.utils.ElementUtil;

public class ProductsPage {

	// 1. declare private driver
		private WebDriver driver;
		private ElementUtil eleUtil;
		
		//2. Page Constructor 
		public ProductsPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
		
		//3. By Locators
	private By productName = By.xpath("//div[@class='inventory_item_label']/a/div");
	private By price = By.xpath("//div[@class='pricebar']/div");
	private By addCartBtn = By.xpath("//div[@class='pricebar']/button");
	private By cartIcon = By.cssSelector("div.shopping_cart_container a");
	

	public String clickOnAddToCart(String additem) {
		List<WebElement> productList = eleUtil.getElements(productName);
		String text = null;
		
		for(int i=0;i<productList.size();i++) {
					
			  if(additem.equals(productList.get(i).getText())) {
				text = eleUtil.getElements(price).get(i).getText().replace("$","");
				eleUtil.getElements(addCartBtn).get(i).click();
				eleUtil.screenShot(driver);
				}
		}
		return text;
	 }
	public CheckoutPage clickCartIcon() {
		eleUtil.doClick(cartIcon);
		return new CheckoutPage(driver);
	}
}