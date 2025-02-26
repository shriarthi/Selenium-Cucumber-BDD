Feature: Add product to cart on SauceDemo

  Scenario: Add a product to the cart
    Given the user is on the products page
    When the user adds "Sauce Labs Bolt T-Shirt" to the cart
    Then the product should be added with the correct price
    And the user clicks on the cart icon
