
Feature: Login

  Scenario: User can login  with valid data
    When  user enter valid data
    Then  user can login  sucsessfully

  Scenario: User cannot login  with invalid data
    When  user enter Invalid data
    Then  user cannot login with validation message


  Scenario: User cannot login  with empty data
    When  user enter empty data
    Then  user cannot login with validation_message