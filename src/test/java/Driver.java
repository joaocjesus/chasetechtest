package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	private static final Driver INSTANCE = new Driver();
	private static WebDriver driver;

	public Driver() {
		driver = new ChromeDriver();
	}

	public static Driver instance() {
		return INSTANCE;
	}

	public WebDriver get() {
		return driver;
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void maximiseWindow() {
		driver.manage().window().maximize();
	}

	public String getSessionId() {
		return driver.getWindowHandle();
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void setCookie(String key, String value) {
		driver.manage().addCookie(new Cookie(key, value));
	}

	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void switchToWindow(String sessionId) {
		driver.switchTo().window(sessionId);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void end() {
		driver.quit();
	}
}
