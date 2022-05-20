package codeedit.halideeditor.models;

public class CodeSuggestion implements Comparable<CodeSuggestion> {
	// 0 = field, 1 = method
	private int type;
	private String name;

	public CodeSuggestion(String name, int type) {
		this.name = name;
		this.type = type;
	}

	public CodeSuggestion(String name, String[] params, String[] returnValues) {
		this.name = name;
		type = 1;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		CodeSuggestion o = (CodeSuggestion) obj;
		/*
		 * TODO
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

	public int getType() {
		return type;
	}
}
