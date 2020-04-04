Feature:Lumi_Place_Order
@pass
  Scenario:User Can Log Into PowerPuff And Place Order
    Given I log into Lumi as a customer user
    And I select an item to purchase
    And I place the item into the cart
    When I complete the purchase of the order
    Then I will see the order confirmed

@fail
  Scenario:User Can Log Into PowerPuff And Place Order and Filter the Page
    Given I log into Lumi as a customer user
    And I select an item to purchase
    And I place the item into the cart
    When I complete the purchase of the order
    Then I will see the order confirmed
    And I can filter the page
