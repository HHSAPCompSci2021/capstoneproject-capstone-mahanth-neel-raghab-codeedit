package codeedit.halideeditor.models;

public class CodeSuggestion implements Comparable<CodeSuggestion> {
	private String name;
	// 0 = field, 1 = method, 2 keyword
	private int type;

	public CodeSuggestion(String name) {
		this.name = name;
	}

	public CodeSuggestion(String name, int type) {
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(CodeSuggestion o) {
		return name.compareTo(o.name);  
	}

	public boolean equals(Object o) {
		if (o instanceof CodeSuggestion) {
			CodeSuggestion other = (CodeSuggestion) o;
			return name.equals(other.name);
		}

		return false;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}
}
