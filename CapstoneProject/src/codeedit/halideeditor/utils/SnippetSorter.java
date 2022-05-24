package codeedit.halideeditor.utils;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Sorts the possible completions
 * 
 * @author Raghab, Mahanth
 *
 */
public class SnippetSorter {
	/**
	 * A map containing thr suggestions and how often they occur
	 */
	NavigableMap<Integer, CodeSuggestion> suggs;
	/**
	 * Empty constructor, only for if you use the fill method later
	 */
	public SnippetSorter() {
		suggs = new TreeMap<>();
	}
	/**
	 * Constructs the snippet sorter class with the given parameters
	 * @param suggestions an array of possible completions
	 * @param occurences how often the completions occur in your code
	 */
	public SnippetSorter(CodeSuggestion[] suggestions, int[] occurences) {
		suggs = new TreeMap<>();
		fill(suggestions, occurences);
	}
	/**
	 * Fills the snippet sorter with the given parameters
	 * @param suggestions an array of possible completions
	 * @param occurences how often the completions occur in your code
	 */
	public void fill(CodeSuggestion[] suggestions, int[] occurences) {
		suggs.clear();
		for (int i = 0; i < suggestions.length; i++) {
			suggs.put(occurences[i], suggestions[i]);
		}
	}
	/**
	 * sorts the suggestions based on the occurences
	 * @return an array with the completions sorted from most common to least common
	 */
	private CodeSuggestion[] sort() {
		suggs = suggs.descendingMap();	
		CodeSuggestion[] sortedResult =  suggs.values().toArray(CodeSuggestion[]::new);
		return sortedResult;
	}
	/**
	 * returns an amount of sorted suggestions from most to least used
	 * @param n the amount of suggestions that are returned
	 * @return an array of the n most common suggestions
	 */
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
	/**
	 * gives a sorted list of all the suggestion from most common to least common
	 * @return the array of the sorted suggestions
	 */
	public CodeSuggestion[] getSuggestions() {
		return sort();
	}
}
