package test.java.components.base;

import org.openqa.selenium.By;

public class Button extends Component {

	public Button(By locator) {
		super(locator);
	}
	
	public Boolean isEnabled() {
		return element().isEnabled();
	}
}
