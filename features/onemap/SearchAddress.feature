Feature: To Test the Search Address Functionality for One Map


  @onemap
  Scenario: Verify when the valid address is searched an infobox is displayed with correct details
    Given The user enters the "Millenia Walk" using Search Address field
    When The user clicks on "Address":"Dropdown"
    Then Verify following details are present on Info Box
      | Detail        | Text                                               |
      | Info Title    | WHAT'S HERE SEARCH                                 |
      | Info Name     | MILLENIA WALK                                      |
      | Info Address  | 9 RAFFLES BOULEVARD MILLENIA WALK SINGAPORE 039596 |
      | Info Position | 1.2926055,103.859725                               |


  # Assuming that search via geo coordinates is possible and this test will fail.
  @onemap
  Scenario: Verify when the address is search via geo coordinates then infobox is displayed with correct details
    Given The user enters the "1.2926055,103.859725" using Search Address field
    And The user press enters on "Address":"Input"
    Then Verify following details are present on Info Box
      | Detail        | Text                                               |
      | Info Title    | WHAT'S HERE SEARCH                                 |
      | Info Name     | MILLENIA WALK                                      |
      | Info Address  | 9 RAFFLES BOULEVARD MILLENIA WALK SINGAPORE 039596 |
      | Info Position | 1.2926055,103.859725                               |

 # Assuming that search via pincode is possible
  @onemap
  Scenario: Verify when the address is searched with a pincode an infobox is displayed with correct details
    Given The user enters the "039596" using Search Address field
    When The user clicks on "Address":"Dropdown"
    Then Verify following details are present on Info Box
      | Detail        | Text                                               |
      | Info Title    | WHAT'S HERE SEARCH                                 |
      | Info Name     | MILLENIA WALK                                      |
      | Info Address  | 9 RAFFLES BOULEVARD MILLENIA WALK SINGAPORE 039596 |
      | Info Position | 1.2926055,103.859725                               |

  @onemap
  Scenario: Verify when the invalid address is searched then the address dropdown is not displayed
    Given The user enters the "Mumbai" using Search Address field
    Then Verify "Address":"Dropdown" is not present on One Map
