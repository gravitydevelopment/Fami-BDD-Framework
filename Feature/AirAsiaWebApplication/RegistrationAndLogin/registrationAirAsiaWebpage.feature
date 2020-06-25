#Author: Fami , gravitydevelopment@gmail.com

@fea01_02
Feature: registrationAirAsiaWebpage
	Accessing the Air Asia web page and the registration
	
	@fea01_02_sce01
	Scenario: Login with without providing the credential information
		Given I access the Air Asia web application home page  
		And I verify that the login panel is available
		When I attemp to login with a blank username and password
		Then I very that the login attempt is failing with a notification message "Please enter your Email address."
		
	@fea01_02_sce02
	Scenario: Login with invalid user credential
		Given I access the Air Asia web application home page  
		And I verify that the login panel is available
		When I attemp to login with an invalid username and password 
		Then I very that the login attempt is failing with a notification message "Please enter a valid email (e.g: example@email.com)"
		