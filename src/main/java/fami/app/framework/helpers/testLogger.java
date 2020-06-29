package fami.app.framework.helpers;

import org.slf4j.LoggerFactory;
import fami.app.framework.engine.config;

/**
 * testLogger.java - Using the slf4j logger method to produce a log capture for a
 * info,warning,debug and an error execution condition.
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    21 June 2020
 */

public class testLogger {
	
	private org.slf4j.Logger log;
	
	private testLogger(String name) {
		log = LoggerFactory.getLogger(name);
	}
	
	public static testLogger getLogger(String name) { return new testLogger(name);}
	
	String mode = config.getConfig("config.properties", "logger.mode");
	
	/**
	 * Logger method to capture debug type of log
	 */
	public void debug (String input) {
		if (mode.equals("debug")) { log.debug(input); }
	}
	
	/**
	 * Logger method to capture info type of log
	 */
	public void info (String input){
		if (mode.equals("info") || mode.equals("warn") || mode.equals("error") || mode.equals("debug")) {
			log.info(input);
		}
	}
	
	/**
	 * Logger method to capture warning type of log
	 */
	public void warn (String input){
		if (mode.equals("warn") || mode.equals("debug")) {
			log.warn(input);
		}
	}
	
	/**
	 * Logger method to capture error type of log
	 */
	public void error (String input){
		if (mode.equals("error") || mode.equals("debug")) {
			log.error(input);
		}
	}
}
