Feature: Login Functionality
  As a user, I should be able to login with different credentials

  Background:
    Given user is on the login page


  Scenario Outline: positive login test with DDT
    When user enters "<username>" username "<password>" password and clicks on the login button
    Then verify that user can see "Products" on the Dashboard
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: negative login test with DDT "<username>"
    When user enters "<username>" username "<password>" password and clicks on the login button
    #Then verify that user can see "Products" on the Dashboard
    Then verify that user should be able to see warning message as '<expectedMessage>'
    Examples:
      | username               | password     | expectedMessage                                                           |
      | standard_user          |              | Epic sadface: Password is required                                        |
      |                        | secret_sauce | Epic sadface: Username is required                                        |
      | erformance_glitch_user | seret_sauce  | Epic sadface: Username and password do not match any user in this service |
      | error_user68           | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user        | secret_sauce | Epic sadface: Username is required                                        |