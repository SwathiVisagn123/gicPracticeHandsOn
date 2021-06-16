Feature: Retrieve the New Product added using List Products option.

  As a system admin of Invoice Manager
  I should be able to add new products into the system and the same can be retrieved using List products option.

  @retrieveProduct
  Scenario Outline: Validate 'Add Product' and 'List Products' functionality to add and retrieve same product

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
    When I type product name "<name>" in the search field and click Enter
    Then I should be able to retrieve the added product "<name>" successfully

    Examples:
      | email         | password | main     | sub         | name     | detailInfo | amount |
      | admin@gic.com | Admin123 | products | Add Product | Dyson v6 |            | 275    |

