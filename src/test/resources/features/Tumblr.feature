Feature: Tumblr login

  @smokeTest @regression @success @temirlan
  Scenario Outline: Invalid login
    Given I am on Tumblr home page
    When I click login button
    And I click continue with email
    And I enter "<email>" email
    And I enter "<password>" password
    Then I should get "Your email or password were incorrect." error

    Examples:
      | email         | password |
      | test@test.com | abcabc   |
