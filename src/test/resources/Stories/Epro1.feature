@EproCampaignCreation
Feature: Create a campaign

  @Scenario2-EPA-2
  Scenario Outline: Validate PO Generation and Receipt Creation
    Given User launches Epro url and login with valid <UserName> and <Password>
    And On Campaign Item Page verify Status as Quote Accepted and User will Send and the create PO
    Then Verify Status as PO Created after creating the PO on Campaign Item Page
    And User will navigate to Finance page to create receipt
    Then User will upload POD document
    And Verify Has POD column status with green tick
    And User navigate to the Receipt Tab and click on required Checkbox
    Then Verify Receipted column status with green tick

    Examples: 
      | UserName      | Password     |
      | Staginguser_5 | Paragon@2024 |
