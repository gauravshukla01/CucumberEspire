@TextBox
Feature: Functionality of Text Box

  Scenario Outline: Entering the values in Text Box Field
    Given User enter and Launches website "https://demoqa.com/"
    When User click on element
    When User click on Text Box
    And User enter the name <full name>
    And User enter the mail <email>
    And User enter the current address <cur add>
    And User enter the Permanent address <per add>
    And User click on submit
    Then User will visible enter details

    Examples: 
      | full name | email           | cur add | per add |
      | name1     | name1@gmail.com | success | success |
      | name2     | name2@gmail.com | fail    | fail    |
