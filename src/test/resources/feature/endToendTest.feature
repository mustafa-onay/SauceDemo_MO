Feature: End to End Test
  @wip
  Scenario: Login and End To End Test
    Given user is on the login page
    When user enters "standard_user" username "secret_sauce" password and clicks on the login button
    Then verify that user can see "Products" on the Dashboard
    When user sorts products "Price (high to low)"
    And user adds the cheapest as "7.99" and the second costliest as "29.99" product
    And user opens basket
    And user clicks on checkout
    And user enters details as "batch" and "sixteen" and "DE2134"
    Then user verifies that the price is "Total: $41.02"
    And user clicks on finish button
    Then user should be able to see confirmation message as "Thank you for your order!"