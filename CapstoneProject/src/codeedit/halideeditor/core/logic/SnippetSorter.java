package codeedit.halideeditor.core.logic;

import java.util.NavigableMap;
import java.util.TreeMap;
import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.models.CodeSuggestion;

public class SnippetSorter {
	private NavigableMap<CodeSuggestion, Integer> suggestions;

	public SnippetSorter() {
		suggestions = new TreeMap<>();
	}

	public SnippetSorter(CodeSuggestion[] suggs, int[] occurences) {
		this.suggestions = new TreeMap<>();
		for (int i = 0; i < suggs.length; i++) {
			suggestions.put(suggs[i], occurences[i]);
		}
	}
	
	public void fill(CodeSuggestion[] suggs, int[] occurences) {
		suggestions.clear();
		for (int i = 0; i < suggs.length; i++) {
			suggestions.put(suggs[i], occurences[i]);
		}
	}

	public void fill(JavaCodeEditor j) {
		// Clear the treemap
		suggestions.clear();
		String text = j.getText();
		String s = "";

		int cursorPos = j.getCodeArea().getCaretPosition();
		// Temporary display code
		System.out.println(cursorPos);
		for (int i = cursorPos - 1; i >= 0; i--) {
			if (text.charAt(i) == ' ') {
				if (text.indexOf(" ", i + 1) != -1) {
					s = text.substring(i + 1, text.indexOf(" ", i + 1));
				} else if (text.indexOf("\n", i + 1) != -1) {
					s = text.substring(i + 1, text.indexOf("\n", i + 1));
				} else {
					s = text.substring(i + 1);
				}

				break;
			}
		}

		System.out.println(s + "-");
		if (s.trim().isEmpty()) {
			return;
		}

		String l = "";
		for (int i = text.indexOf(s); i != -1; i = text.indexOf(s, i + 1)) {
			if (text.indexOf(" ", i) != -1) {
				if (i + s.length() != text.length())
					l = text.substring(i + s.length(), text.indexOf(" ", i));
			} else if (text.indexOf("\n", i) == -1) {
				if (i + s.length() != text.length())
					l = text.substring(i + s.length(), text.indexOf("\n", i));
			} else if (i + s.length() != text.length())
				l = text.substring(i + s.length());
			CodeSuggestion t = new CodeSuggestion(l);
			if (suggestions.containsKey(t))
				suggestions.put(t, suggestions.get(t) + 1);
			else {
				suggestions.put(t, 1);
			}
		}
	}

	public void sortResults() {
		suggestions = suggestions.descendingMap();
	}

	public CodeSuggestion[] getSuggestions(int numSuggestions) {
		if (numSuggestions > suggestions.size())
			numSuggestions = suggestions.size();
		CodeSuggestion[] returned = new CodeSuggestion[numSuggestions];
		int i = 0;
		for (CodeSuggestion s : suggestions.navigableKeySet()) {
			if (i >= numSuggestions)
				break;
			returned[i] = s;
			i++;
		}
		return returned;
	}
}
