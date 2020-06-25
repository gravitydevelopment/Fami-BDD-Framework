#Author: Fami , gravitydevelopment@gmail.com

@fea02_01
Feature: bookingFlightFromFlightPanel
	Accessing the Air Asia web page and verify its validity
	
	Background: Accessing the AirAsia Home Web page
	  Given I access the Air Asia web application home page 

	@fea02_01_sce01
	Scenario: Accessing and verify the select flights page
		Given I verify that the booking panel is available 
		And I select the departure destination "Penang"
		When I click the flight search button