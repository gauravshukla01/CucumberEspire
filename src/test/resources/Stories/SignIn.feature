@Zoho
Feature: Sign In

  @Scenario1
  Scenario Outline: Sign on Zoho
    Given User launches url "https://accounts.zoho.in/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html"
    When User enter email '<Email>'
    And User click on Next
    And User enter password '<Password>'
    And User click on Sign in
    Then User on Home Page

    Examples: 
      | Email                      | Password   |
      | nitinvmore1981@gmail.com   | Nitin@2020 |
      | chetanspatel1996@gmail.com | Chetan123  |
      | chetanspatel1996@gmail.com | Chetan123  |
      | chetanspatel1996@gmail.com | Chetan123  |
      | chetanspatel1996@gmail.com | Chetan123  |
    
     
    
      
    
      