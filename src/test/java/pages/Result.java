package test.java.pages;

import java.util.ArrayList;

import test.java.utils.StringUtils;

public class Result {
	private String result;
	private ArrayList<String> matchedWords = new ArrayList<>();
	
	public Result(String result) {
		this.result = result;
	}
	
	public void addMatchedWord(String word) {
		matchedWords.add(word);
	}
	
	public ArrayList<String> getWords() {
		return StringUtils.getWords(result);
	}
	
	public int getWordCount() {
		return getWords().size();
	}
	
	public ArrayList<String> getMatchedWords() {
		return matchedWords;
	}
	
	public int getMatchedWordCount() {
		return matchedWords.size();
	}
	
	public String getResult() {
		return result;
	}
}
