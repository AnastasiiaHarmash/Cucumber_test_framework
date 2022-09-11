Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  #Scenario Outline: User selects a filter after searching for a product
  #  Given User opens '<homePage>' page
  #  And User checks search field visibility
  #  And User makes search by keyword '<keyword>'
  #  And User clicks search button
  #  And User waits until the filter buttons are visible
  #  When User clicks on the Apple filter button
  #  And User checks that the number of filters is visible
  #  Then User checks that the filter is selected '<numberOfSelectedFilters>'

  #  Examples:
  #    | homePage                | keyword  | numberOfSelectedFilters |
  #    | https://www.amazon.com/ | iphone   | 2                       |

  Scenario Outline: Check that the URL contains the search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that current URL contains search word '<urlContainsWord>'

    Examples:
    | homePage                | keyword  | urlContainsWord |
    | https://www.amazon.com/ | samsung  | =samsung        |
    | https://www.amazon.com/ | logitech | =logitech       |

  Scenario Outline: Check that the search results contain the search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then Check that elements <numberOfElements> match the request '<searchElementContainsWord>'

    Examples:
    | homePage                | keyword | numberOfElements | searchElementContainsWord |
    | https://www.amazon.com/ | iphone  | 16               | iphone                     |

  Scenario Outline: Check the error message when trying to login with invalid data
    Given User opens '<homePage>' page
    And User clicks on a button Sigh-in
    When User enters incorrect data '<incorrectLoginData>' in the login field
    And The user clicks on the continue button
    Then An error message appears '<errorMessage>'

    Examples:
    | homePage                | incorrectLoginData | errorMessage                                      |
    | https://www.amazon.com/ | examplemail@com    | We cannot find an account with that email address |
    | https://www.amazon.com/ | 380502222222       | We cannot find an account with that mobile number |

  Scenario Outline: Check that product categories open correctly
    Given User opens '<homePage>' page
    And User checks that the field with the category selection is visible
    When User clicks on the category Computers and Accessories
    Then User checks that the computers category '<categoryName>' is active

    Examples:
    | homePage                | categoryName |
    | https://www.amazon.com/ | Computers    |

  Scenario Outline: User checks that the cart is empty
    Given User opens '<homePage>' page
    And User checks that the shopping cart icon is visible
    When User clicks on the shopping cart icon
    And User checks that the cart field is visible
    And User checks that the number of items in the cart = '<numberOfItems>'
    Then User checks that the cart is empty '<message>'

    Examples:
    | homePage                | message                   | numberOfItems |
    | https://www.amazon.com/ | Your Amazon Cart is empty | 0             |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on the first item in the list
    And User checks that the add to cart button is visible and available
    When User clicks Add to Cart button
    And User checks that the shopping cart icon is visible
    Then User checks that the number of items in the cart = '<numberOfItems>'

    Examples:
    | homePage                | keyword                 | numberOfItems |
    | https://www.amazon.com/ | iphone 13 pro max case  | 1             |

  Scenario Outline: Remove an item from the cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on the first item in the list
    And User checks that the add to cart button is visible and available
    And User clicks Add to Cart button
    And User checks that the shopping cart icon is visible
    And User checks that the number of items in the cart = '<numberOfItems>'
    And User clicks on the shopping cart icon
    And User checks that the cart field is visible
    When The user removes an item from the cart
    And User checks that the cart field is visible
    Then User checks that the number of items in the cart = '<numberOfItemsAfterDelete>'

    Examples:
    | homePage                | keyword  | numberOfItems | numberOfItemsAfterDelete |
    | https://www.amazon.com/ | iphone   | 1             | 0                        |

  Scenario Outline: User enters the wrong email in the registration field
    Given User opens '<homePage>' page
    And User scroll page to the New Customer button
    And User clicks on a New Customer button
    When User enters wrong email address in email field '<incorrectEmail>'
    And User clicks the Continue button
    Then User checks that the error message is visible

    Examples:
    | homePage                | incorrectEmail  |
    | https://www.amazon.com/ | testemail.com   |

    Scenario Outline: User adds two units of the same product to the cart
      Given User opens '<homePage>' page
      And User checks search field visibility
      And User makes search by keyword '<keyword>'
      And User clicks search button
      And User clicks on the first item in the list
      And User checks that the add to cart button is visible and available
      And User checks that the Quantity container is visible
      And User clicks on Quantity container
      And User checks that the dropdown list is visible
      When User clicks on number two in the dropdown list
      And User checks that the selected number is equal to two
      And User checks that the add to cart button is visible and available
      And User clicks Add to Cart button
      And User checks that the shopping cart icon is visible
      Then User checks that the number of items in the cart = '<numberOfItems>'

      Examples:
      | homePage                | keyword  | numberOfItems |
      | https://www.amazon.com/ | iphone   | 2             |






