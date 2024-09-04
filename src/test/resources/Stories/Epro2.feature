@EproCampaignCreation2
Feature: Create a campaign

  @Scenario1
  Scenario Outline: Validate Create Campaign and Assign Supplier
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
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
      | Sheetname    | Rownum |
      | Epro_details |      0 |
      

  @Scenario2
  Scenario Outline: Validate PO Generation and Receipt Creation
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And On Campaign Item Page verify Status as Quote Accepted and User will Send and the create PO
    Then Verify Status as PO Created after creating the PO on Campaign Item Page
    And User will navigate to Finance page to create receipt
    Then User will upload POD document
    And Verify Has POD column status with green tick
    And User navigate to the Receipt Tab and click on required Checkbox
    Then Verify Receipted column status with green tick

    Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      1 |

  @Scenario3
  Scenario Outline: Validate Draft and Final Invoice Generation
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And User get the Campaign id for PO Receipted and navigate to Sales Order page
    Then User will Create Draft Invoice
    And Click on Finance and navigate to Sales Invoice
    And Click on resepctive Invoice number (Manage Invoice)
    Then User will send Final Invoice to customer

    Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      2 |

  @Scenario4
  Scenario Outline: Validate download functionality
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And On Campaign Item Page verify Status as Quote Accepted and User will Send and the create PO
    And Verify Status as PO Created after creating the PO on Campaign Item Page
    Then Click on Donwload button under action tab

    Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      1 |
      
  
    @Scenario5
  Scenario Outline: Validate PO Generation and Receipt Creation
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And On Campaign Item Page and search for Camp Number and User will Send and the create PO
    Then Verify Status as PO Created after creating the PO on Campaign Item Page
    And User will navigate to Finance page to create receipt
    Then User will upload POD document
    And Verify Has POD column status with green tick
    And User navigate to the Receipt Tab and click on required Checkbox
    Then Verify Receipted column status with green tick

    Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      1 |
  
  
  @Scenario6
  Scenario Outline: Validate Manual Invoice Generation
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And Navigate to finance and click on create manual invoice
    And Send Final Invoice
    Then Post final invoice to customer
    
     Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      4 |
      
      
      @Scenario7
  Scenario Outline: Validate On-Hold to Post Invoice Generation
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And Navigate to finance and click on create manual invoice
    And Verify Send Final Invoice
    And Do On-Hold Invoice under Final Invoice
    And Do Release Invoice under On-Hold Invoice
    And Do Post invoice under Final Invoice
    Then Verify the details under the Post invoice Tab
    
     Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      4 |
      
      
      @Scenario8
  Scenario Outline: Validate user able to Credit Invoice
    Given User launches Epro url and login with valid from Sheetname "<Sheetname>" and Rownum <Rownum>
    And User go to Credit Invoice page and create a Credit Invoice
    Then User will send the Final credit invoice
    And User will post the credit invoice
    Then User will download the posted credit invoice
    

    Examples: 
      | Sheetname    | Rownum |
      | Epro_details |      1 |
