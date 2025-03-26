Feature: Petshop tests
  Scenario: Add an item to cart
    Given I am at petshop page
    When I add item "KONG Pull-A-Partz Pinata"
    Then The cart includes 1 "KONG Pull-A-Partz Pinata"


