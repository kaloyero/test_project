Feature: Baby cotton Brand functionality

  @deleteProduct
  Scenario Outline: delete product from cart for babyCottons

    Given User launch the URL '<URL>' of the brand
    And searching the product '<product>' in search box and click on first result in baby cottons
    And  product has been checkOut for baby cottons
    And close the popUp and news letter
    Then user delete the product and navigate to home page
    And searching the product '<product>' in search box and click on first result in baby cottons
    And  product has been checkOut for baby cottons
    Then user delete the product and navigate to home page

    Examples:
      | product | URL      |
      | remera  | url_babaycottons |

  @placeOrderSuccessfully
  Scenario Outline: placing order successfully for babyCottons

    Given User launch the URL '<URL>' of the brand
    And sign up new customer
    And getting code from mail
    And entering the password
    And searching the product '<product>' in search box and click on first result in baby cottons
    And  product has been checkOut for baby cottons
    And close the popUp and news letter
    When filling the shipping address and cart page details
    And selecting effectivo option and clicking the final pay button
    Then confirmation with mail

    Examples:
      | product | URL      |
      | remera  | url_babaycottons |

  @searchBoxItems
  Scenario Outline: search box link displayed and validate each of them for babyCottons

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    Then getting the list of item displayed in the search list and navigating each page

    Examples:
      | URL      |
      | url_babaycottons |

  @myAccChangePass
  Scenario Outline: create account and change password from my account page for babyCottons

    Given User launch the URL '<URL>' of the brand
    And sign up new customer
    And getting code from mail
    And entering the password
    And close the popUp and news letter
    When checking the account detail page
    Then changing the password

    Examples:
      | URL      |
      | url_babaycottons |