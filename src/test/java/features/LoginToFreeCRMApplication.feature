@Login
Feature: Login into FreeCRM Application

@PositiveScanario
 Scenario Outline: Login_into_FreeCRM_Application
         Given user navigate to FreeCRM application login page
         When title of login page is Free CRM
         Then user get login credentials from "<sheetName>" and <rowNum> and proceed with login
         Then user should land on FreeCRM application homepage
         Then user will logout from application
         
Examples:
        | sheetName | rowNum |
        | LoginCredentials   | 0 |
        
@NegativeScanario      
Scenario Outline: Login_into_FreeCRM_Application_With_Invalid_Credentials
         Given user navigate to FreeCRM application login page
         When title of login page is Free CRM
         Then user get login credentials from "<sheetName>" and <rowNum> and proceed with login
         Then user should land on FreeCRM application homepage
         Then user will logout from application
         
Examples:
        | sheetName | rowNum |
        | LoginCredentials   | 1 |