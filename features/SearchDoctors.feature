Feature: Validation of Searching doctors

  Scenario: Finding List of dentist
    Given user navigates to Practo Home page
    And user Enters city as "Bangalore"
    And user enters doctor specialist as "Dentist"
    When user navigates to applied filter page
    And applies filters
    Then print details of Doctors 