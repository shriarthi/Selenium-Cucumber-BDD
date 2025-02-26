package com.qa.saucedemo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.ProductsPage;
import com.qa.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.*;

public class ProductsSteps {

	private WebDriver driver;
	private ProductsPage productsPage;
	private CheckoutPage checkoutPage;
	private String productPrice;

 
	@Given("the user is on the products page")
	public void the_user_is_on_the_products_page() {
		driver = DriverFactory.getDriver();
		productsPage = new ProductsPage(driver);
	}

	@When("the user adds {string} to the cart")
	public void the_user_adds_to_the_cart(String productName) {
		productPrice = productsPage.clickOnAddToCart(productName);
		System.out.println("Product added: " + productName + " | Price: $" + productPrice);
	}

	@Then("the product should be added with the correct price")
	public void the_product_should_be_added_with_the_correct_price() {
		Assert.assertNotNull("Product price should not be null", productPrice);
	}

	@And("the user clicks on the cart icon")
	public void the_user_clicks_on_the_cart_icon() {
		checkoutPage = productsPage.clickCartIcon();
		Assert.assertNotNull("Cart page should be loaded", checkoutPage);
	}
}
