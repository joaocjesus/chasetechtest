package test.java.utils;

import java.util.ArrayList;

public class StringUtils {
	public static ArrayList<String> getWords(String sentence) {
		String[] words = sentence.split("\\W+");
		ArrayList<String> filteredWords = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			// Filters out single characters
			if (words[i].length() >= 2) {
				filteredWords.add(words[i]);
			}
		}
		return filteredWords;
	}
}
