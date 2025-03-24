Feature: Test of Tricentis webpage
  Scenario: Verify book
    Given I am on page "https://demowebshop.tricentis.com/"
    When I go to menu "BOOKS"
    Then I see the book "Fiction"