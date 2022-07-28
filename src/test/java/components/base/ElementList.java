package test.java.components.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.Driver;
import test.java.utils.Times;

public class ElementList {
	private final By locator;

	public ElementList(By locator) {
		this.locator = locator;
	}

	protected List<WebElement> elements(long timeout) {
		long waitInterval = timeout / 5;
        for (int i = 0; i < 5; i++) {
            try {
                return Driver.instance().get().findElements(locator);
            } catch (UnhandledAlertException unhandledAlertException) {
            	Times.waitFor(waitInterval);
            }
        }
        throw new NoSuchElementException("findElements() -> Waited to overcome unhandled alert exception before failing test");
    }

	protected List<WebElement> elements() {
		return elements(Times.DEFAULT_TIMEOUT);
	}
	
	public WebElement getElement(int index) {
		return elements().get(index);
	}
	
	public void clickByIndex(int index) {
		getElement(index).click();
	}
	
	public String getTextByIndex(int index) {
		return getElement(index).getText();
	}
	
	public int getCount() {
		return elements().size();
	}
	
	public boolean countIsGreaterThan(int count) {
		return elements().size() > count;
	}
	

	public void waiUntilCountEquals(int count, long timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.instance().get(), Duration.ofMillis(timeout));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(locator).size();
                return elementCount == count;
            }
        });
	}
	
	public void waitUntilCountEquals(int count) {
		waiUntilCountEquals(count, Times.DEFAULT_TIMEOUT);
	}
	
	public void waiUntilCountAbove(int count, long timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.instance().get(), Duration.ofMillis(timeout));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(locator).size();
                return elementCount > count;
            }
        });
	}
	
	public void waiUntilCountAbove(int count) {
		waiUntilCountEquals(count, Times.DEFAULT_TIMEOUT);
	}
}
