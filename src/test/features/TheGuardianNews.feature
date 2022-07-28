Feature: The first article of the Guardian News is not fake
	Tests if an article of The Guardian is not fake by finding other sources for the news
	
	Scenario: The first news article in The Guardian appears in Google Search results
	  Given the Guardian News page is open
	  Then the first news article is displayed
	  When a Google search is done for the first news article
	  Then results are returned

	Scenario: The first news article in The Guardian does not appear to be fake
	  Given the Guardian News page is open
	  Then the first news article is displayed
	  When a Google search is done for the first news article headline
	  Then some matching results are displayed
	  And results with a high relevance of at least 50% of words are shown