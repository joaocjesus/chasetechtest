package test.java.components.base;

import org.openqa.selenium.By;

public class Link extends Component {

	public Link(By locator) {
		super(locator);
	}
	
	public String href() {
		return element().getAttribute("href");
	}
}
