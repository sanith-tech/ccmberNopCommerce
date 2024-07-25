Feature: customer

Background: below are the common steps for every scenario
Given user launch chrome browser
When user opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters email as "admin@yourstore.com" and password as "admin" 
And click on login


Scenario: add a new customer
Then user click on customer menu
And user click on customers
And user click on add new button
Then user can view add customer details page
When user enters customer info 
And click on save button
Then user can view conformation message
And close browser

Scenario: Search customer by Email ID
Then user click on customer menu
And user click on customers
And enter customer email id 
When click on search button
Then user should found email in the search table
And close browser

Scenario: Search customer by name
Then user click on customer menu
And user click on customers
And enter customer firstname
And enter customer lastname
When click on search button
Then user should found name in the search table
And close browser  
  