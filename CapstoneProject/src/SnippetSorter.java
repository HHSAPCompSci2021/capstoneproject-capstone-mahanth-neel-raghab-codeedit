import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SnippetSorter {
		ArrayList<Suggestion> suggestions;
		ArrayList<Integer> occurences;
    public SnippetSorter(Suggestion[] suggs, int[] nums) {
        this.suggestions = new ArrayList<>();
        this.occurences = new ArrayList<>();
        for (int i=0;i<suggs.length;i++) {
        	suggestions.add(suggs[i]);
        	occurences.add(nums[i]);
        }
        
    }

    public void sortResults() {
    	int l;
    	int h;
    	for (int i=0;i<occurences.size();i++) {
    		h=i;
    		l=occurences.get(h);
    		for (int j=i+1;j<occurences.size();j++) {
    			if (occurences.get(j)>l) {
    				l=occurences.get(j);
    				h=j;
    			}
    		}
    		occurences.add(0, occurences.remove(h));
    		suggestions.add(0, suggestions.remove(h));
    	}
    }

    public Suggestion[] getSuggestions(int numSuggestions) {
    	Suggestion[] returned = new Suggestion[numSuggestions];
    	for (int i=0;i<numSuggestions;i++) {
    		returned[i]=suggestions.get(i);
    	}
        return returned;
    }
}
