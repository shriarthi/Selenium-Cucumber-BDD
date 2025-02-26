package com.qa.saucedemo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/1_login.feature",
		"src/test/resources/Features/2_products.feature",
		"src/test/resources/Features/3_checkout.feature",
		"src/test/resources/Features/4_informationpage.feature",
		"src/test/resources/Features/5_orderpage.feature",
		"src/test/resources/Features/6_orderhistory.feature"}, 

glue = { "com.qa.saucedemo.stepdefinitions" },
		plugin = { "pretty", "html:target/cucumber-reports.html"
		}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

