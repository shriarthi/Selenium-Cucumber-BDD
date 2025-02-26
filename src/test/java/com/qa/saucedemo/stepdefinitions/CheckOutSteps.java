package com.qa.saucedemo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.CheckoutPage;
import com.qa.saucedemo.pages.InformationPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;



public class CheckOutSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private InformationPage informationPage;

    @Given("The user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("The user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() throws InterruptedException {
        informationPage = checkoutPage.clickOnChekout();
        
        Thread.sleep(3000);
        
        if (informationPage == null) {  // Ensure InformationPage is returned properly
            throw new IllegalStateException("CheckoutPage.clickOnChekout() returned null");
        }
    }

    @Then("The user should be redirected to the information page")
    public void the_user_should_be_redirected_to_the_information_page() {
        Assert.assertNotNull("Information page should be loaded", informationPage);
    }
}
