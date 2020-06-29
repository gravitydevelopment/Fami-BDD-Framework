package fami.app.framework.definitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import fami.app.framework.AutomationRunner;
import fami.app.framework.helpers.testLogger;

/**
 * webDefinitions.java - The webDefinitions class contain a method from the parent
 * class webActions, where the required input parameters for the method were defined
 * through the initialization of a new values within the class members variable in
 * constructor.
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    20 June 2020
 */

public class webDefinitions {
	
	private static final testLogger log = testLogger.getLogger("fami.app.framework.definitions.webDefinitions");
	public static WebDriver driver = AutomationRunner.driver;
	
	
	/**
	 * This is a method to initialize the browser object with the website url
	 * @param myDriver Webdriver object
	 * @param myUrl Designated web url
	 */
	public static void accessPage(String myUrl) {
		
		if (myUrl.isEmpty()) { log.error("The provided url is blank, unable to access the webpage" );}
		else { log.info("STEP::Accessing webpage url: " + myUrl); }
		
		driver.get(myUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This is a method to verify the web element
	 * @param myDriver Webdriver object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 */
	public static void verifyElement(By myElement) {
		driver.findElement(myElement);   
	}

	/**
	 * This is a method to interact with the web element by inserting an input value
	 * @param myDriver Webdriver object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */
	public static void insertValueElement(By myElement, String myValue) {
		driver.findElement(myElement).sendKeys(myValue);   
	}

	/**
	 * This is a method to interact with the web element by inserting an input value and perform an enter key press action
	 * @param myDriver Webdriver object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */		
	public static void insertValueAndEnter(By myElement, String myValue) {
		driver.findElement(myElement).sendKeys(myValue); 
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	/**
	 * This is a method to interact with the web element by clicking the element object
	 * @param myDriver Webdriver object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 */	
	public static void clickElement(By myElement) {
		driver.findElement(myElement).click();
		try {Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
	}

	/**
	 * This is a method to verify the value hold by a web element object
	 * @param myDriver Webdriver object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */	
	public static void verifyElementTextValue(By myElement, String myValue) {
		String actualValue = driver.findElement(myElement).getText();
		Assert.assertEquals(actualValue.contains(myValue), true);
	}

}




