Feature: Order Page functionality on SauceDemo

  Scenario: Verify item total and complete the order
    Given The user is on the order summary page
    When The user checks the item total
    And The user clicks on the finish button
    Then The user should be redirected to the order history page