package test.java.locators.googlesearch;

import org.openqa.selenium.By;

import test.java.locators.Locator;

public class GoogleSearchLocators {
    public static final By REJECT_COOKIES_BUTTON = Locator.xpath("//button/div[text()='Reject all']");
    public static final By SEARCH_BOX = Locator.css("[name='q']");
    public static final By SUBMIT_BUTTON = Locator.xpath("(//input[@aria-label='Google Search'])[2]");
    public static final By RESULT = Locator.css(".g h3");
}
