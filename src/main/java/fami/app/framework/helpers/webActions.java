package fami.app.framework.helpers;

import cucumber.api.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * webActions.java - The webActions class contain a core (test) method where it's input
 * parameters is a class variable members which belong to the constructor properties.
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    21 June 2020
 */

public class webActions {

  //private final WebHarness finalHarness;
  //static WebHarness staticHarness;
  private final WebDriver finalDriver;
  static WebDriver staticDriver;
  static String elementType, elementLabel, elementLocator, url, pageId, inputValue;
  static DataTable dt;
  
  private static final testLogger log = testLogger.getLogger("com.experian.dadtf.helpers.webActions");
  
  
  protected webActions(WebDriver driver, String webElementType, String webElementLabel, String webElementLocator,
      String webUrl,
      String webPageId,
      String inputVal, DataTable dataTable) {


    this.elementType = webElementType;
    this.elementLabel = webElementLabel;
    this.elementLocator = webElementLocator;
    this.url = webUrl;
    this.pageId = webPageId;
    this.inputValue = inputVal;
    this.dt = dataTable;
    this.finalDriver = driver;
    staticDriver = this.finalDriver;

  }
  
  private static void waitPageLoadComplete(WebDriver driver, int defaultTimeout) {
	    Wait<WebDriver> wait = new WebDriverWait(driver, defaultTimeout);
	    wait.until(driver1 -> String
	            .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
	            .equals("complete"));
	}

  /**
   * This is the main method to navigate to the designated web page based on the provided url in the class member variable
   */
  protected static void goToUrl() {
	  staticDriver.get(url);
	  staticDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //waitPageLoadComplete(staticDriver, 10);
	  log.debug("Accessing web page at :"+ url);
  }

  /**
   * This is the main method to verify the web page by page id comparison provided page id in the class member variable against current actual page id.
   */
  protected static void verifyPage() {
    Assert.assertEquals(staticDriver.getTitle(), pageId, "FAIL: PageId not match. ");

  }

  /**
   * This is the main method to verify the element object by try to find it in the web page with provided locator information in the class member variable.
   */
  protected static void verifyElementObject() {

    if (elementType.equals("xpath")) {
    	staticDriver.findElements(By.xpath(elementLocator));
    	log.debug("The XPATH Element Locator :"+'"'+elementLocator +'"'+ " verified existed.");

    } else if (elementType.equals("id")) {
    	staticDriver.findElements(By.id(elementLocator));
    	log.debug("The ID Element Locator :"+'"'+elementLocator +'"'+ " verified existed.");

    } else if (elementType.equals("css")) {
      staticDriver.findElements(By.cssSelector(elementLocator));
      log.debug("The CSS Element Locator :"+'"'+elementLocator +'"'+ " verified existed.");
      
    } else if (elementType.equals("label")) {
    	staticDriver.findElement(By.linkText(elementLabel));
    	log.debug("The Label Element Locator :"+'"'+elementLocator +'"'+ " verified existed.");
    
    } else if (elementType.equals("class")) {
        staticDriver.findElements(By.className(elementLocator));
        log.debug("The Class Name Element Locator :"+'"'+elementLocator +'"'+ " verified existed.");

    } else {
      log.debug("The element locator :"+ elementLocator + " is not found.");

    }
  }

  /**
   * This is the main method to simulate an action of clicking the web object
   */
  protected static void clickElementObject() {
    if (elementType.equals("xpath")) {
      staticDriver.findElement(By.xpath(elementLocator)).click();
      log.debug("Action clicking the XPATH: "+'"'+elementLocator +'"'+ " element locator success.");

    } else if (elementType.equals("id")) {
      staticDriver.findElement(By.id(elementLocator)).click();
      log.debug("Action clicking the ID: "+'"'+elementLocator +'"'+ " element locator success.");

    } else if (elementType.equals("css")) {
      staticDriver.findElement(By.cssSelector(elementLocator)).click();
      log.debug("Action clicking the CSS: "+'"'+elementLocator +'"'+ " element locator success.");
      
    } else if (elementType.equals("label")) {
    	staticDriver.findElement(By.linkText(elementLabel)).click();
    	log.debug("Action clicking the Label Name: "+'"'+elementLocator +'"'+ " element locator success.");

    } else if (elementType.equals("class")) {
        staticDriver.findElement(By.className(elementLocator)).click();
        log.debug("Action clicking the Class Name: "+'"'+elementLocator +'"'+ " element locator success.");

    } else {
      log.error("Click action fail. The element locator :"+ elementLocator + " is not found.");
    }
  }

  /**
   * This is the main method to simulate an action of clicking the text link
   */
  protected static void clickElementLink() {
	  
	  if (elementType.equals("xpath")) {
		  staticDriver.findElement(By.xpath(elementLocator)).click();
		  log.debug("Action clicking the XPATH: "+'"'+elementLocator +'"'+ " element locator success.");

	    } else if (elementType.equals("id")) {
	    	staticDriver.findElement(By.id(elementLocator)).click();
	    	log.debug("Action clicking the ID: "+'"'+elementLocator +'"'+ " element locator success.");

	    } else if (elementType.equals("css")) {
	    	staticDriver.findElement(By.cssSelector(elementLocator)).click();
	    	log.debug("Action clicking the CSS: "+'"'+elementLocator +'"'+ " element locator success.");

	    } else if (elementType.equals("label")) {
	    	staticDriver.findElement(By.linkText(elementLabel)).click();
	    	log.debug("Action clicking the Label Name: "+'"'+elementLocator +'"'+ " element locator success.");
	      
	    } else {
	    	log.error("Click action fail. The element locator :"+ elementLocator + " is not found.");
	    }
	  
  }
    
  /**
   * This the main method for inserting the input values to the entry fields
   */
  protected static void insertTextInput() {

      if (elementType.equals("xpath")) {
          staticDriver.findElement(By.xpath(elementLocator)).sendKeys(inputValue);
          log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("id")) {
          staticDriver.findElement(By.id(elementLocator)).sendKeys(inputValue);
          log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("css")) {
          staticDriver.findElement(By.cssSelector(elementLocator)).sendKeys(inputValue);
          log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("class")) {
          staticDriver.findElement(By.className(elementLocator)).sendKeys(inputValue);
          log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else {
          // TODO: to handling the element verification failure
      }
  }

  /**
   * This is the main method to get the text values in the entry field element
   */
  protected static void getTextInput() {

    try {
      
      if (elementType.equals("xpath")) {
    	  Assert.assertEquals(staticDriver.findElement(By.xpath(elementLocator)).getText().toString(), inputValue);
    	  log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("id")) {
    	  Assert.assertEquals(staticDriver.findElement(By.id(elementLocator)).getText().toString(), inputValue);
    	  log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("css")) {
    	  Assert.assertEquals(staticDriver.findElement(By.cssSelector(elementLocator)).getText().toString(), inputValue);
    	  log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else if (elementType.equals("class")) {
    	  Assert.assertEquals(staticDriver.findElement(By.className(elementLocator)).getText().toString(), inputValue);
    	  log.debug("Filling up entry field: "+'"'+elementLocator +'"'+ " with a value of: "+inputValue);
      } else {
    	  // TODO: to handling the element verification failure
      }
    } catch (Exception e) {
        log.error("The element locator "+'"'+elementLocator+'"'+" does not exist.");
      }
  }

    /**
     * This is the main method to get input from Scenario Outline Examples table
     */
    protected static void selectInputfromTable() {
        if (elementType.equals("xpath")) {
            try {
                Select select = new Select(staticDriver.findElement(By.xpath(elementLocator)));
                select.selectByVisibleText(inputValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (elementType.equals("id")) {
            try {
                Select select = new Select(staticDriver.findElement(By.id(elementLocator)));
                select.selectByVisibleText(inputValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (elementType.equals("css")) {
            try {
                Select select = new Select(staticDriver.findElement(By.cssSelector(elementLocator)));
                select.selectByVisibleText(inputValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // TODO: to handling the element verification failure
        }
    }

  /**
   * This is the main method to clear the content of the entry fields
   */
  protected static void clearTextInput() {

      try {
          if (elementType.equals("xpath")) {
              staticDriver.findElement(By.xpath(elementLocator)).clear();
          } else if (elementType.equals("id")) {
              staticDriver.findElement(By.id(elementLocator)).clear();
          } else if (elementType.equals("css")) {
              staticDriver.findElement(By.cssSelector(elementLocator)).clear();
          }
      }catch (Exception e){
          log.error("The element locator "+'"'+elementLocator+'"'+" does not exist.");
      }
  }

    /**
     * This is the main method to switch to iFrame within page
     */
    protected static void switchFrame() {
        if (elementType.equals("xpath")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.xpath(elementLocator)));
        } else if (elementType.equals("id")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.id(elementLocator)));
        } else if (elementType.equals("css")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.cssSelector(elementLocator)));
        } else {
            // TODO: to handling the element verification failure
        }
    }

    /**
     * This the main method for selecting the drop down values
     */
    protected static void selectDropDown() {
        if (elementType.equals("xpath")) {
            ((JavascriptExecutor) staticDriver).executeScript("arguments[0].scrollIntoView(true);", staticDriver.findElement(By.xpath(elementLocator)));
        } else if (elementType.equals("id")) {
            ((JavascriptExecutor) staticDriver).executeScript("arguments[0].scrollIntoView(true);", staticDriver.findElement(By.id(elementLocator)));
        } else if (elementType.equals("css")) {
            ((JavascriptExecutor) staticDriver).executeScript("arguments[0].scrollIntoView(true);", staticDriver.findElement(By.cssSelector(elementLocator)));
        } else {
            // TODO: to handling the element verification failure
        }
    }

    /**
     * This is the main method to switch to iFrame from default content page
     */
    protected static void switchFramefrmDefault() {
        staticDriver.switchTo().defaultContent();
        if (elementType.equals("xpath")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.xpath(elementLocator)));
        } else if (elementType.equals("id")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.id(elementLocator)));
        } else if (elementType.equals("css")) {
            staticDriver.switchTo().frame(staticDriver.findElement(By.cssSelector(elementLocator)));
        } else {
            // TODO: to handling the element verification failure
        }
    }

    /**
     * This is the main method to check if element is present
     */
    protected static boolean chkIsElementPresent()
            throws StaleElementReferenceException, NoSuchElementException {
        try {
            return staticDriver.findElement(By.xpath(elementLocator)).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This is the main method to switch to current window
     */
    protected static void switchesToWindow() {
        Map<String, String> titlesMap = getHandlesTitles();
        if (titlesMap.get(pageId) == null) {
            throw new NoSuchWindowException("There is no window handle associated with title: " + pageId);
        } else {
            staticDriver.switchTo().window(titlesMap.get(pageId));
        }
    }

    /**
     * This is the main method to get handles titles used by switchesToWindow
     */
    protected static Map<String, String> getHandlesTitles() {
        Set<String> handles = staticDriver.getWindowHandles();
        Map<String, String> handleTitleMap = new HashMap<String, String>();

        for (String handle : handles) {
            staticDriver.switchTo().window(handle);
            handleTitleMap.put(staticDriver.getTitle(), handle);
        }
        return handleTitleMap;
    }

    /**
     * This is the main method to check if element is read only
     */
    protected static void isElementReadOnly() {
        assertTrue(staticDriver.findElement(By.cssSelector(elementLocator)).getAttribute("readonly").equals("true"), "Element ReadOnly");
    }

    /**
     * This is the main method to verify value of actual input by user against expected on application
     */
    protected static void verifyValueAgainst() {
        String actual = staticDriver.findElement(By.xpath(elementLocator)).getText();
        Assert.assertEquals(actual, inputValue);
    }

    /**
     * This is the main method to iterate contents in cucumber Table mapped against css field label
     */
    protected static void useTableInputbyField() {
        List<List<String>> list = dt.asLists(String.class);
        for (int i = 1; i < list.size(); i++) { //i starts from 1 because i=0 represents the header
            String inputField = (list.get(i).get(0));
            if (inputField.equals(staticDriver.findElement(By.cssSelector(elementLabel)).getText())) {
                if (elementType.equals("xpath")) {
                    staticDriver.findElement(By.xpath(elementLocator)).sendKeys(list.get(i).get(1));
                } else if (elementType.equals("id")) {
                    staticDriver.findElement(By.id(elementLocator)).sendKeys(list.get(i).get(1));
                } else if (elementType.equals("css")) {
                    staticDriver.findElement(By.cssSelector(elementLocator)).sendKeys(list.get(i).get(1));
                } else {
                    // TODO: to handling the element verification failure
                }
            } else {
                System.out.println("No matching value from table");
            }
        }
    }

    /**
     * This is the main method to iterate contents from cucumber Table using DataType and map against element locator
     */
    protected static void insertCukeTableInput() {
        {
            List<List<String>> list = dt.asLists(String.class);
            for (int i = 1; i < list.size(); i++) { //i starts from 1 because i=0 represents the header

                System.out.println((list.get(i).get(0)) + " with value " + (list.get(i).get(1)));
                if (elementType.equals("xpath") && staticDriver.findElement(By.xpath(elementLocator)).isEnabled()) {
                    try {
                        Select select = new Select(staticDriver.findElement(By.xpath(elementLocator)));
                        select.selectByVisibleText((list.get(i).get(1)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (elementType.equals("id") && staticDriver.findElement(By.id(elementLocator)).isEnabled()) {
                    try {
                        Select select = new Select(staticDriver.findElement(By.id(elementLocator)));
                        select.selectByVisibleText((list.get(i).get(1)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (elementType.equals("css") && staticDriver.findElement(By.cssSelector(elementLocator)).isEnabled()) {
                    try {
                        Select select = new Select(staticDriver.findElement(By.cssSelector(elementLocator)));
                        select.selectByVisibleText((list.get(i).get(1)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No matching value from table");
                }
            }
        }
    }

    /**
     * This is the main method to accept or click 'OK' browser window alert message
     */
    protected static void okBrowserAlert() {
        WebDriverWait wait = new WebDriverWait(staticDriver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        staticDriver.switchTo().alert();
        staticDriver.switchTo().alert().accept();
    }

    /**
     * This is the main method to get message String from cucumber Table using and check against browser window alert message
     */
    protected static void verifyBrowserAlertMsg() {
        List<List<String>> list = dt.asLists(String.class);

        Assert.assertEquals(list.get(1).get(0).trim(),staticDriver.switchTo().alert().getText().trim());
        staticDriver.switchTo().alert().accept();

    }

}

