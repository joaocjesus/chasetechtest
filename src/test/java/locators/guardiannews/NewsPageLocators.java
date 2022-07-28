package test.java.locators.guardiannews;

import org.openqa.selenium.By;

import test.java.locators.Locator;

public class NewsPageLocators {
	private static final String ARTICLE_LOCATOR = "[data-test-id='facia-card']";
	public static final By NEWS_ARTICLE = Locator.css(ARTICLE_LOCATOR);
	public static final By ARTICLE_IMAGE = Locator.css(ARTICLE_LOCATOR + " picture img");
	public static final By ARTICLE_HEADLINE = Locator.css(ARTICLE_LOCATOR + " .js-headline-text");
}
