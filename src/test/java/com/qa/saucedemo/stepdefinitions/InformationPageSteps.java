package com.qa.saucedemo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.InformationPage;
import com.qa.saucedemo.pages.OrderPage;
import io.cucumber.java.en.*;

public class InformationPageSteps {

    private WebDriver driver;
    private InformationPage informationPage;
    private OrderPage orderPage;

    @Given("The user is on the information page")
    public void the_user_is_on_the_information_page() {
        driver = DriverFactory.getDriver();
        informationPage = new InformationPage(driver);
    }

    @When("The user enters first name {string}, last name {string}, and zip code {string}")
    public void the_user_enters_first_name_last_name_and_zip_code(String firstName, String lastName, String zipCode) {
        orderPage = informationPage.yourInformation(firstName, lastName, zipCode);
    }

    @And("The user clicks the continue button")
    public void the_user_clicks_the_continue_button() {
        // Clicking the continue button is already handled in the `yourInformation` method.
    }

    @Then("The user should be redirected to the order summary page")
    public void the_user_should_be_redirected_to_the_order_summary_page() {
        Assert.assertNotNull("Order summary page should be loaded", orderPage);
    }
}
