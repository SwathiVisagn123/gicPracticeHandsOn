Feature: Login to Admin Home Page

  As a user
  I should be able to login and get re-directed to Admin Home Page

  @loginToHome
  Scenario Outline: Validate user re-direction to Admin Home Page after successful login.

    Given I'm on Invoice Manager Login Page "QAurl"
    When I enter the valid email "<email>" in email address field
    When I enter the valid password "<password>" in password field
    And I click Login Button
    Then I should be re-directed to Client's Home Page
    When I change the url end to home
    Then I should be re-directed to Admin Home Page

    Examples:
      | email         | password |
      | admin@gic.com | Admin123 |