@smokeTest @positive @negative
Feature: The internet herokuapp

  Scenario: Validate links on home page
    When I navigate to home page
    Then I should see 44 links

  Scenario: Validate checkboxes header
    When I navigate to checkboxes page
    Then I validate page header

  @closeTab
  Scenario: Open and close new tab
    When I navigate to windows page
    And I click link
    Then new tab should open
    When I close new tab
    Then I should have 1 tab remaining


  Scenario: Quit browser
    When I navigate to Herokuapp home page
    And I quit browser
    Then no tabs should be remaining






