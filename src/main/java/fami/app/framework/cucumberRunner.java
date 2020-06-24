package fami.app.framework;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * cucumberRunner.java - Initialization of the cucumber test runner
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    19 June 2020
 */

@RunWith(Cucumber.class)

@CucumberOptions( 
		features = "Feature"
		,glue={"fami.app.framework.steps"}
		,plugin = {"pretty","html:report","json:report/json/cucumber.json","junit:report/junit/cucumber.xml"}
		,strict = false
		,monochrome = true
		)


public class cucumberRunner {}
