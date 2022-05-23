Feature: AdmitOne Brand functionality

  @deleteProduct @BA-1401
  Scenario Outline: delete product from cart for admitone

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And searching the product '<product>' in search box and click on first result in admitOne
    And  product has been checkOut for admitOne
    Then user delete the product and navigate to home page
    And searching the product '<product>' in search box and click on first result in admitOne
    And  product has been checkOut for admitOne
    Then user delete the product and navigate to home page

    Examples:
      | product | URL      |
      | remera  | url_admitone |

  @placeOrderSuccessfully
  Scenario Outline: placing order successfully for admitone

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    And searching the product '<product>' in search box and click on first result in admitOne
    And  product has been checkOut for admitOne
    When filling the shipping address and cart page details
    And selecting effectivo option and clicking the final pay button
    Then confirmation with mail

    Examples:
      | product | URL      |
      | remera  | url_admitone |

  @searchBoxItems
  Scenario Outline: search box link displayed and validate each of them for admitone

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    Then getting the list of item displayed in the search list and navigating each page

    Examples:
      | URL      |
      | url_admitone |

  @myAccChangePass
  Scenario Outline: create account and change password from my account page for admitone

    Given User launch the URL '<URL>' of the brand
    And close the popUp and news letter
    And sign up new customer
    And getting code from mail
    And entering the password
    When checking the account detail page
    Then changing the password

    Examples:
      | URL      |
      | url_admitone |