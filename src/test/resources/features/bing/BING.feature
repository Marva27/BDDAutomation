@Bing @All
Feature: BING
  I want to test the Bing Website

  @BingSearch
  Scenario Outline: BING_SEARCH
    Given I connect to https://www.bing.com
    Then I should see Bing website

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
