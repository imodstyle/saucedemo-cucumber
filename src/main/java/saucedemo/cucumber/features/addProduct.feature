@all @addProduct
Feature: Add product from www.saucedemo.com

  @all @Positive
  Scenario: Success add product
    Given User open saucedemo website 3
    When User login success 3
    Then User is on saucedemo product page 3
    When User click add to cart button 3
    And User click cart icon 3
    Then Product show at cart list 3

  @all @Negative
  Scenario: Failed add product
    Given User open saucedemo website 3
    When User login success 3
    Then User is on saucedemo product page 3
    When User click add to cart button 3
    And User click cart icon 3
    Then Product not show at cart list 3
