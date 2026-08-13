package com.cuscatlan.automation.domains.teststore.e2e.pages;

import com.cuscatlan.automation.core.ui.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final ElementActions elementActions;

    private final By contactUsLink = By.id("contact-link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public ContactPage clickContactUs() {

        elementActions.click(contactUsLink);

        return new ContactPage(driver);
    }
}
