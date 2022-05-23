Feature: filaar Brand functionality

  @deleteProduct
  Scenario Outline: delete product from cart for filaar

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And searching the product '<product>' in search box and click on first result in filaar
    And  product has been checkOut for filaar
    Then user delete the product and navigate to fila home page
    And searching the product '<product>' in search box and click on first result in filaar
    And  product has been checkOut for filaar
    Then user delete the product and navigate to fila home page

    Examples:
      | product | URL      |
      | remera  | url_fila |

  @placeOrderSuccessfully
  Scenario Outline: placing order successfully for filaar

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    And searching the product '<product>' in search box and click on first result in filaar
    And  product has been checkOut for filaar
    When filling the shipping address and cart page details
    And clicking on comprar button
    And selecting effectivo option
    And selecting the final pay button
    Then confirmation with mail

    Examples:
      | product | URL      |
      | remera  | url_fila |

  @searchBoxItems
  Scenario Outline: search box link displayed and validate each of them for filaar

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    Then getting the list of item displayed in the search list and navigating each page

    Examples:
      | URL      |
      | url_fila |

  @myAccChangePass
  Scenario Outline: create account and change password from my account page for filaar

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    When checking the account detail page
    Then changing the password

    Examples:
      | URL      |
      | url_fila |