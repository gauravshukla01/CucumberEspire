Feature: Manual Invoice Creation

Scenario: Verify whether user is able to manual invoice
    Given Open URL
    And Enter Username
    And Enter Password
    And Click on Login button
    And Go to Finance
    And Click on Manual Invoices
    And Click on Create Invoice
    And Add all required details
    And Click on Add Line
    And Add all required details for line
    And Click on Create Invoice
    And Select Invoice Date from pop-up
    And Click on Ok button
    And Click on Close button on pop-up
    Then Verify invoice creation confirmation

Scenario: Verify whether user is able to manual invoice test
    Given Open URL
    And Enter Username
    And Enter Password
    And Click on Login button
    And Go to Finance
    And Click on Manual Invoices
    And Click on Create Invoice
    And Add all required details
    And Click on Add Line
    And Add all required details for line
    And Click on Create Invoice
    And Select Invoice Date from pop-up
    And Click on Ok button
    And Click on Close button on pop-up
    Then Verify invoice creation confirmation

