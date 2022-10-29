Feature: Shop.kz Login

  Background: To Launch the browser
    Given Launch the browser

  Scenario Outline: Login to the website
    When Clear ad and click login button.
    Then Enter user credentials using username "<username>" and password as "<password>".
    And Click login and verify account name.
    Examples:
      | username          | password   |
      | overexm@gmail.com | Testing123 |
      | test              | test       |