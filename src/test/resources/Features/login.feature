Feature: Login functionality for saucedemo

Scenario: Successfully login with valid credentials 
 
 Given The user is on the login page
 When  The user login using "<Username>" and "<Password>"
 And The user should click on the login button
 Then The user should redirected to the main page
 
 
  Examples:
  
  |   Username    |  Password  |
  |locked_out_user|secret_sauce|
  |standard_user  |secret_sauce|