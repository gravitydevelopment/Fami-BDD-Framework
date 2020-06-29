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
		And I select the departure and return date
		| 10/07/2020 | 27/07/2020 |
		When I click the flight search button and verify that the system redirect me to the Select Flight web page
		Then I verify the system redirect me to the Select Flights wizard page with a page title "Select Cheap Flights Tickets | AirAsia"
		And I verify the wizard scale section existed
		And I verify the depart section existed