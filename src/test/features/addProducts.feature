Feature: Add Product feature to add new products

  As a system admin of Invoice Manager
  I should be able to add new products under Add Products section.

  @addProducts
  Scenario Outline: Validate add product functionality with valid input data

    Given I'm on Invoice Manager Login Page "QAurl"
    When I enter the valid email "<email>" in email address field
    When I enter the valid password "<password>" in password field
    And I click Login Button
    Then I should be re-directed to Client's Home Page
    When I change the url end to home
    Then I should be re-directed to Admin Home Page
    When I select the main category "<main>"
    When I select the sub filter option "<sub>"
    Then I should be re-directed to appropriate New Product page
    When I type product name "<name>"
    And I type product details "<detailInfo>"
    And I type product price "<amount>"
    And I click Submit Button
    Then I should be re-directed to appropriate List Products page with product added alert.

    Examples:
      | email         | password | main     | sub         | name           | detailInfo           | amount |
      | admin@gic.com | Admin123 | products | Add Product | Jabra Ear Pods | Bluetooth headphones | 300    |


  @addProducts
  Scenario Outline: Validate add product functionality with in-valid input data

    Given I'm on Invoice Manager Login Page "QAurl"
    When I enter the valid email "<email>" in email address field
    When I enter the valid password "<password>" in password field
    And I click Login Button
    Then I should be re-directed to Client's Home Page
    When I change the url end to home
    Then I should be re-directed to Admin Home Page
    When I select the main category "<main>"
    When I select the sub filter option "<sub>"
    Then I should be re-directed to appropriate New Product page
    When I type product name "<name>"
    And I type product details "<detailInfo>"
    And I type product price "<amount>"
    And I click Submit Button
    Then I should get an invalid field error message and remain in the same add product page

    Examples:
      | email         | password | main     | sub         | name         | detailInfo      | amount |
      | admin@gic.com | Admin123 | products | Add Product | !%gfjkjgj*(- | invalid details | ..//32 |

  @addProducts
  Scenario Outline: Validate add product functionality with in-valid input data

    Given I'm on Invoice Manager Login Page "QAurl"
    When I enter the valid email "<email>" in email address field
    When I enter the valid password "<password>" in password field
    And I click Login Button
    Then I should be re-directed to Client's Home Page
    When I change the url end to home
    Then I should be re-directed to Admin Home Page
    When I select the main category "<main>"
    When I select the sub filter option "<sub>"
    Then I should be re-directed to appropriate New Product page
    When I type product name "<name>"
    And I type product details "<detailInfo>"
    And I type product price "<amount>"
    And I click Submit Button
    Then I should get an empty field error message and remain in the same add product page

    Examples:
      | email         | password | main     | sub         | name | detailInfo | amount |
      | admin@gic.com | Admin123 | products | Add Product |      |            |        |

