Feature: Test mail.ru by second method

  Background:
    Given GetDriver
    When Got to Mail.ru
    And I do login
    Then the button "Compose" should be visible

  Scenario Outline: Check buttons
    Then the "<Buttons>" should be visible
    And Close Browser

    Examples:
      | Buttons |
      | inbox   |
      | sent    |
      | drafts  |



