package fami.app.framework.steps;

import org.openqa.selenium.By;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import fami.app.framework.AutomationRunner;
import fami.app.framework.definitions.webDefinitions;
import fami.app.framework.helpers.testLogger;


/**
 * airasiaHomepage.java - AirAsia Homepage class 
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    21 June 2020
 */

public class airasiaHomepage {
	
	private static final testLogger log = testLogger.getLogger("fami.app.framework.stepDefinitions.webStep");
	
	// Top Panel Element locator
	By topPanel_linktext_mybooking = By.linkText("My bookings");
	By topPanel_linktext_checkin = By.linkText("Check-in");
	By topPanel_linktext_flightstatus = By.linkText("Flight status");
	By topPanel_linktext_support = By.linkText("Support");
	By topPanel_button_loginsignup = By.xpath("//*[@id=\"loginModal\"]");
	
	// Booking Panel Element locator
	By bookingPanel_entryField_destinationfrom = By.xpath("//div[@id='my-react']/div/div");
	By bookingPanel_entryField_destinationto = By.xpath("//*[@id=\"my-react\"]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");                                                  
	By bookingPanel_entryField_promo = By.xpath("//div[@id='my-react']/div/div/div[2]/div[3]/div/div/input");
	By bookingPanel_datePicker_datedepart = By.xpath("//input[@value='04/07/2020']");
	By bookingPanel_datePicker_datereturn = By.xpath("//input[@value='07/07/2020']");
	By bookingPanel_button_searchbooking = By.id("aa-web-search-button");
	
	
	// LoginSignUp Panel Element locator
	By loginSignupPanel_entryField_username = By.xpath("//*[@id=\"sso-login-email-input\"]");
	By loginSignupPanel_entryField_password = By.xpath("//*[@id=\"sso-login-password-input\"]");
	By loginSignupPanel_button_login = By.xpath("//*[@id=\"sso-login-signup-widget\"]/div[1]/div[1]/div[1]/section[1]/aa-tabs[1]/div[1]/section[1]/aa-tab[1]/div[1]/sso-login[1]/div[1]/form[1]/button[1]");
	By loginSignupPanel_linkText_forgotpassword = By.xpath("//*[@id=\"sso-login-signup-widget\"]/div[1]/div[1]/div[1]/section[1]/aa-tabs[1]/div[1]/section[1]/aa-tab[1]/div[1]/sso-login[1]/div[1]/form[1]/div[3]/a[1]");
	
	
	
	
	
	
	
	@Given("I access the Air Asia web application home page")
	public void accessHomePage() throws Throwable {
		webDefinitions.accessPage("https://www.airasia.com/en/gb", AutomationRunner.driver);
	}
	
	@And("I verify all the expected top panel link are available")
	public void verifyTopPanel() throws Throwable {
		webDefinitions.verifyElement(AutomationRunner.driver, topPanel_linktext_mybooking);
		webDefinitions.verifyElement(AutomationRunner.driver, topPanel_linktext_checkin);
		webDefinitions.verifyElement(AutomationRunner.driver, topPanel_linktext_flightstatus);
		webDefinitions.verifyElement(AutomationRunner.driver, topPanel_linktext_support);
		webDefinitions.verifyElement(AutomationRunner.driver, topPanel_button_loginsignup);
	}
	
	@And("I verify that the booking panel is available")
	public void verifyBookingPanel() throws Throwable {
		webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_entryField_destinationfrom);
		webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_entryField_destinationto);
		//webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_datePicker_datedepart);
		//webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_datePicker_datereturn);
		webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_button_searchbooking);
		webDefinitions.verifyElement(AutomationRunner.driver, bookingPanel_entryField_promo);
	}
	
	@And("I verify that the login panel is available")
	public void verifyLoginPanel() throws Throwable {
		webDefinitions.clickElement(AutomationRunner.driver, topPanel_button_loginsignup);
		webDefinitions.verifyElement(AutomationRunner.driver, loginSignupPanel_entryField_username);
		webDefinitions.verifyElement(AutomationRunner.driver, loginSignupPanel_entryField_password);
		webDefinitions.verifyElement(AutomationRunner.driver, loginSignupPanel_button_login);
		webDefinitions.verifyElement(AutomationRunner.driver, loginSignupPanel_linkText_forgotpassword);
	}
	
	
	
	
	
}




