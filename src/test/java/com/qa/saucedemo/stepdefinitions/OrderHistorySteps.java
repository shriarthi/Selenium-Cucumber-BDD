package com.qa.saucedemo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.OrderHistoryPage;
import io.cucumber.java.en.*;

public class OrderHistorySteps {

    private WebDriver driver;
    private OrderHistoryPage orderHistoryPage;
    private String confirmationMessage;

    @Given("The user is on the order history page")
    public void the_user_is_on_the_order_history_page() {
        driver = DriverFactory.getDriver();
        orderHistoryPage = new OrderHistoryPage(driver);
    }

    @When("The user checks the order confirmation message")
    public void the_user_checks_the_order_confirmation_message() {
        confirmationMessage = orderHistoryPage.orderConfirmation();
        System.out.println("Order Confirmation Message: " + confirmationMessage);
    }

    @Then("The user should see {string} displayed")
    public void the_user_should_see_displayed(String expectedMessage) throws InterruptedException {
    	
    	Thread.sleep(3000);
    	
        Assert.assertEquals("Order confirmation message mismatch!", expectedMessage, confirmationMessage);
    }
}
