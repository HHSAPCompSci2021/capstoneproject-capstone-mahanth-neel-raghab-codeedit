package codeedit.halideeditor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Sorts the possible completions
 * 
 * @author Raghab, Mahanth
 *
 */
public class SnippetSorter {
	NavigableMap<Integer, CodeSuggestion> suggs;

	public SnippetSorter() {
		suggs = new TreeMap<>();
	}

	public SnippetSorter(CodeSuggestion[] suggestions, int[] occurences) {
		suggs = new TreeMap<>();
		fill(suggestions, occurences);
	}

	public void fill(CodeSuggestion[] suggestions, int[] occurences) {
		suggs.clear();
		for (int i = 0; i < suggestions.length; i++) {
			suggs.put(occurences[i], suggestions[i]);
		}
	}

	private CodeSuggestion[] sort() {
		suggs = suggs.descendingMap();	
		CodeSuggestion[] sortedResult =  suggs.values().toArray(CodeSuggestion[]::new);
		return sortedResult;
	}

	public CodeSuggestion[] getSuggestions(int n) {
		if (n > suggs.size()) {
			n = suggs.size();
		}

		CodeSuggestion[] sortedSugs = sort();
		CodeSuggestion[] result = new CodeSuggestion[n];
		
		for (int i = 0; i < n; i++) {
			result[i] = sortedSugs[i];	
		}
		
		return result;
	}

	public CodeSuggestion[] getSuggestions() {
		return sort();
	}
}
