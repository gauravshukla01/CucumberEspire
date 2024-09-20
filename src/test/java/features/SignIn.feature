@Zoho
Feature: Sign In

Scenario: Sign on Zoho
Given User launches url "https://accounts.zoho.in/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html"
When User enter email "nitinvmore1981@gmail.com"
And User click on Next
And User enter password "Nitin@2020"
And User click on Sign in
Then User on Home Page