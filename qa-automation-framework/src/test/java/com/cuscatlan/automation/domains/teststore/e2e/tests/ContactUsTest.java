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

        takeScreenshot("Before click Contact Us");
        header.clickContactUs();

        takeScreenshot("Contact Us page");
        Assert.assertTrue(contactPage.isTitleDisplayed(), "We are in contact us page");
        Assert.assertTrue(contactPage.isSubjectDisplayed(), "Subject field is displayed");
        Assert.assertTrue(contactPage.isEmailDisplayed(), "Email field is displayed");
        Assert.assertTrue(contactPage.isMessageDisplayed(), "Message field is displayed");

        contactPage.clickSendButton();

        String errorMessage = contactPage.getErrorMessage();

        Assert.assertFalse(errorMessage.isEmpty(), "Error message is displayed");
        takeScreenshot("Error message displayed");
        System.out.println(errorMessage);

    }

    @Test
    public void fillContactUsForm () throws InterruptedException {

        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);

        takeScreenshot("Before click Sign In");
        header.clickSignIn();

        loginPage.enterCredentials(properties.getProperty("test.username"), properties.getProperty("test.password"));
        takeScreenshot("Credentials entered");
        loginPage.clickSignIn();

        Assert.assertTrue(header.isUserLoggedIn(), "User should be logged in");
        takeScreenshot("User is logged in");
        System.out.println(header.getUserName());

        header.clickContactUs();
    }

    @Test
    public void validatingLoginForm () {

        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);

        takeScreenshot("Before click Sign In");
        header.clickSignIn();
        loginPage.enterCredentials("josue@banco.com", "123456");
        takeScreenshot("Credentials entered");
        loginPage.clickSignIn();

        String msgAuth = loginPage.getAuthMsg();

        Assert.assertFalse(msgAuth.isEmpty(), "Authentication failed");
        takeScreenshot("Unsuccessful log in");
        System.out.println(msgAuth);

        loginPage.enterCredentials(properties.getProperty("test.username"), properties.getProperty("test.password"));
        takeScreenshot("Credentials entered");
        loginPage.clickSignIn();

        Assert.assertTrue(header.isUserLoggedIn(), "User should be logged in");
        takeScreenshot("Successful log in");
        System.out.println(header.getUserName());
    }
}
