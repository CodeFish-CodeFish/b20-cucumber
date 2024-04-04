Feature: The internet herokuapp

  Scenario: Validate links on home page
    When I navigate to home page
    Then I should see 44 links

  Scenario: Validate checkboxes header
    When I navigate to checkboxes page
    Then I validate page header
