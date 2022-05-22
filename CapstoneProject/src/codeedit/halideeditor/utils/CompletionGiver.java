package codeedit.halideeditor.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;

import org.fife.ui.autocomplete.*;

import codeedit.halideeditor.components.JavaCodeEditor;

public class CompletionGiver {
	 private CompletionProvider provider;
	 AutoCompletion ac;
	 SnippetSorter s;
	 
	 public CompletionGiver () {
		 provider=createCompletionProvider();
		 s = new SnippetSorter();
	 }
	 
	 public CodeSuggestion[] getSuggestions (JavaCodeEditor textArea) { 
		 List <Completion> l= provider.getCompletions(textArea.getCodeEditor().getTextArea());
		 CodeSuggestion[] c = new CodeSuggestion[l.size()];
		 int[] k = new int[l.size()];
		 String s = textArea.getText();
		 int counter;
		 String t;
		 for (int i=0; i < l.size(); i++) {
			 t = l.get(i).toString();
			 c[i]=new CodeSuggestion(t, getType(t));
			 counter=0;
			 for (int j=s.indexOf(t); j !=-1; j=s.indexOf(t, j+1)) {
				 counter++;
				 if (j==s.length()-1)
					 j=-1;
			 }
			 k[i]=counter;
		 }
		 this.s.fill(c, k);
		 return this.s.getSuggestions();
	 }

	private CompletionProvider createCompletionProvider() {
		 DefaultCompletionProvider provider = new DefaultCompletionProvider();
		 for (int i = 0; i< CodeDict.JAVA_KEYWORDS.length; i++) {
			 provider.addCompletion(new BasicCompletion(provider, CodeDict.JAVA_KEYWORDS[i]));
		 }
		 return provider;
	}
	
	private int getType (String s) {
		boolean j = false;
		for (int i = 0; i < CodeDict.JAVA_KEYWORDS.length; i++) {
			if (CodeDict.JAVA_KEYWORDS[i].equals(s))
				return 2;
		}
		for (int i = 0; i < CodeDict.getMethods().size(); i++) {
			if (CodeDict.getMethods().get(i).equals(s))
				return 1;
		}
		return 0;
	}
}