Feature: Mimo Brand functionality

  @deleteProduct
  Scenario Outline: delete product from cart for mimo

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And searching the product '<product>' in search box and click on first result
    And  product has been checkOut
    Then user delete the product and navigate to home page
    And searching the product '<product>' in search box and click on first result
    And  product has been checkOut
    Then user delete the product and navigate to home page

    Examples:
      | product | URL      |
      | remera  | url_mimo |

  @placeOrderSuccessfully
  Scenario Outline: placing order successfully for mimo

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    And searching the product '<product>' in search box and click on first result
    And  product has been checkOut
    When filling the shipping address and cart page details
    And select mercado pago options  and clicking on comprar button
    And selecting effectivo option
    And selecting the final pay button
    Then confirmation with mail

    Examples:
      | product | URL      |
      | remera  | url_mimo |

  @searchBoxItems
  Scenario Outline: search box link displayed and validate each of them for mimo

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    Then getting the list of item displayed in the search list and navigating each page

    Examples:
      | URL      |
      | url_mimo |

  @myAccChangePass
  Scenario Outline: create account and change password from my account page for mimo

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    When checking the account detail page
    Then changing the password

    Examples:
      | URL      |
      | url_mimo |