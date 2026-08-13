package com.cuscatlan.automation.domains.teststore.e2e.pages;

import com.cuscatlan.automation.core.ui.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    private final ElementActions elementActions;
    private final By pageTitle = By.tagName("h3");
    private final By selectSubject = By.id("id_contact");
    private final By txtEmail = By.id("email");
    private final By txtMessage = By.id("contactform-message");
    private final By btnSend = By.name("submitMessage");
    private final By msgError = By.className("alert-danger");

    public ContactPage (WebDriver driver) {
        this.elementActions = new ElementActions(driver);
    }

    public boolean isTitleDisplayed () {
        return elementActions.isDisplayed(pageTitle);
    }

    public boolean isSubjectDisplayed () {
        return elementActions.isDisplayed(selectSubject);
    }

    public boolean isEmailDisplayed () {
        return elementActions.isDisplayed(txtEmail);
    }

    public boolean isMessageDisplayed () {
        return elementActions.isDisplayed(txtMessage);
    }

    public void clickSendButton () {
        elementActions.click(btnSend);
    }

    public String getErrorMessage () {
        return elementActions.getText(msgError);
    }

    public void selectSubject (String subjectOption) {
        elementActions.selectByVisibleText(selectSubject, subjectOption);
    }

    public void enterEmail(String email) {
        elementActions.type(txtEmail, email);
    }

    public void enterMessage(String message) {
        elementActions.type(txtMessage, message);
    }
}
