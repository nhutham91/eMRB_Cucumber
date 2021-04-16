Feature: Project

  Background:
    Given sign in page is open
    When I enter username "duong" and password "123456"
    And I click login
    Then I should see Home page

  Scenario: Add new project
    Given I navigate to menu item "Administration->Projects"
    When I click Add New
    And Enter project info
      | ProjectNo | ProjectName | SerialNo  |
      | TestProject2  | Test project 2  | 123456  |
    And Click Save
    Then I should see project saved successfully

  Scenario: Search project
    Given I navigate to menu item "Administration->Projects"
    When I search "TestProject2"
    Then I should see the project "TestProject2"

  Scenario: Delete project
    Given I navigate to menu item "Administration->Projects"
    When I search "TestProject2"
    And click Delete icon on that project "TestProject2"
    Then I should not see the project