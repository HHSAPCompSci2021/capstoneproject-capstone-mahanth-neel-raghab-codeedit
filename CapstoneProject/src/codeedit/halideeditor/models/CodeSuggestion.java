package codeedit.halideeditor.models;

public class CodeSuggestion implements Comparable<CodeSuggestion> {
    private String name;
   	private String[] params;
	private String[] returnValues;

	public CodeSuggestion(String name) {
		this.name = name;
	}

	public CodeSuggestion(String name, String[] params, String[] returnValues) {
		this.name = name;
		this.params = params;
		this.returnValues = returnValues;
	}

    public String getName() {
		return name;
	}

    public String[] getParams() {
		return params;
	}

	public String[] getReturnValues() {
		return returnValues;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		CodeSuggestion o = (CodeSuggestion) obj;
		/*TODO
		 * Make work properly with name, params, and returnValues
		 */
		
		if (o.name.equals(name))
			return true;
		return false;
	}
	
	@Override
	public int compareTo(CodeSuggestion o) {
		return this.name.compareTo(o.name);
	}
}
