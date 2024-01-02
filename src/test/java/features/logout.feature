@web @logout
Feature: Logout

  Scenario: Logout from the user page
    Given User access the website
    And User click on the Login button
    And User input login "Mochi" and "1"
    And Click on the Login button
    When Click on the Logout button
    Then The user is logged out