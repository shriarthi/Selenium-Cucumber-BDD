package com.qa.saucedemo.stepdefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.*;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private Properties prop;

	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		prop = new DriverFactory().init_prop();
		String url = prop.getProperty("url");
		driver.get(url);
	}

	@When("The user login using {string} and {string}")
	public void the_user_login_using_and(String username, String password) {
		loginPage.doLogin(username, password);
	}

	@And("The user should click on the login button")
	public void the_user_should_click_on_the_login_button() {
		// Login action is already performed in doLogin()
	}

	@Then("The user should redirected to the main page")
	public void the_user_should_redirected_to_the_main_page() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Swag Labs", actualTitle);
	}
}
