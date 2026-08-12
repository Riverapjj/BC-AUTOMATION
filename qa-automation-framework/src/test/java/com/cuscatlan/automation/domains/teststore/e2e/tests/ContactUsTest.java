package com.cuscatlan.automation.domains.teststore.e2e.tests;

import com.cuscatlan.automation.core.base.BaseE2ETest;
import com.cuscatlan.automation.domains.teststore.e2e.components.Header;
import com.cuscatlan.automation.domains.teststore.e2e.pages.ContactPage;
import com.cuscatlan.automation.domains.teststore.e2e.pages.HomePage;
import com.cuscatlan.automation.domains.teststore.e2e.pages.LoginPage;
import jdk.jpackage.internal.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseE2ETest {

    @Test
    public void errorMessageIsDisplayed () {

        Header header = new Header(driver);
        ContactPage contactPage = new ContactPage(driver);

        header.clickContactUs();

        Assert.assertTrue(contactPage.isTitleDisplayed(), "We are in contact us page");
        Assert.assertTrue(contactPage.isSubjectDisplayed(), "Subject field is displayed");
        Assert.assertTrue(contactPage.isEmailDisplayed(), "Email field is displayed");
        Assert.assertTrue(contactPage.isMessageDisplayed(), "Message field is displayed");

        contactPage.clickSendButton();

        String errorMessage = contactPage.getErrorMessage();

        Assert.assertFalse(errorMessage.isEmpty(), "Error message is displayed");
        System.out.println(errorMessage);

    }

    @Test
    public void fillContactUsForm () throws InterruptedException {

        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);
        ContactPage contactPage = new ContactPage(driver);

        header.clickSignIn();
        loginPage.login(properties.getProperty("test.username"), properties.getProperty("test.password"));

        Assert.assertTrue(header.isUserLoggedIn(), "User should be logged in");
        System.out.println(header.getUserName());

        header.clickContactUs();
    }

    @Test
    public void validatingLoginForm () {

        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);

        header.clickSignIn();
        loginPage.login("josue@banco.com", "123456");

        String msgAuth = loginPage.getAuthMsg();

        Assert.assertFalse(msgAuth.isEmpty(), "Authentication failed");
        System.out.println(msgAuth);

        loginPage.login(properties.getProperty("test.username"), properties.getProperty("test.password"));
        Assert.assertTrue(header.isUserLoggedIn(), "User should be logged in");
        System.out.println(header.getUserName());
    }
}
