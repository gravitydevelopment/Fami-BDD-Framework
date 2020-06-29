package fami.app.framework;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import fami.app.framework.engine.selenium;
import fami.app.framework.helpers.testLogger;

/**
 * AutomationRunner.java - Initialize the test automation execution 
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    19 June 2020
 */

public class AutomationRunner {
		
	public static WebDriver driver;
	
	private static Properties props = new Properties();
	private static final testLogger log = testLogger.getLogger("fami.app.framework.AutomationRunner");
	
	public static void webRunner() throws IOException{ webDriverRunner(); }
	
	/*Method to Set Test Properties and Initialize Testing */
	private static void webDriverRunner() throws IOException {
		
		selenium.getDriverConfig(props);				
		driver = selenium.setupWebDriver(driver);
		
		log.debug("Webdriver object initialized");
		
		org.junit.runner.JUnitCore.main("fami.app.framework.cucumberRunner");
		
		driver.close();
        
	}
}
