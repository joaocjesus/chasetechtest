package test.java.pages;

import java.util.ArrayList;

import test.java.Driver;
import test.java.components.base.Button;
import test.java.components.base.ElementList;
import test.java.components.base.InputBox;
import test.java.locators.googlesearch.GoogleSearchLocators;
import test.java.utils.StringUtils;


public class GoogleSearchPage {
	private Button rejectCookiesButton;
	private InputBox searchBox;
	private Button submitButton;
	
    public Button rejectCookiesButton() {
        if (rejectCookiesButton == null)
        	rejectCookiesButton = new Button(GoogleSearchLocators.REJECT_COOKIES_BUTTON);
        return rejectCookiesButton;
    }
    
    public InputBox searchBox() {
        if (searchBox == null)
        	searchBox = new InputBox(GoogleSearchLocators.SEARCH_BOX);
        return searchBox;
    }
    
    public Button submitButton() {
        if (submitButton == null)
        	submitButton = new Button(GoogleSearchLocators.SUBMIT_BUTTON);
        return submitButton;
    }
    
    public ElementList results() {
    	return new ElementList(GoogleSearchLocators.RESULT);
    }
    
    
    /**
     * Sets SOCS cookie to disable the cookie banner so we don't have to press the dialog button
     */
    public void disableCookieBanner() {
    	Driver driver = Driver.instance();
    	driver.setCookie("SOCS", "0");
    	driver.refresh();
    }
    
    /**
     * 
     * @param articleHeadline
     * @return list of results that have at least one matching word
     */
    public ArrayList<Result> getMatchingResults(String articleHeadline) {
    	ArrayList<String> headlineWords = StringUtils.getWords(articleHeadline);
    	ArrayList<Result> matchingResults = new ArrayList<Result>();
    	
    	for (int i = 0; i < results().getCount(); i++) {
    		String resultText = results().getElement(i).getText();
    		Result result = new Result(resultText);
    		for(String word : result.getWords()) {
    			if(headlineWords.contains(word)) {
    				result.addMatchedWord(word);
    			}
    		}
    		if(result.getMatchedWordCount() > 0) {
    			matchingResults.add(result);
    		}
    	}
    	
    	return matchingResults;	
    }
    
    /**
     * 
     * @param results
     * @param percentageRatio
     * @return results that have at least the percentage ratio of the words matched
     */
    public ArrayList<Result> getHighRelevanceResults(ArrayList<Result> results, int percentageRatio) {
    	ArrayList<Result> highRelevanceResults = new ArrayList<Result>();
    	
    	for(Result result : results) {
    		if(result.getMatchedWordCount() >= result.getWordCount() / percentageRatio) {
    			highRelevanceResults.add(result);
    		}
    	}
    	
    	return highRelevanceResults;
    } 
}
