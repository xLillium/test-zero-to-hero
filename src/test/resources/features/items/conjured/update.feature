Feature: Conjured Items degradation
  In order to maintain accurate inventory tracking
  As a system managing inventory items
  I want to decrease the quality of 'Conjured' items at a faster rate than normal items
  So that the system reflects their decreased usability more rapidly

  Scenario: Conjured item quality decreases twice as fast before the sell-in date
    Given a "Conjured Mana Cake" with a sell-in of 3 and a quality of 6
    When a day passes
    Then its quality should be 4
    And its sell-in should be 2