package com.learn.bdd.UserAcceptanceTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
		features ={"src/test-userAcceptance/resources/com/learn/bdd/UserAcceptanceTest/VendingMachine.feature"})

public class TestRunner {}
