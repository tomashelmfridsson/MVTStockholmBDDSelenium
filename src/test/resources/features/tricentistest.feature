Feature: Test of Tricentis webpage
  Scenario: Verify book
    Given I am on page "https://demowebshop.tricentis.com/"
    When I go to menu "BOOKS"
    Then I see the book "Fiction"

  Scenario Outline: Verify items
    Given I am on page "https://demowebshop.tricentis.com/"
    When I go to menu <categories>
    Then I see the book <item>

    Examples:
     | categories | item      |
     | "BOOKS"    | "Fiction" |