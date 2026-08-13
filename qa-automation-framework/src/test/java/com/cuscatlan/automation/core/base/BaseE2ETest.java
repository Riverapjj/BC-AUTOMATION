package com.cuscatlan.automation.core.base;

import com.cuscatlan.automation.core.driver.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
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
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot("Failure Screenshot");
        }

        if (driver != null) {
            driver.quit();
        }

    }

    public void takeScreenshot(String name) {

        if (driver == null) {
            return;
        }

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(name, "image/png",
                new ByteArrayInputStream(screenshot), ".png");
    }
}
