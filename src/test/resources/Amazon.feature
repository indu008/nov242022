#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: To validate the login functionality of amazon application

  @tag1
  Scenario: To login with valid username and invalid password
    Given To launch the browser and maximize the window
    And To launch the amazon application
    When To pass valid username in email field
    | python@gmail.com|sel@gmail.com |java@gmail.com| sql@gmail.com|cucumber@gmail.com|
    And To click the continue button
    And To enter the invalid password in password field
    |123456|sel@123|987654|
    |java@123|7654321|cucumber@123|
    |342156|sql@123|87654333245|
    And To click the signin button
    Then close the browser
    

  