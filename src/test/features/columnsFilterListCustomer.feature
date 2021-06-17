Feature: Columns Filter Option in List Customer Page

  As a system admin of Invoice Manager

  when i select the columns from the columns tab, the selected columns should be displayed in the List Customer page.


  Background:
    Given I'm on Invoice Manager Login Page "QAurl"
    When I enter the valid email "admin@gic.com" in email address field
    When I enter the valid password "Admin123" in password field
    And I click Login Button
    Then I should be re-directed to Client's Home Page
    When I change the url end to home
    Then I should be re-directed to Admin Home Page
    When I select the main category "customers"
    When I select the sub filter option "List Customers"
    Then I should be re-directed to appropriate List Customers Page
    When I click on the columns button "Columns" in the page


  @customerColumnsFilter
  Scenario Outline: Columns Filter Validation in List Customer Page with 'few' columns de-selected


    When I de-select the column name "<columnName1>"
    Then I should not retrieve the de-selected columns "<columnName1>" as the filter result
    When I de-select the column name "<columnName2>"
    Then I should not retrieve the de-selected columns "<columnName2>" as the filter result
    When I de-select the column name "<columnName3>"
    Then I should not retrieve the de-selected columns "<columnName3>" as the filter result


    Examples:
      | columnName1 | columnName2 | columnName3 |
      | City        | Country     | Actions     |


  @customerColumnsFilter
  Scenario: Columns Filter Validation in List Customer Page with 'all' columns de-selected

    When I de-select all the active columns
    Then I should not retrieve any filter results

  @customerColumnsFilter
Scenario: Columns Filter Validation in List Customer Page with 'no' columns de-selected

  When I select the default inactive columns
  Then I should retrieve all the columns in filter result

