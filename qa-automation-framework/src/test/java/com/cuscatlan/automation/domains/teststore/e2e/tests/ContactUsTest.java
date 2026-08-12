package com.cuscatlan.automation.domains.teststore.e2e.tests;

import com.cuscatlan.automation.core.base.BaseE2ETest;
import com.cuscatlan.automation.domains.teststore.e2e.pages.ContactPage;
import com.cuscatlan.automation.domains.teststore.e2e.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseE2ETest {

    @Test
    public void errorMessageIsDisplayed () {

        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();

        Assert.assertTrue(contactPage.isSubjectDisplayed(), "Subject field is displayed");
        Assert.assertTrue(contactPage.isEmailDisplayed(), "Email field is displayed");
        Assert.assertTrue(contactPage.isMessageDisplayed(), "Message field is displayed");

        contactPage.clickSendButton();

        String errorMessage = contactPage.getErrorMessage();

        Assert.assertFalse(errorMessage.isEmpty(), "Error message is displayed");
        System.out.println(errorMessage);

    }
}
