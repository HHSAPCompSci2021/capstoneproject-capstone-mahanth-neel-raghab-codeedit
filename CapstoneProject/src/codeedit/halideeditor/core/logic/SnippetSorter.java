package codeedit.halideeditor.core.logic;

import java.util.TreeMap;

import javax.swing.JTextArea;

import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.models.CodeSuggestion;

import java.util.ArrayList;

public class SnippetSorter {
	private TreeMap<CodeSuggestion, Integer> suggestions;

	public SnippetSorter(CodeSuggestion[] suggs, int[] nums) {
		this.suggestions = new TreeMap<>();
		for (int i = 0; i < suggs.length; i++) {
			suggestions.put(suggs[i], nums[i]);
		}

	}

	public SnippetSorter() {
		suggestions = new TreeMap<>();
	}
	
    public void fill(JavaCodeEditor j) {
    	suggestions.clear();
    	String text = j.getText();
    	String s="";
    	System.out.println(j.getCodeArea().getCaretPosition());
    	for (int i =j.getCodeArea().getCaretPosition()-1;i>=0;i--) {
    		if (text.charAt(i)==' ') {
    			if (text.indexOf(" ", i+1)!=-1)
    				s=text.substring(i+1, text.indexOf(" ", i+1));
    			else if (text.indexOf("\n", i+1)!=-1)
    				s=text.substring(i+1, text.indexOf("\n", i+1));
    			else s=text.substring(i+1);
    			break;
    		}
    	}
    	System.out.println(s+"-");
    	if (s.trim().isEmpty()) 
    		return;
    	String l="";
    	for (int i=text.indexOf(s);i!=-1;i=text.indexOf(s,i+1)) {
    		if (text.indexOf(" ", i)!=-1) {
    			if (i+s.length()!=text.length())
    				l=text.substring(i+s.length(), text.indexOf(" ", i));
    		}
    		else if (text.indexOf("\n", i)==-1) {
    			if (i+s.length()!=text.length())
    				l=text.substring(i+s.length(), text.indexOf("\n", i));
    		}
    		else if (i+s.length()!=text.length())
    			l=text.substring(i+s.length());
    		CodeSuggestion t=new CodeSuggestion(l);
    		if (suggestions.containsKey(t)) 
    			suggestions.put(t, suggestions.get(t)+1);
    		else {
    			suggestions.put(t, 1);
    		}
    	}
    }

    public void sortResults() {
    	suggestions=(TreeMap)suggestions.descendingMap();
    	
    	//suggestions.sort((o2, o) -> Integer.compare(suggestions2.get(o), suggestions2.get(o2)));
    }

    public CodeSuggestion[] getSuggestions(int numSuggestions) {
    	if (numSuggestions>suggestions.size())
    		numSuggestions=suggestions.size();
    	CodeSuggestion[] returned = new CodeSuggestion[numSuggestions];
    	int i=0;
    	for (CodeSuggestion s : suggestions.navigableKeySet()) {
    		if (i>=numSuggestions)
    			break;
    		returned[i]=s;
    		i++;
    	}
        return returned;
    }
}
