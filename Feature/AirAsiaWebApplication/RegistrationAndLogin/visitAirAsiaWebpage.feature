Feature: airAsiaHomePage
	Accessing the Air Asia web page and verify its validity

	Scenario: User access the Air Asia Home Page
		Given I access the Air Asia web application home page
		Then I verify all the expected top panel link are available
		And I verify that the booking panel is available
		And I verify that the login panel is available
		
	Scenario: Login with without providing the credential information
		Given I access the Air Asia web application home page  
		And I verify that the login panel is available
		When I attemp to login with a blank username and password
		Then I very that the login attempt is failing with a notification message "Please enter your Email address."
		
	
	Scenario: Login with invalid user credential
		Given I access the Air Asia web application home page  
		And I verify that the login panel is available
		When I attemp to login with an invalid username and password 
		Then I very that the login attempt is failing with a notification message "Please enter a valid email (e.g: example@email.com)"
		