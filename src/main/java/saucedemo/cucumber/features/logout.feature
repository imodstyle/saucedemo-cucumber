@all @logout
Feature: Logout from www.saucedemo.com
  Scenario: Ensure Logout Functionality
    Given User open saucedemo website 1
    When User login success 1
    And User click menu button
    And User click logout button
    Then User verify logout result