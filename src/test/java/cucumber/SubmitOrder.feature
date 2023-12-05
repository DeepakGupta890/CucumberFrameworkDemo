
@tag
Feature: Purchage the order for Ecommers website
  I want to use this template for my feature file

Background:
Given I landded on Ecommerce page


  @Regression
  Scenario Outline: Positive test of submiting the order 
    Given Logged in with username <name> and password  <password>
    When I add the product <productName> to cart
    And Checkout <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displaying on ConfirmationPage

    Examples: 
      | name                   | password     |  productName  |
      | deepaktest+2@gmail.com |     Test@123 | ZARA COAT 3   |
      
