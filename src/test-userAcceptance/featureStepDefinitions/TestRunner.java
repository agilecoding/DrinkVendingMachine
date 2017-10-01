package featureStepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		//format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
		features ={"src/test-userAcceptance/resources/features/VendingMachine.feature"},
		tags = {"~@ignore"},
		plugin = {"pretty"})

public class TestRunner {}
