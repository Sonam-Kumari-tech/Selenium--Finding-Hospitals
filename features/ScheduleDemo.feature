Feature: Validation of Schedule a Demo Form

  Scenario: Login-button Disabled
    Given user Open Practo Home page
    And user click on For corparates dropdown select Health & Wellness Plans
    And Enter the name
    And Enter the Organization name
    And Enter the contact number
    And Enter the invalid email id
    And select the organization size
    And select the Interested in option
    Then schedule a demo button should be disabled

  Scenario Outline: Login-button Status
    Given user Open Practo Home page
    And user click on For corparates dropdown select Health & Wellness Plans
    And Enter the name
    And Enter the Organization name
    And Enter the contact number
    And Enter email as "<email>"
    And select the organization size
    And select the Interested in option
    Then schedule a demo button should be enabled

    Examples: 
      | email                |
      | sonam123gmail        |
      | abhinav123@gmail.com |

  Scenario: Validation for Thank you
    Given user Open Practo Home page
    And user click on For corparates dropdown select Health & Wellness Plans
    And Enter the name
    And Enter the Organization name
    And Enter the contact number
    And Enter the valid email id
    And select the organization size
    And select the Interested in option
    Then click schedule a demo button
    Then validate thank you message
