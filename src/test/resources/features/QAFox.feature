Feature: QA Fox products

  @QAFox
  Scenario: Get items
    When I navigate to QA Fox home page
    Then I print out all item names
    And I navigate to Desktops -> Mac page
    And I get item name and price from Mac page