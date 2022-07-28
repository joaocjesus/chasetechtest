package test.java.pages;

import test.java.components.base.ElementList;
import test.java.locators.guardiannews.NewsPageLocators;

public class GuardianNewsPage {
	private ElementList articles;

	public ElementList articles() {
		if (articles == null) {
			articles = new ElementList(NewsPageLocators.NEWS_ARTICLE);
		}
		return articles;
	}

	public String articleHeadline(int index) {
		ElementList images = new ElementList(NewsPageLocators.ARTICLE_HEADLINE);
		return images.getTextByIndex(index);
	}
}
