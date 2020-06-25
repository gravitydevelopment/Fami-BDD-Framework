#Author: Fami , gravitydevelopment@gmail.com

@fea01_01
Feature: visitAirAsiaWebpage
	Accessing the Air Asia web page and verify its validity

  @fea01_01_sce01
	Scenario: User access the Air Asia Home Page
		Given I access the Air Asia web application home page
		Then I verify all the expected top panel link are available
		And I verify that the booking panel is available
		And I verify that the login panel is available