@WayFairLogin
Feature: WAYFAIR_LOGIN
  I want to test the login functionality of Wayfair website

  @SignIn
  Scenario: SIGN_IN_TO_YOUR_ACCOUNT
    Given I connect to "https://www.wayfair.com"
    When I click Sign In
    Then I should see Enter Your Email Address page
    Given I enter email address as "srinimarva@gmail.com"
    And I enter password as "Orange@27"
    When I click on Sign In button
    Then I should see My Account menu option under Account menu
