Feature: Free CRM Login Feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Cogmento CRM"

Scenario: Login with credentials
Given user is on login page
When user enters username password and clicks on Login button