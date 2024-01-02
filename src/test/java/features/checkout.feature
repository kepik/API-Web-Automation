@web @checkout
Feature: Checkout

  @checkout-add-product
  Scenario: User add a product to the cart
    Given User access the website
    And User click on the Login button
    And User input login "Mochi" and "1"
    And Click on the Login button
    When User click on a product
    And Click on the Add to Cart button
    Then Validate the product is added into Cart

  @checkout-finish
  Scenario: User complete the checkout process
    Given User login and add a product to cart
    And User click on the Cart button
    When Click on the Place Order button
    And Input customer details
    Then Validate the purchase is success