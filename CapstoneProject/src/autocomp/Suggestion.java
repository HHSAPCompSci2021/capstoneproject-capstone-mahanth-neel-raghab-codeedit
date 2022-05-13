package autocomp;

public class Suggestion implements Comparable<Suggestion> {
    private String name;
   	private String[] params;
	private String[] returnValues;

	public Suggestion(String name) {
		this.name = name;
	}

	public Suggestion(String name, String[] params, String[] returnValues) {
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
		Suggestion o=(Suggestion)obj;
		/*TODO
		 * Make work properly with name, params, and returnValues
		 */
		
		if (o.name.equals(name))
			return true;
		return false;
	}
	
	@Override
	public int compareTo(Suggestion o) {
		return this.name.compareTo(o.name);
	}
}
