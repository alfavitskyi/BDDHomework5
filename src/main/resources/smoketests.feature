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
