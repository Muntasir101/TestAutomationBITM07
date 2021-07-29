Feature: Login Functionality Test

  Scenario: Verify Login with valid Credentials
    Given Open Browser and Navigate to Login page
    When Enter valid email and password
    When Login success
    Then Close Test