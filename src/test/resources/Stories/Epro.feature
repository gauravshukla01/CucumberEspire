@EproCampaignCreation
Feature: Create a campaign

  @Scenario1-EPA-1
  Scenario Outline: Validate Create Campaign and Assign Supplier
    Given User launches Epro url and login with valid <UserName> and <Password>
    And user navigate to Campaign page and create campaign
    And User add new Item in the Campaign using Create New Item button
    Then Verify Campaign status as Created
    And Click on Submit for Costing button
    And User will add Supplier Cost using Submit supplier button
    And User will manage the supplier price and add all required details
    And User will navigate to Quote Managment tab and generate quote
    And User will accept the quote on clicking of Quote Accepted button
    Then Verify status as Quote Accepted on Campaign Item Page

    Examples: 
      | UserName      | Password     |
      | Staginguser_5 | Paragon@2024 |
