package test.java.components.base;

import org.openqa.selenium.By;

public class InputBox extends Component {

	public InputBox(By locator) {
		super(locator);
	}
	
	public void type(String text) {
		element().sendKeys(text);;
	}
	
	public void setValue(String text) {
		element().clear();
		type(text);
	}
}
