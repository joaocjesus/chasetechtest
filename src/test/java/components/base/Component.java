package test.java.components.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

import test.java.Driver;
import test.java.utils.Times;

public class Component {
	private By locator;

	public Component(By locator) {
		this.locator = locator;
	}

	public void click() {
		element().click();
	}

	public By append(By locator) {
		String parentStrategy = this.locator.getClass().getSimpleName();
		String childStrategy = locator.getClass().getSimpleName();
		System.out.println("========= parentStrategy =========> " + parentStrategy);
		System.out.println("========= childStrategy =========> " + childStrategy);
		if (parentStrategy == childStrategy) {
			if (parentStrategy == "By.xpath") {
				return By.xpath(this.locator.toString() + locator.toString());
			} else if (parentStrategy == "By.cssSelector") {
				return By.cssSelector(this.locator.toString() + " " + locator.toString());
			} else {
				throw new Error("Locator strategy not supported. Use cssSelector or xpath!");
			}
		} else {
			throw new Error("Locator strategy mismatch!");
		}
	}

	protected WebElement element() {
		for (int i = 0; i < 5; i++) {
			try {
				return Driver.instance().get().findElement(locator);
			} catch (UnhandledAlertException unhandledAlertException) {
				Times.waitFor(Times.ONE_SECOND);
			}
		}
		throw new NoSuchElementException(
				"findElement() -> Tried 5 times to overcome unhandled alert exception before failing test");
	}
}
