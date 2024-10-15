@putFeature
Feature: PUT: Automated Demo Tests
  Description: PUT: The purpose of this feature is to test some demo app.

  @putPassScenario
  Scenario Outline: Put_create_user_details_positiveScenario
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    And I try to verify the response value "name" is "morpheus"
    And I try to verify the response value "job" is "zion resident"

    Examples: 
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | Demo test | /api/users/2 | application/json | /src/test/resources/com/api/testData/put.json | PUT           |        201 |

  @putFailScenario
  Scenario Outline: Put_create_user_details_negativeScenario
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    And I try to verify the response value "name" is "morpheus"
    And I try to verify the response value "job" is "zion residesnt"

    Examples: 
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | Demo test | /api/users/2 | application/json | /src/test/resources/com/api/testData/put.json | PUT           |        201 |
