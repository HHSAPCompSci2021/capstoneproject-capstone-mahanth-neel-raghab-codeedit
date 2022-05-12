package autocomp;

public class Suggestion {
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

}
