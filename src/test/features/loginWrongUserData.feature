# language: en
@login
Feature: Login - failure
  Background:
    Given Open link https://trello.com/login

  @success
  Scenario: Login to https://trello.com/login
    When User inputs login 1111111@whatever.mail
    And User inputs password whateverPass123
    And User clicks button Login
    Then Error message appeared Аккаунт с таким адресом электронной почты не существует