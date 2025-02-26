package com.qa.saucedemo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/login.feature",
		"src/test/resources/Features/products.feature"}, 
glue = { "com.qa.saucedemo.stepdefinitions" }, // Step definition package
		plugin = { "pretty", "html:target/cucumber-reports.html"
		}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

