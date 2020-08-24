package fami.app.framework.engine;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * config.java - Providing a method to access the configuration files
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    20 June 2020
 */

public class config {
			
	public static String getConfig(String propName, String param) {
		
		Properties myProps = new Properties();
		
		try { getProperties(myProps, propName); } 
		catch(IOException ie) { ie.printStackTrace(); }
           
		return myProps.getProperty(param);	
	}
	
	private static Properties getProperties(Properties props, String propName) throws IOException {
		
		FileReader reader=new FileReader(System.getProperty("user.dir") +"/configs/"+propName); 
		props.load(reader);
		
		return props;
	}
	
}
