@navigations
Feature:navigations

  @Contact
  Scenario: Creating new contact on https://confidens.zetes.com/contact as a user
    Given user goes to the url
    When User clicks People ID button
    And User clicks TRUST SERVICES button
    And User clicks CONTACT button
    Then User enters firstname as "firstname"
    Then User enters lastname as "lastname"
    And  User provides email as "email"
    And User enters country name as "country"
    When User enters company as "company"
    And User enters business phone as "busphone"
    And User enters own message as "message"
    Then User clicks yes or no checkbox
    And User click on submit button and verifies confirmation message