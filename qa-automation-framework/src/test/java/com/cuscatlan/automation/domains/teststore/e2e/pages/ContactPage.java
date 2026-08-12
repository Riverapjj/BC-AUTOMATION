package com.cuscatlan.automation.domains.teststore.e2e.pages;

import com.cuscatlan.automation.core.ui.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    private final ElementActions elementActions;

    private final By pageTitle = By.tagName("h3");
    private final By subject = By.id("id_contact");
    private final By email = By.id("email");
    private final By message = By.id("contactform-message");
    private final By sendButton = By.name("submitMessage");
    private final By errorMessage = By.className("alert-danger");

    public ContactPage (WebDriver driver) {
        this.elementActions = new ElementActions(driver);
    }

    public boolean isTitleDisplayed () {
        return elementActions.isDisplayed(pageTitle);
    }

    public boolean isSubjectDisplayed () {
        return elementActions.isDisplayed(subject);
    }

    public boolean isEmailDisplayed () {
        return elementActions.isDisplayed(email);
    }

    public boolean isMessageDisplayed () {
        return elementActions.isDisplayed(message);
    }

    public void clickSendButton () {
        elementActions.click(sendButton);
    }

    public String getErrorMessage () {
        return elementActions.getText(errorMessage);
    }
}
