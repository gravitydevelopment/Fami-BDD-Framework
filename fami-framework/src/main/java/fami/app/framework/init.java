package fami.app.framework;

/**
 * init.java - Initialize the test framework
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    19 June 2020
 */

public class init {
	
	public static void main (String[]args) {
		try { AutomationRunner.webRunner();} catch (Exception e) { e.printStackTrace(); }
	}
}
