

Feature: Registration

  Scenario: User can register  with valid data
    When  user enter valida data
    Then  user can register sucsessfully

   Scenario: User cannot register  with invalid data
    When  user enter invalid password
    Then  user cannot register sucsessfully