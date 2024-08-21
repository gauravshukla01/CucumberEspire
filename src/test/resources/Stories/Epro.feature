@EproCampaignCreation
Feature: Create a campaign

  @Scenario1
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
      | Staginguser_3 | Paragon@2024 |

  @Scenario2
  Scenario Outline: Validate PO Generation and Receipt Creation
    Given User launches Epro url
    Then user login with valid <UserName> and <Password>
    And On Campaign Item Page verify Status as Quote Accepted after Accepting the quote
    And User will Send and the create PO
    Then Verify Status as PO Created after creating the PO on Campaign Item Page
    And User will navigate to Finance page to create receipt
    Then User will upload POD document
    And Verify Has POD column status with green tick
    And User navigate to the Receipt Tab and click on required Checkbox
    Then Verify Receipted column status with green tick

    Examples: 
      | UserName      | Password     |
      | Staginguser_3 | Paragon@2024 |

  @Scenario3
  Scenario Outline: Validate Draft and Final Invoice Generation
    Given User launches Epro url
    Then user login with valid <UserName> and <Password>
    And User get the required Campaign id for PO Receipted
    And Click on Finance and navigate to Sales Order
    Then User will Create Draft Invoice
    And Click on Finance and navigate to Sales Invoice
    And Click on resepctive Invoice number (Manage Invoice)
    Then User will send Final Invoice to customer

    Examples: 
      | UserName      | Password     |
      | Staginguser_3 | Paragon@2024 |
