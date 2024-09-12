@Demo
Feature: Logon to Google

  @Scenario11-EPA-1
  Scenario: Logon Google
    Given User launches "https://www.google.com/"
    When User Click on Search Box
    Then user should get land

  @Scenario12-EPA-2
  Scenario: Logon Facebook
    Given User launches the facebook page "https://www.facebook.com/"
    When User Click on email box
    Then user should get land on create button
