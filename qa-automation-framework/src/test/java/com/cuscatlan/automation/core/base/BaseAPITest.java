package com.cuscatlan.automation.core.base;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseAPITest {

    protected Properties properties;
    protected String baseUrl;
    protected String apiKey;

    @BeforeMethod
    public void setUp() throws IOException {

        properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config/qa.properties")) {

            properties.load(input);
        }

        baseUrl = properties.getProperty("api.base.url");
        apiKey = properties.getProperty("api.key");
    }

}
