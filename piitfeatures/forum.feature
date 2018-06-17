Feature: Test PIIT Forum

    Scenario: Test PIIT Login with Invalid Credentials
    Given User has navigated to forum login page
    When User has entered invalid username and password
    And User has clicked on login button
    Then User has to be shown with error message

    Scenario: Test PIIT Login with empty Credentials
    Given User has navigated to forum login page
    When User has entered blank username and password
    And User has clicked on login button
    Then User has to be shown with error message