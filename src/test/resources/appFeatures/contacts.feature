Feature: Free CRM ContactsPage Feature

Background:
Given user is already in Contacts Page

Scenario: select a contact name
Given user gets the contact name to select
Then user should select the contact

Scenario Outline: create a new contact
Given user creates a new contact from given sheetname "<SheetName>" and  rownumber <RowNumber>
And user validates the new contact

Examples:
|SheetName|RowNumber|
|NewContact|2|