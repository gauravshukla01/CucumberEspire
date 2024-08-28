@EproCampaignCreation
Feature: Create a campaign
 
  @Scenario3
  Scenario Outline: Validate Draft and Final Invoice Generation
    Given User launches Epro url and login with valid <UserName> and <Password>
    And User get the Campaign id for PO Receipted and navigate to Sales Order page
    Then User will Create Draft Invoice
    And Click on Finance and navigate to Sales Invoice
    And Click on resepctive Invoice number (Manage Invoice)
    Then User will send Final Invoice to customer
 
    Examples:
      | UserName      | Password        |
      | Staginguser_2 | Password@123456 |
