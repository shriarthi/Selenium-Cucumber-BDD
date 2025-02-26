Feature: Enter personal information on the checkout page

  Scenario: User enters valid personal information and proceeds
    Given The user is on the information page
    When The user enters first name "<firstname>", last name "<lastname>", and zip code "<zipcode>"
    And The user clicks the continue button
    Then The user should be redirected to the order summary page

    
    
    
  Examples:
  
  |firstname|lastname|zipcode|
  |   xxxx  |  yyyy  | 0000  |