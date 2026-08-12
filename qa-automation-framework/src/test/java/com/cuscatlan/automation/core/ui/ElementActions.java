package com.cuscatlan.automation.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public void click(By locator) {
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    public void type(By locator, String text) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        element.clear();
        element.sendKeys(text);
    }

    public void clear(By locator) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).clear();
    }

    public boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }

    public boolean isEnabled(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).isEnabled();
    }

    public String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getAttribute(attribute);
    }
}
