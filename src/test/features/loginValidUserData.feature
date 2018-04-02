# language: en
@login
Feature: Login - success
  Background:
    Given Open link https://trello.com/login

  @success
  Scenario: Login to https://trello.com/login
    When User inputs login tt0135459@gmail.com
    And User inputs password F1D5HmW9f
    And User clicks button Login
    Then Page is opened https://trello.com/