@Amazon

Feature: Logon to amazon
@Scenario1
  Scenario: Logon Amazon
    Given User launches "https://www.amazon.com/"
    When username and password are entered
      | UserName           | Password  |
      | satyen02@gmail.com | Syntel@1a |
    And user clicks on submit button
    Then user should get logged in