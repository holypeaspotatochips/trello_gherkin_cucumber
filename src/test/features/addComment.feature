# language: en
@boards
Feature: Comment addition
  Background:
    Given Open link https://trello.com/login
    And User inputs login tt0135459@gmail.com
    And User inputs password F1D5HmW9f
    And User clicks button Login
    Then Page is opened https://trello.com/

  @success
  Scenario: User adds comment to an existing card
    When User clicks board name Доска без названия
    And User clicks menu link
    And User fills comment NewComment
    And User saves comment
    Then User can see comment