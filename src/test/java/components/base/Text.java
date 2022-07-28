package test.java.components.base;

import org.openqa.selenium.By;

public class Text extends Component {

	public Text(By locator) {
		super(locator);
	}
	
	public String getText() {
		return element().getText();
	}
}
