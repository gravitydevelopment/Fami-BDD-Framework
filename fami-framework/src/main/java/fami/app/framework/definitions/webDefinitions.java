package fami.app.framework.definitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	 * @param myUrl Designated web url
	 */
	public static void accessPage(String myUrl) {
		
		if (myUrl.isEmpty()) log.error("The provided url is blank, unable to access the webpage");
		
		try { 
			driver.get(myUrl); driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			log.info("Accessing webpage url: " + myUrl); 
		}
		
		catch (Exception e) { log.error("The provided url is blank, unable to access the webpage" + "\n" + e);}
		
	}
	
	
	/**
	 * This is a method to check and validate the page title id
	 * @param myPageTitle Expected page id
	 */
	public static void verifyPageTitle(String myPageTitle) {
		
		try { 
			Assert.assertEquals(driver.getTitle(), myPageTitle, "FAIL: Page Title are not match. ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			log.info("Verify page title are: " + myPageTitle); 
		}
		
		catch (Exception e) { log.error("Unable to verify the page title, due to: " + "\n" + e);}
		
	}
	

	/**
	 * This is a method to verify the web element
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 */
	public static void verifyElement(By myElement) {
		
		try { 
			driver.findElement(myElement);
			log.info("Verifying element: " + myElement); 
		}
		
		catch (Exception e) { log.error("Unable to verify the element: " + myElement + "\n" + e);}
	}

	/**
	 * This is a method to interact with the web element by inserting an input value
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */
	public static void insertValueElement(By myElement, String myValue) {
		
		try { 
			driver.findElement(myElement).clear();
			driver.findElement(myElement).sendKeys(myValue);
			log.info("Inserting value " + "\"" + myValue + "\"" + " element: " + myElement); 
		}
		
		catch (Exception e) { log.error("Fail to insert value to element: " + myElement + "\n" + e);}
	}

	/**
	 * This is a method to interact with the web element by inserting an input value and perform an enter key press action
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */		
	public static void insertValueAndEnter(By myElement, String myValue) {

		try { 
			driver.findElement(myElement).clear();
			driver.findElement(myElement).sendKeys(myValue); 
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			log.info("Inserting value " + "\"" + myValue + "\"" + " element: " + myElement + " and pressing enter key");
		}
		
		catch (Exception e) { log.error("Fail to insert value and perform enter action to element: " + myElement + "\n" + e);}	
	}
	
	public static void clearValue(By myElement) {

		try { 
			driver.findElement(myElement).clear(); 
			log.info("Clear the value of element: " + myElement);
		}
		
		catch (Exception e) { log.error("Fail to clear value of element: " + myElement + "\n" + e);}	
	}

	/**
	 * This is a method to interact with the web element by clicking the element object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 */	
	public static void clickElement(By myElement) {
		
		try { 
			driver.findElement(myElement).click();
			log.info("Clicking element: " + myElement);
			Thread.sleep(1000); 
		}
		
		catch (Exception e) { log.error("Fail to click element: " + myElement + "\n" + e);}	
	}
	
	/**
	 * This is a method to interact with the web element by clicking the element object and wait for the page load completed
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 */	
	public static void clickElementAndWaitPageLoad(By myElement, By waitedElement) {
		
		try { 
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			driver.findElement(myElement).click();

			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(waitedElement));
			wait.until(ExpectedConditions.stalenessOf(element));
			
			log.info("Clicking element: " + myElement + " and wait for the page load completed.");
			Thread.sleep(1000); 
		}
		
		catch (Exception e) { log.error("Fail to click element: " + myElement + "\n" + e);}	
	}
	/**
	 * This is a method to verify the value hold by a web element object
	 * @param myElement Web element locator (either xpath, id, css, class, name)
	 * @param myValue String of input value
	 */	
	public static void verifyElementTextValue(By myElement, String myValue) {
		
		try { 
			String actualValue = driver.findElement(myElement).getText();
			Assert.assertEquals(actualValue.contains(myValue), true);
			log.info("Verify text value of the element: " + myElement + "are equal to " + "\"" + myValue + "\"");
		}
		
		catch (Exception e) { log.error("Fail to verify and assert value for element: " + myElement + "\n" + e);}	
	}

}




