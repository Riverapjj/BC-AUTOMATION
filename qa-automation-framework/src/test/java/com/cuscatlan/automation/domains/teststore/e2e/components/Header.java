package com.cuscatlan.automation.domains.teststore.e2e.components;

import com.cuscatlan.automation.core.ui.ElementActions;
import com.cuscatlan.automation.domains.teststore.e2e.pages.ContactPage;
import com.cuscatlan.automation.domains.teststore.e2e.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private final WebDriver driver;
    private final ElementActions elementActions;
    private final By contactUsLink = By.id("contact-link");
    private final By userName = By.cssSelector("#_desktop_user_info .user-info > a > span");

    public Header (WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public ContactPage clickContactUs() {

        elementActions.click(contactUsLink);

        return new ContactPage(driver);
    }

    public LoginPage clickSignIn () {

        elementActions.click(userName);

        return new LoginPage(driver);
    }

    public String getUserName () {
        return elementActions.getText(userName);
    }

    public boolean isUserLoggedIn () {
        return !getUserName().equalsIgnoreCase("Sign in");
    }
}
