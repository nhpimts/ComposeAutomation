Feature: Gmail Login

Scenario: User lands on Gmail
Given user is on Gmail
When user clicks  on Sign in
Then user clicks on email

Scenario: Login with correct credentials
Given user is on Gmail
And user is on login page
When user clicks  on Sign in
And user enters username "dummy@dummy.com"
And user clicks on Next button
And user enters password "DummDumm"
And user clicks on Next button
Then user gets the title of the page
And page title should be "Gmail"