@web @signup
Feature: Sign-up

  @web-signup
  Scenario: Sign up new user
    Given User access the website
    And User click on the Sign up button
    When User input "" and ""
    And Click on the Sign up button
    Then A new user is created
    And Validate the signed up user with login