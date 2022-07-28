package test.java.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.Assert;

import io.cucumber.java8.En;
import test.java.Driver;
import test.java.pages.GoogleSearchPage;
import test.java.pages.GuardianNewsPage;
import test.java.pages.Result;
import test.java.utils.StringUtils;

public class TheGuardianStepsDefinition implements En {
	Driver driver = Driver.instance();
	private GuardianNewsPage guardianNewsPage;
	
	String newsUrl = "https://www.theguardian.com/tone/news";
	String googleUrl = "https://www.google.co.uk";
	
	GuardianNewsPage newsPage = new GuardianNewsPage();
	GoogleSearchPage googlePage = new GoogleSearchPage();
	
	ArrayList<Result> matchedResults;
	String articleHeadline;
	
	public TheGuardianStepsDefinition() {
		Before(() -> driver.maximiseWindow());
		
		Given("the Guardian News page is open", () -> {
			driver.navigate(newsUrl);
		});
		
		Then("the first news article is displayed", () -> {
			Assert.assertTrue(newsPage.articles().countIsGreaterThan(0));
			articleHeadline = newsPage.articleHeadline(0);
		});
		
		When("a Google search is done for the first news article", () -> {
			driver.openNewTab();
			driver.navigate(googleUrl);
			googlePage.disableCookieBanner();
			googlePage.searchBox().type(articleHeadline);
			googlePage.submitButton().click();
		});
		
		Then("results are returned", () -> {
			assertTrue(googlePage.results().getCount() > 0);	
		});
		
		Given("a Google search is done for the first news article headline", () -> {
			driver.navigate(googleUrl);
			googlePage.searchBox().setValue(articleHeadline);
			googlePage.submitButton().click();
		});
		
		Then("some matching results are displayed", () -> {
			matchedResults = googlePage.getMatchingResults(articleHeadline);
			assertTrue(matchedResults.size() > 0);
		});
		
		And("results with a high relevance of at least {int}% of words are shown", (Integer percentage) -> {
			ArrayList<Result> relevantResults = googlePage.getHighRelevanceResults(matchedResults, percentage);
			assertTrue(relevantResults.size() >= 2);	
		});
	}
}
