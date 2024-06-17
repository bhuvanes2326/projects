Feature: TS_006_Corporate Wellness Demo Form

  Background: 
    Given Click on Corporate Wellness Form
    And Enter the name
    And Enter the Organization name
    And selects the organization size
    And select the Interested in option

  Scenario Outline: Login-button Disabled
    When user enter the contact number as "<phone number>"
    And user enter the email id as "<email id>"
    But Login button should be Disabeld

    Examples: 
      | phone number | email id          |
      |   8778109693 | bhuvi.boss        |
      |  98067331227 | bhuvi03@gmail.com |
      |  96008351227 | boss.com          |

  Scenario Outline: Login-button enabled
    When user enter the contact number as "<phone number>"
    And user enter the email id as "<email id>"
    Then Login button should be enabeld

    Examples: 
      | phone number | email id          |
      |   8778109693 | bhuvi03@gmail.com |
