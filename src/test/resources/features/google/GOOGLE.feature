@Google @All
Feature: GOOGLE
  I want to test the Google Website

  @HomePage
  Scenario: GOOGLE_HOME_PAGE
    Given I connect to https://www.google.com
    Then I should see Google Home page

  @Search
  Scenario Outline: GOOGLE_SEARCH
    Given I connect to https://www.google.com
    And I search for "<SEARCH>"
    Then I should see the search results for "<SEARCH>"

    Examples: 
      | SEARCH |
      | Apple  |
      | Orange |
