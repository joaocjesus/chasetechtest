package test.java.locators;

import org.openqa.selenium.By;

public class Locator {
    public static By css(String css) {
        return By.cssSelector(css);
    }

    public static By xpath(String xpath) {
        return By.xpath(xpath);
    }
}
