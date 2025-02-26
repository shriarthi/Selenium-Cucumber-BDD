Feature: Order History functionality on SauceDemo

  Scenario: Verify order confirmation message after completing purchase
    Given The user is on the order history page
    When The user checks the order confirmation message
    Then The user should see "Thank you for your order!" displayed