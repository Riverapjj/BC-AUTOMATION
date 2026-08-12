package com.cuscatlan.automation.core.base;

import com.cuscatlan.automation.core.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseE2ETest {

    protected WebDriver driver;
    protected Properties properties;

    @BeforeMethod
    public void setUp() throws IOException {

        properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config/qa.properties")) {

            properties.load(input);
        }

        String baseUrl = properties.getProperty("base.url");

        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

    }
}
