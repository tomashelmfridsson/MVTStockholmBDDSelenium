Feature: Test of Tricentis webpage
  Scenario: Verify book
    Given I am at tricentis page
    When I go to menu "BOOKS"
    Then I see the book "Fiction"

  Scenario Outline: Verify items
    Given I am at tricentis page
    When I go to menu <categories>
    Then I see the book <item>

    Examples:
     | categories       | item                            |
     | "BOOKS"          | "Fiction"                       |
     | "BOOKS"          | "Computing and Internet"        |
     | "JEWELRY"        | "Black & White Diamond Heart"   |
     | "JEWELRY"        | "Create Your Own Jewelry"       |
