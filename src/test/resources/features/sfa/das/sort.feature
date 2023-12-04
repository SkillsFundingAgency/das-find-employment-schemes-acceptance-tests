
Feature: Find schemes for your business - sorting schemes

  @javascript_needed
  Scenario: Schemes are sorted base on No Sort, Popularity, Duration and Cost
    Given the user navigates to the "HOME" page
    Then schemes are correctly sorted based on the chosen sort

