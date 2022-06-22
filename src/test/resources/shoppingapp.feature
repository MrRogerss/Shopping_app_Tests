Feature: price calculation
  Scenario: Customer wants free shipping, so they spend over $50 and select standard shipping
    Given Customer has items that total 55.00
    And Customer lives in "GA"
    And Customer selects "Standard" shipping
    Then the final price is 55.00

    Scenario: Customer chooses next day shipping, therefore it costs extra and free shipping doesn't apply
      Given Customer has items that total 100.00
      And Customer lives in "WY"
      And Customer selects "Next Day" shipping
      Then the final price is 125.00
      
      Scenario: Customer lives in Illinois, therefore he must be taxed for his purchase
        Given Customer lives in "IL"
        And Customer has items that total 30.00
        And Customer selects "Standard" shipping
        Then the final price is 41.80


