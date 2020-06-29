package fami.app.framework.steps.AirAsia;

import java.util.List;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import fami.app.framework.definitions.webDefinitions;


/**
 * airasiaSelectFlightPage.java - AirAsia Select Flight page class 
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    21 June 2020
 */

public class airasiaSelectFlightPage {
	
	/** Element Definitions **/
	
	// Top Panel Element locator
	By topWizardPanel_wizardIcon_searchFlights = By.cssSelector("#airasia-breadcrumb-span-search-link-heatmap > .material-icons");
	By topWizardPanel_wizardIcon_selectFlights = By.cssSelector("#airasia-breadcrumb-span-select-link-heatmap > .material-icons");
	
	// Depart Section element
	By departSection_label_depart = By.id("depart-return-label-desc");
	By departSection_iconButton_editFlightSearch = By.id("airasia-search-edit-button-span-header-search-pen-0-heatmap");
	
	
	
	/** Steps Definitions **/
	
	@And("^I verify the system redirect me to the Select Flights wizard page with a page title \"([^\"]*)\"$")
	public void verifyPage(String myPageId) throws Throwable {
		webDefinitions.verifyPageTitle(myPageId);
	}
	
	@And("I verify the wizard scale section existed")
	public void verifyWizardPanel() throws Throwable {
		webDefinitions.verifyElement(topWizardPanel_wizardIcon_searchFlights);
		webDefinitions.verifyElement(topWizardPanel_wizardIcon_selectFlights);
	}
	
	@And("I verify the depart section existed")
	public void verifyDepartSection() throws Throwable {
		webDefinitions.verifyElement(departSection_label_depart);
		webDefinitions.verifyElement(departSection_iconButton_editFlightSearch);
	}

	
}
		
