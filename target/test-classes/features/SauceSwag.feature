Feature: Sauce swag

  Background:
    Given I am on sauce swag login page

  Scenario: Login with valid username
    When I login with valid username and password
    Then I should see items on page

  Scenario: Login with locked user
    When I login with locked username and password
    Then I should get error message

  Scenario: Login with visual user
    When I login with visual user
    Then I should see "onesie" item
    And price should be 7.99


