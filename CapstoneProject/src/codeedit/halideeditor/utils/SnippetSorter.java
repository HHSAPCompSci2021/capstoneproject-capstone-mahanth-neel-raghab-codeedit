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
	NavigableMap<CodeSuggestion, Integer> suggs;

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
			suggs.put(suggestions[i], occurences[i]);
		}
	}

	private List<CodeSuggestion> sort() {
		ArrayList<CodeSuggestion> returned = new ArrayList<>();
		returned.addAll(suggs.keySet());
		returned.sort((o1, o2) -> suggs.get(o2) - suggs.get(o1));
		return returned;
	}

	public CodeSuggestion[] getSuggestions(int n) {
		if (n > suggs.size()) {
			n = suggs.size();
		}

		CodeSuggestion[] result = new CodeSuggestion[n];
		int i =0;
		for (CodeSuggestion c : sort()) {
			if (i==n)
				break;
			result[i]=c;
			i++;
		}
		
		return result;
	}

	public CodeSuggestion[] getSuggestions() {
		CodeSuggestion[] result = new CodeSuggestion[suggs.size()];
		int i =0;
		for (CodeSuggestion c : sort()) {
			result[i]=c;
			i++;
		}

		return result;
	}
}
