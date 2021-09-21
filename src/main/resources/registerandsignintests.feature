Feature: SmokeRegisterAndSignIn
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

Scenario Outline: Check registration
Given User opens '<homePage>' page
And User checks search Account button visibility
And User clicks on personal account button
And User checks search My account button visibility
And User clicks join on main page
And User puts email '<email>' in registration form
And User puts  first name '<firstName>' in registration form
And User puts  last name '<lastName>' in registration form
And User puts  password '<password>' in registration form
And User selects day <day> in registration form
And User selects month <month> in registration form
And User selects year <year> in registration form
And User submits registration
And User clicks on personal account button
And User clicks on MyAccount button
Then User checks that signing in was successful in MyAccount with name '<expectedName>'

Examples:
| homePage                | email                         | firstName             |lastName     |password      |day|month|year|expectedName           |
| https://www.asos.com/   | alfavitskyi@gmail.com         | testFirst             |testLast     |password123457|2  |2    |8   |testFirst testLast     |

Scenario Outline: Check sign in
Given User opens '<homePage>' page
And User checks search Account button visibility
And User clicks on personal account button
And User checks search My account button visibility
And User clicks on MyAccount button
And User puts email '<email>' for sign in my account
And User puts password '<password>' for sign in my account
And User clicks Sign In button

Then User checks that signing in was successful in MyAccount with name '<expectedUserName>'

Examples:
| homePage                | email                       |password      |expectedUserName|
| https://www.asos.com/   | kalyna.46.21@gmail.com      |password123456|Petro Petro     |