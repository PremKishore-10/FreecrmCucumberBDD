Feature: Free CRM HomePage Feature

Background:
Given user has already logged in to application

Scenario: Account Name
Given user gets the account name
Then account name should be valid


Scenario: click on Contacts Page
Given user is on Home Page
Then user should click on Contacts icon

Scenario: click on Calendar Page
Given user is on Home Page
Then user should click on Calendar icon