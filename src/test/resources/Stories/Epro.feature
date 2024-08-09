@EproCampaignCreation
Feature: Create a campaign

  @Scenario1
  Scenario Outline: Login to Epro account
    Given User launches "https://uat.paragon-epro.com/"
    When user enters <UserName> and <Password>
    And user clicks on submit button
    And user should get logged in
    And user clicks on campaigns
    And user clicks on create campaign button
    And user selects the business Unit
    And user select the customer and customer entity
    And user enters the campaign details
    And user clicks on save & submit button
    Then campaign is successfully created alert appears

    Examples: 
      | UserName      | Password     |
      | Staginguser_1 | Paragon@2024 |
