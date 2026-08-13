package com.cuscatlan.automation.domains.teststore.e2e.pages;

import com.cuscatlan.automation.core.ui.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final ElementActions elementActions;
    private final By txtLoginEmail = By.id("field-email");
    private final By txtLoginPwd = By.id("field-password");
    private final By btnSignIn = By.id("submit-login");
    private final By msgAuth = By.className("alert-danger");

    public LoginPage (WebDriver driver) {
        this.elementActions = new ElementActions(driver);
    }

    public void enterEmail (String email) {
        elementActions.type(txtLoginEmail, email);
    }

    public void enterPassword (String pwd) {
        elementActions.type(txtLoginPwd, pwd);
    }

    public void clickSignIn () {
        elementActions.click(btnSignIn);
    }

    public void enterCredentials (String email, String pwd) {
        enterEmail(email);
        enterPassword(pwd);
    }

    public String getAuthMsg () {
        return elementActions.getText(msgAuth);
    }
}
