@navigations
Feature:navigations

  @ContactPositive
  Scenario: Creating new contact on https://confidens.zetes.com/contact as a user
#    Given user goes to the url
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

  @ContactNegative
  Scenario Outline: Creating new contact on https://confidens.zetes.com/contact as a user in negative scenario

    When User clicks People ID button
    And User clicks TRUST SERVICES button
    And User clicks CONTACT button
    Then User enters nfirstname as "<firstname>"
    Then User enters nlastname as "<lastname>"
    And  User provides nemail as "<email>"
    And User enters ncountry name as "<country>"
    When User enters ncompany as "<company>"
    And User enters nbusiness phone as "<busphone>"
    And User enters own nmessage as "<message>"
    Then User clicks yes or no checkbox
    And User click on submit button and verifies negative confirmation message
    Examples: user info lari
      | firstname | lastname |  email            | country |company|busphone|message|
      | 12345     | ozturk   | abc@gmail.com     | Belgium |ABC    |12345678|messsage|
#      | fatma     | 5673     | abc@gmail.com     | Belgium |ABC    |12345678|messsage|
#      | fatma     | ozturk     | @#$$%%%@gmail.com     | Belgium |ABC    |12345678|messsage|