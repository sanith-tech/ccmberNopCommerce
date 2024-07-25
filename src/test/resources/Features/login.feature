Feature: login
@sanity
Scenario: Successful login with valid credentials
Given user launch chrome browser
When user opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters email as "admin@yourstore.com" and password as "admin" 
And click on login 
Then page title should be "Dashboard / nopCommerce administration"
When user click o logout link
Then page title should be "Your store. Login"
And close browser

Scenario Outline:
Given user launch chrome browser
When user opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters email as "<name>" and password as "<password>" 
And click on login 
Then page title should be "Dashboard / nopCommerce administration"
When user click o logout link
Then page title should be "Your store. Login"
And close browser

Examples:
 |name|password|
 |admin@yourstore.com|admin|
 |admin1@yourstore.com|admin1|