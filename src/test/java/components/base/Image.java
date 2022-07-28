package test.java.components.base;

import org.openqa.selenium.By;

public class Image extends Component {

	public Image(By locator) {
		super(locator);
	}
	
	public String getSrc() {
		return element().getAttribute("src");
	}
}
