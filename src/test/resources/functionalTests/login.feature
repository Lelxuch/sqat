Feature: Shop.kz Login

  Background: To Launch the browser
    Given Launch the browser

  Scenario: Login to the website
    When Clear ad and click login button.
    Then Enter user credentials.
    And Click login and verify account name.