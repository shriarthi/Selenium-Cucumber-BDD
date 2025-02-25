package com.qa.saucedemo.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static Properties prop;

    public Properties init_prop() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     * Initialize WebDriver only if not already set.
     */
    public void init_driver(Properties prop) {
        if (tlDriver.get() == null) {
            System.out.println("Initializing WebDriver...");
            String browserName = prop.getProperty("browser").trim();
            
            switch (browserName.toLowerCase()) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    tlDriver.set(new ChromeDriver(options));
                    break;
                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "safari":
                    tlDriver.set(new SafariDriver());
                    break;
                default:
                    throw new RuntimeException("Invalid browser: " + browserName);
            }

            WebDriver driver = tlDriver.get();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));

            System.out.println("✅ WebDriver initialized successfully!");
        } else {
            System.out.println("✅ WebDriver is already running.");
        }
    }

    /**
     * Get the WebDriver instance.
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Quit WebDriver only once after all tests.
     */
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
            System.out.println("✅ WebDriver closed.");
        }
    }
}
