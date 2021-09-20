Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks on search button
    And User clicks first product to wishlist
    And User clicks wishlist button
    Then User checks that amount of products in wish list are '<amountOfProducts>'
    Examples:
      | homePage                            | keyword     | amountOfProducts |
      | https://www.asos.com/               | sneakers    | 1                |

  Scenario Outline: Check registration
    Given User opens '<homePage>' page
    And User checks search Account button visibility
    And User checks search My account button visibility
    And User clicks Join in registration tab
    And User puts  email '<email>' in registration form
    And User puts  first name '<firstName>' in registration form
    And User puts  last name '<lastName>' in registration form
    And User puts  password '<password>' in registration form
    And User selects day <day> in registration form
    And User selects month <month> in registration form
    And User selects year <year> in registration form
    And User submits registration
    And User goes to My details in My Account
    Then User checks successful registration with email '<expectedEmail>'

    Examples:
      | homePage                | email                    | firstName        |lastName |password      |day|month|year|expectedEmail        |
      | https://www.asos.com/   | testemail99@gmail.com    | test             |test     |password123456|2  |2    |8   |testemail99@gmail.com|