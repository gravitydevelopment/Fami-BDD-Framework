Feature: airAsiaHomePage
	Accessing the Air Asia web home page and verify its validity

	Scenario: User access the Air Asia Home Page
		Given I access the Air Asia web application home page
		Then I verify all the expected top panel link are available
		And I verify that the booking panel is available
		And I verify that the login panel is available
	
	Scenario: Login with invalid user credential
		Given I access the Air Asia web application home page
		Then I verify all the expected top panel link are available
		And I verify that the booking panel is available
		And I verify that the login panel is available
		