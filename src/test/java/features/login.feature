@web @login
Feature: Login

  @login-valid-user
  Scenario: Login with a valid user
    Given User access the website
    And User click on the Login button
    When User input login "Mochi" and "1"
    And Click on the Login button
    Then The user is redirected to the user homepage

  @login-invalid-user
  Scenario: Login with an invalid user
    Given User access the website
    And User click on the Login button
    When User input login "Mochi" and "123"
    And Click on the Login button
    Then Validate that the credential are invalid