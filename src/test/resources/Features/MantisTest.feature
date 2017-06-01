Feature: Bug report cycle

  Scenario: tester reports an issue
    Given User logs in as "tester1"
    And Press CreateButton
    When user fills form "tester1_issue"
    And Sabmit issue
    Then user open bug table
    And find table "assigned (dev1)"
    And logout
    Given User logs in as "dev1"
    And user open bug table
    And find table "assigned (dev1)"
    When Open task
    And check fields in issue
    And make issue resolved
    Then logout
    Given User logs in as "lead1"
    And user open bug table
    And find table "resolved (dev1)"
    When Open task
    And make issue closed
    Then user open bug table
    And turn off filters
    And find table "closed (lead1)"
