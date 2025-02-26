Feature: Checkout Process on SauceDemo

  Scenario: Proceed to checkout from the cart
    Given The user is on the cart page
    When The user clicks on the checkout button
    Then The user should be redirected to the information page
