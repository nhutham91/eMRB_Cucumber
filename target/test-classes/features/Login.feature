Feature: Login

  Scenario: user login eMRB successfully
    Given sign in page is open
    When I enter username "duong" and password "123456"
    And I click login
    Then I should see Home page
