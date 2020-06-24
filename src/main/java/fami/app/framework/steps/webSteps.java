package fami.app.framework.steps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import fami.app.framework.AutomationRunner;
import fami.app.framework.definitions.webDefinitions;
import fami.app.framework.engine.selenium;
import fami.app.framework.helpers.testLogger;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * webSteps.java - Test step definitions functions 
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    19 June 2020
 */

public class webSteps {
	
	private static final testLogger log = testLogger.getLogger("fami.app.framework.stepDefinitions.webStep");
	
	//public static WebDriver driver = AutomationRunner.driver;
	
	@Given("^I access the web page \"([^\"]*)\"$")
	public void accessHomePage(String pageURL) throws Throwable {
		webDefinitions.accessPage(pageURL, AutomationRunner.driver);
	}
	
//	@And("^I verify \"([^\"]*)\" page name is correct$")
//	public void verifyPageId(String pageName) throws Throwable {
//		webDefinitions.verifyPageid(pageName, driver, getMapVal(pageMap, pageName, 1));
//	}
//	
//	@And("^I verify the system redirect me to \"([^\"]*)\"$")
//	public void verifyRedirectPageId(String pageName) throws Throwable {
//		webDefinitions.verifyPageid(pageName,driver, getMapVal(pageMap, pageName, 1));
//	}
//	
//	@And("^I verify the element \"([^\"]*)\" is exist$")
//	public void verifyElementExist(String elementName) throws Throwable {
//		webDefinitions.verifyElement(elementName, driver, 
//				getMapVal(elementMap, elementName, 3),
//				getMapVal(elementMap, elementName, 1), 
//				getElementsLocValues(elementMap, elementName,(getMapVal(elementMap, elementName, 3))));
//	}
//				
//	@And("^I click the \"([^\"]*)\" link$")
//	public void clickLink(String elementName) throws Throwable {
//		
//		webDefinitions.clickLink(driver, //myDriver, myElementType, myElementLabel, myElementLocator
//				getMapVal(elementMap, elementName, 3),
//				getMapVal(elementMap, elementName, 1), 
//				getElementsLocValues(elementMap, elementName,(getMapVal(elementMap, elementName, 3))));
//	}
//	
//	@And("^I click the \"([^\"]*)\" button$")
//	public void clickButton(String elementName) throws Throwable {
//		
//		webDefinitions.clickButton(driver, //myDriver, myElementType, myElementLabel, myElementLocator
//				getMapVal(elementMap, elementName, 3),
//				getMapVal(elementMap, elementName, 1), 
//				getElementsLocValues(elementMap, elementName,(getMapVal(elementMap, elementName, 3))));
//	}
//
//	@And("^I enter value \"([^\"]*)\" in \"([^\"]*)\" Entry Field$")
//	public void insertValtoEntryField(String inputValues, String elementName) throws Throwable {
//		
//		webDefinitions.insertEntryFields(driver, //myDriver, myElementType, myElementLabel, myElementLocator
//				getMapVal(elementMap, elementName, 3),
//				getMapVal(elementMap, elementName, 1), 
//				getElementsLocValues(elementMap, elementName,(getMapVal(elementMap, elementName, 3))),
//				inputValues);
//	}
//	
//	@And("^I verify the value in \"([^\"]*)\" entry field is \"([^\"]*)\"$")
//	public void veryValueInEntryField(String elementName, String inputValues) throws Throwable {
//		
//		webDefinitions.verifyEntryFieldValue(driver, //myDriver, myElementType, myElementLabel, myElementLocator
//				getMapVal(elementMap, elementName, 3),
//				getMapVal(elementMap, elementName, 1), 
//				getElementsLocValues(elementMap, elementName,(getMapVal(elementMap, elementName, 3))),
//				inputValues);
//	}
//	
//	/* CUSTOM INPUT ARGUMENTS TEST VERBS */
//	
//	@Given("^I access the url \"([^\"]*)\"$")
//	public void accessUrl(String url) throws Throwable { webDefinitions.accessPage("", driver, url);}
//	
//	@And("^I verify the current page name is \"([^\"]*)\"$")
//	public void verifyPageName(String pageName) throws Throwable {
//		webDefinitions.verifyPageid("", driver, pageName);
//	}
//	
//	/* GENERAL INPUT ARGUMENTS TEST VERBS */
//	
//	@And("^I close the browser$") 
//	public void closeBrowser() throws Throwable {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.close();
//		}
//	
//	@And("^I start browser$") 
//	public void startBrowser() throws Throwable {
//		selenium.initialize(driver);
//		}

}
