@Login
Feature: Login into FreeCRM Application

#@PositiveScanario
 #Scenario Outline: Login into FreeCRM Application
         #Given user navigate to FreeCRM application login page
         #When title of login page is Free CRM
         #Then user get login credentials from "<sheetName>" and <rowNum> and proceed with login
         #Then user should land on FreeCRM application homepage
         #Then user will logout from application
         #
#Examples:
        #| sheetName | rowNum |
        #| LoginCredentials   | 0 |
        
@NegativeScanario      
Scenario Outline: Login into FreeCRM Application
         Given user navigate to FreeCRM application login page
         When title of login page is Free CRM
         Then user get login credentials from "<sheetName>" and <rowNum> and proceed with login
         Then user should land on FreeCRM application homepage
         Then user will logout from application
         
Examples:
        | sheetName | rowNum |
        | LoginCredentials   | 1 |