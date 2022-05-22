package codeedit.halideeditor.utils;

import java.util.List;

import org.fife.ui.autocomplete.*;

import codeedit.halideeditor.components.JavaCodeEditor;

/**
 * A class that provides a list of possible autocompletion snippets whenever the user hits the ctrl+tab key
 * @author Raghab, Mahanth
 * @version 05/22/2022
 */
public class CompletionGiver {
	private CompletionProvider provider;
	AutoCompletion ac;
	SnippetSorter s;

	public CompletionGiver() {
		provider = createCompletionProvider();
		s = new SnippetSorter();
	}

	public CodeSuggestion[] getSuggestions(JavaCodeEditor textArea) {
		List<Completion> comps = provider.getCompletions(textArea.getCodeEditor().getTextArea());
		CodeSuggestion[] c = new CodeSuggestion[comps.size()];
		int[] k = new int[comps.size()];
		String code = textArea.getText();
		int counter;
		String t;
		for (int i = 0; i < comps.size(); i++) {
			t = comps.get(i).toString();
			c[i] = new CodeSuggestion(t, getType(t));
			counter = 0;
			for (int j = code.indexOf(t); j != -1; j = code.indexOf(t, j + 1)) {
				counter++;
				if (j == code.length() - 1)
					j = -1;
			}
			k[i] = counter;
		}
		this.s.fill(c, k);
		return this.s.getSuggestions();
	}

	private CompletionProvider createCompletionProvider() {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		for (String sug : CodeDict.JAVA_KEYWORDS) {
			provider.addCompletion(new BasicCompletion(provider, sug));
		}
			
		return provider;
	}

	private int getType(String s) {
		for (String k : CodeDict.JAVA_KEYWORDS) {
			if (k.equals(s))
				return 2;
		}

		for (String m : CodeDict.getMethods()) {
			if (m.equals(s)) {
				return 1;
			}
		}

		return 0;
	}
}