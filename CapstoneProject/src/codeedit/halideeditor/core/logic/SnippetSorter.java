package codeedit.halideeditor.core.logic;

import java.util.TreeMap;

import javax.swing.JTextArea;

import codeedit.halideeditor.models.CodeSuggestion;

import java.util.ArrayList;

public class SnippetSorter {
		ArrayList<CodeSuggestion> suggestions;
	// ArrayList<Integer> occurences;
		TreeMap<CodeSuggestion, Integer> suggestions2;
    public SnippetSorter(CodeSuggestion[] suggs, int[] nums) {
        this.suggestions = new ArrayList<>();
        this.suggestions2=new TreeMap<>();
        for (int i=0;i<suggs.length;i++) {
        	suggestions.add(suggs[i]);
        	suggestions2.put(suggs[i], nums[i]);
        }
        
    }
    public SnippetSorter() {
    	suggestions2=new TreeMap<>();
    	suggestions = new ArrayList<>();
    }
    public void fill(JTextArea j) {
    	suggestions2.clear();
    	String text = j.getText();
    	String s="";
    	for (int i =j.getCaretPosition()-1;i>=0;i--) {
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
    		if (suggestions2.containsKey(t)) 
    			suggestions2.put(t, suggestions2.get(t)+1);
    		else {
    			suggestions2.put(t, 1);
    		}
    	}
    }

    public void sortResults() {
    	System.out.println(suggestions2);
    	/*
    	for (Map.Entry<Suggestion, Integer> entry : suggestions2.entrySet()) {
    		l=entry.getValue();
    		for (int j=i+1;j<occurences.size();j++) {
    			if (occurences.get(j)>l) {
    				l=occurences.get(j);
    				h=j;
    			}
    		}
    		occurences.add(0, occurences.remove(h));
    		suggestions.add(0, suggestions.remove(h));
    	}*/
    	
    	suggestions.addAll(suggestions2.keySet());
    	suggestions.sort((o2, o) -> Integer.compare(suggestions2.get(o), suggestions2.get(o2)));
    }

    public CodeSuggestion[] getSuggestions(int numSuggestions) {
    	if (numSuggestions>suggestions.size())
    		numSuggestions=suggestions.size();
    	CodeSuggestion[] returned = new CodeSuggestion[numSuggestions];
    	for (int i=0;i<numSuggestions;i++) {
    		returned[i]=suggestions.get(i);
    	}
        return returned;
    }
}
