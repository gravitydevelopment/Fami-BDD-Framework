package fami.app.framework.engine;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import fami.app.framework.engine.config;

/**
 * selenium.java - Initialize the selenium webdriver instance
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    20 June 2020
 */

public class selenium {
	
	private static String browser, webDriver;
	
	public static WebDriver setupWebDriver(WebDriver myDriver) { 
		myDriver = initialize(myDriver); 
		return myDriver;
	}

	public static void getDriverConfig(Properties myProps) throws IOException {
		
		String webdriverPath = System.getProperty("user.dir") +"/webdrivers/";
		
		browser = config.getConfig("selenium.properties","browser.type");
		
		if (browser.equals("chrome")||browser.equals("chromeheadless")) {
			webDriver = config.getConfig("selenium.properties","webdriver.chrome.driver");
			
			if (SystemUtils.IS_OS_LINUX) {
				System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); }
			else {
				System.setProperty("webdriver.chrome.driver", webdriverPath + "chromedriver83_win32.exe"); 
			}
			
		} else if (browser.equals("firefox")) {
			webDriver = config.getConfig("selenium.properties","webdriver.gecko.driver");
			System.setProperty("webdriver.gecko.driver", webdriverPath + "geckodriver-v0.26.0-win64.exe");

		} else if (browser.equals("ie")) { 
			webDriver = config.getConfig("selenium.properties","webdriver.ie.driver");
			System.setProperty("webdriver.ie.driver", webdriverPath + "IEDriverServer_Win32_3.150.1.exe");
		}		
	}
	
	public static WebDriver initialize(WebDriver driver) {
		
		if (browser.equals("chrome")) { 
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			driver = new ChromeDriver(chromeOptions); 
		}
		
		else if (browser.equals("firefox")) { driver = new FirefoxDriver(); } 
		else if (browser.equals("ie")) { driver = new InternetExplorerDriver(); }
		
		return driver;
	}

}
