Feature:verifyy login module
Scenario Outline:
:verifying omrbranch login with valid credentials
Given user is on the omrbranch page
When user enter the "<username>" and "<password>"
And user click the login button
Then user should verify success message after login

Examples:

|username|password|
|sudhakar.k8383@gmail.com|Cricket@123|

Scenario Outline:
:Explore Hotels 
Given user is on the omrbranch page
When user enter "<state>" in select state dropdown
And user enter "<City>" in select city dropdown
And user enter "<Room Type>" in select state dropdown
