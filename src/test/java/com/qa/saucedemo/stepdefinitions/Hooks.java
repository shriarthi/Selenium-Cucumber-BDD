package com.qa.saucedemo.stepdefinitions;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.saucedemo.factory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {

    private static DriverFactory driverFactory;
    private static Properties prop;
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        if (driver == null) {  // ✅ Prevent re-initializing WebDriver
            driverFactory = new DriverFactory();
            prop = driverFactory.init_prop();
            driverFactory.init_driver(prop);
            driver = DriverFactory.getDriver();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            DriverFactory.quitDriver();
            driver = null;
        }
    }
}
