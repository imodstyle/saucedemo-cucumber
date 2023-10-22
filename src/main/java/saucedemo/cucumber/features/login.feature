@all @login
Feature: Login to www.saucedemo.com

  Scenario Outline: Ensure Login Functionality
    Given User open the saucedemo website
    When User enter "<username>" as username
    And User enter "<password>" as password
    And User click the login button
    Then User verify "<status>" login result

    Examples:
      |username           |password       |status|
      |standard_user      |secret_sauce   |success|
      |locked_out_user    |secret_sauce  |failed|