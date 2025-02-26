package com.qa.saucedemo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.OrderPage;
import com.qa.saucedemo.pages.OrderHistoryPage;
import io.cucumber.java.en.*;

public class OrderPageSteps {

    private WebDriver driver;
    private OrderPage orderPage;
    private OrderHistoryPage orderHistoryPage;
    private String itemTotalPrice;

    @Given("The user is on the order summary page")
    public void the_user_is_on_the_order_summary_page() {
        driver = DriverFactory.getDriver();
        orderPage = new OrderPage(driver);
    }

    @When("The user checks the item total")
    public void the_user_checks_the_item_total() {
        itemTotalPrice = orderPage.getItemTotal();
        System.out.println("Item total: $" + itemTotalPrice);
        Assert.assertNotNull("Item total should not be null", itemTotalPrice);
    }

    @And("The user clicks on the finish button")
    public void the_user_clicks_on_the_finish_button() {
        orderHistoryPage = orderPage.doClickFinish();
    }

    @Then("The user should be redirected to the order history page")
    public void the_user_should_be_redirected_to_the_order_history_page() {
        Assert.assertNotNull("Order history page should be loaded", orderHistoryPage);
    }
}
