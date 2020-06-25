package fami.app.framework.definitions;

import cucumber.api.DataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import com.gargoylesoftware.htmlunit.javascript.host.Element;

import fami.app.framework.AutomationRunner;
import fami.app.framework.engine.config;
import fami.app.framework.helpers.testLogger;
import fami.app.framework.helpers.webActions;

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

 public class webDefinitions extends webActions {

  private static final testLogger log = testLogger.getLogger("fami.app.framework.definitions.webDefinitions");
  public static WebDriver driver = AutomationRunner.driver;
  
  //static WebDriver staticDriver;
  static webDefinitions definition;

    private webDefinitions(WebDriver myDriver){
        super(myDriver,null,null,null,null,null,null,null);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, DataTable dtTable) {
        super(myDriver, null, null, null, null, null, null,dtTable);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, String myUrl, String myPageId) {
        super(myDriver, null, null, null, myUrl, myPageId, null,null);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
        super(myDriver, myElementType, myElementLabel, myElementLocator, null, null, null,null);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, DataTable dtTable) {
        super(myDriver, myElementType, myElementLabel, myElementLocator, null, null, null,dtTable);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, String myInput) {
        super(myDriver, myElementType, myElementLabel, myElementLocator, null, null, myInput,null);
        myDriver = driver ;
    }

    private webDefinitions(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator,
                           String myUrl,
                           String myPageId,
                           String myInput, DataTable dtTable) {
        super(myDriver, myElementType, myElementLabel, myElementLocator, myUrl, myPageId, myInput, dtTable);
        myDriver = driver ;
    }
    
    
    
    public static void accessPage(String myUrl, WebDriver myDriver) {
    	
    	definition = new webDefinitions(myDriver, myUrl, null);
    	
    	if (myUrl.isEmpty()) { log.info("INFO::Fail: The provided url is blank, unable to access the webpage" ); }
    	else {log.info("INFO::Step: Accessing webpage url: " + myUrl);}
    	goToUrl();
    }
    
    public static void verifyElement(WebDriver myDriver, By myElement) {
    	myDriver.findElement(myElement);   
    }
    
    public static void insertValueElement(WebDriver myDriver, By myElement, String myValue) {
    	myDriver.findElement(myElement).sendKeys(myValue);   
    }
    
    public static void clickElement(WebDriver myDriver, By myElement) {
    	myDriver.findElement(myElement).click();   
    }
    
    public static void verifyElementTextValue(WebDriver myDriver, By myElement, String myValue) {
    	String actualValue = myDriver.findElement(myElement).getText();
        Assert.assertEquals(actualValue.contains(myValue), true);
    }
  
//  /**
//   * This is a test method to verify the web page based on paged id
//   *
//   * @param harness This is the first input parameter to add the web harness
//   * @param pageId This is the second input parameters to add the expected page id of a designated web page
//   */
//  public static void verifyPageid(String pageName, WebDriver myDriver, String pageId) {
//    definition = new webDefinitions(myDriver, null, pageId);
//    
//    if (pageName.isEmpty()) { log.info("Verify page Id: " + pageId);}
//    else {log.info("Verify " + pageName + " web page Id: " + pageId);}
//
//    verifyPage();
//  }

  /**
   * This is a test method to verify the web page based on paged id
   *
   * @param harness This is the first input parameter to add the web harness
   * @param myElementType This is the second input parameter to add the element type either by "id", "xpath", "css"
   * @param myElementLabel This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
   * @param myElementLocator This is the fourth input parameter to add the element locator
   */
  public static void verifyElement(String elementName, WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
    definition = new webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
    log.info("Verify element object: " + elementName);
    verifyElementObject();
  }
//
//  /**
//   * This is a test method to execute the action of clicking the button object
//   *
//   * @param harness This is the first input parameter to add the web harness
//   * @param myElementType This is the second input parameter to add the element type either by "id", "xpath", "css"
//   * @param myElementLabel This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//   * @param myElementLocator This is the fourth input parameter to add the element locator
//   */
//  public static void clickButton(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//    definition = new webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//    log.info("Clicking button: " + myElementLabel);
//    clickElementObject();
//  }
//  
//  /**
//   * This is a test method to execute the action of clicking the link
//   *
//   * @param harness This is the first input parameter to add the web harness
//   * @param myElementType This is the second input parameter to add the element type either by "id", "xpath", "css"
//   * @param myElementLabel This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//   * @param myElementLocator This is the fourth input parameter to add the element locator
//   */
//  public static void clickLink(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//    definition = new webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//    log.info("Clicking link: " + myElementLabel);
//    clickElementObject();
//  }
//
//  /**
//   * This is test method to simulate an action to insert a values in the entry fields element object
//   * @param harness This is the first input parameter to add the web harness
//   * @param myElementType This is the second input parameter to add the element type either by "id", "xpath", "css"
//   * @param myElementLocator This is the fourth input parameter to add the element locator
//   * @param inputValues This is a string consist an input values for the entry fields. Empty input are allowed
//   */
//  public static void insertEntryFields(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, String inputValues) {
//
//    if (inputValues.equals(null)) {
//
//      // TODO: To quit the procedures with failure capture in a logger
//
//    } else {
//
//      definition = new webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, inputValues);
//      insertTextInput();
//      log.info("Insert value: " + inputValues +" in " + myElementLabel + " entry field" );
//    }
//  }
//
//    /**
//     * This is test method to simulate an action to switch to iframe within page
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void switchToFrame(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        switchFrame();
//    }
//
//    /**
//     * This is test method to simulate an action to switch to iframe within page from default content
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void switchToFramefrmDefault(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        switchFramefrmDefault();
//    }
//
//    /**
//     * This is test method to simulate an action to select from drop-down list
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void selectDDMenu(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        selectDropDown();
//
//    }
//
//    /**
//     * This is test method to get value from Cucumber's Scenario Outline's Examples table
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void getExamplesTableInput(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, String inputValues) {
//
//        if (inputValues.equals(null)) {
//            // TODO: To quit the procedures with failure capture in a logger
//
//        } else {
//            definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, inputValues);
//            selectInputfromTable();
//        }
//    }
//
//    /**
//     * This is test method to simulate an action to insert a values in the entry fields element object
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static boolean checkElementPresent(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        chkIsElementPresent();
//
//        return false;
//    }
//
//    /**
//     * This is a test method to switch to desired web page window based on paged id
//     *
//     * @param harness This is the first input parameter to add the web harness
//     * @param pageId  This is the second input parameters to add the expected page id of a designated web page
//     */
//    public static void switchToWindow(WebDriver myDriver, String pageId) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, null, pageId);
//        switchesToWindow();
//    }
//
//    /**
//     * This is test method to check if element is Read Only
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void checkisReadOnly(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        isElementReadOnly();
//
//    }
//
//    /**
//     * This is test method to check input value by user against actual value of the web application
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     * @param inputValues      This is a string consist an input values for the entry fields. Empty input are allowed
//     */
//    public static void checkValueAgainst(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, String inputValues) {
//        if (inputValues.equals(null)) {
//            // TODO: To quit the procedures with failure capture in a logger
//        } else {
//            definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, inputValues);
//            verifyValueAgainst();
//        }
//    }
//
//    /**
//     * This is test method to get current browser window handles from webdriver
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     */
//    public static void getWindowHandlez(WebDriver myDriver) {
//        getHandlesTitles();
//    }
//
//    /**
//     * This is test method to input value by user from cucumber table by field
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     * @param dtTable      This is a string consist an input values for the entry fields. Empty input are allowed
//     */
//    public static void insertTableInputbyField(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, DataTable dtTable) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, dtTable);
//        useTableInputbyField();
//    }
//
//    /**
//     * This is test method to input value by user from cucumber table by element
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     * @param dtTable      This is a string consist an input values for the entry fields. Empty input are allowed
//     */
//    public static void selectTableListbyElement(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, DataTable dtTable) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, dtTable);
//        insertCukeTableInput();
//    }
//
//    /**
//     * This is test method to clear input field values
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     * @param myElementType    This is the second input parameter to add the element type either by "id", "xpath", "css"
//     * @param myElementLabel   This is the third input parameter to add the element label, for some example a button label. Insert "none" if there is none label.
//     * @param myElementLocator This is the fourth input parameter to add the element locator
//     */
//    public static void clearField(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator);
//        clearTextInput();
//    }
//
//    /**
//     * This is test method to handle browserAlert message verification
//     *
//     * @param harness      This is the first input parameter to add the web harness
//     * @param dtTable      This is a string consist an input values for the entry fields. Empty input are allowed
//     */
//    public static void verifybrowserAlert(WebDriver myDriver, DataTable dtTable){
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver, dtTable);
//        verifyBrowserAlertMsg();
//    }
//    
//    /**
//     * This is test method to handle browserAlert message verification
//     *
//     * @param harness      This is the first input parameter to add the web harness
//     * @param dtTable      This is a string consist an input values for the entry fields. Empty input are allowed
//     */
//    public static void verifyEntryFieldValue(WebDriver myDriver, String myElementType, String myElementLabel, String myElementLocator, String inputValues) {
//
//        if (inputValues.equals(null)) {
//
//          // TODO: To quit the procedures with failure capture in a logger
//
//        } else {
//
//          definition = new webDefinitions(myDriver, myElementType, myElementLabel, myElementLocator, inputValues);
//          getTextInput();
//          log.info("Insert value: " + inputValues +" in " + myElementLabel + " entry field" );
//        }
//      }
//
//
//    /**
//     * This is test method to accept browserAlert message
//     *
//     * @param harness          This is the first input parameter to add the web harness
//     */
//    public static void acceptBrowserAlert(WebDriver myDriver) {
//        definition = new com.experian.dadtf.lite.definitions.webDefinitions(myDriver);
//        okBrowserAlert();
//    }

}




