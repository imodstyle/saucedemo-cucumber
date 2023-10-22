@all @checkout
Feature: Checkout product from www.saucedemo.com

  @all @Positive
  Scenario: Success Checkout Complete
    Given User open saucedemo website 2
    When User login success 2
    Then User is on saucedemo product page 2
    When User click cart icon 2
    And User click checkout button 2
    And User input Firstname
    And User input Lastname
    And User input postal
    And User click continue
    Then Checkout step two page displayed

  @all @Negative
  Scenario: Success Checkout None
    Given User open saucedemo website 2
    When User login success 2
    Then User is on saucedemo product page 2
    When User click cart icon 2
    And User click checkout button 2
    And User input Firstname
    And User input Lastname
    And User input postal
    And User click continue
    Then Checkout step two page displayed