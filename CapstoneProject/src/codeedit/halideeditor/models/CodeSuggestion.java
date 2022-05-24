package codeedit.halideeditor.models;

/**
 * Represents a Code Suggestion
 * @author Mahanth Mohan
 */
public class CodeSuggestion implements Comparable<CodeSuggestion> {
	
	/**
	 * Name of the code suggestion.
	 */
	private String name;
	// 0 = field, 1 = method, 2 keyword
	
	/**
	 * Type of the code suggestion.
	 */
	private int type;

	/**
	 * Creates a new code suggestion.
	 * @param name the suggestion name
	 */
	public CodeSuggestion(String name) {
		this.name = name;
	}

	/**
	 * Creates a new code suggestion.
	 * @param name the suggestion name
	 * @param type the suggestion type
	 */
	public CodeSuggestion(String name, int type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(CodeSuggestion o) {
		return name.compareTo(o.name);  
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CodeSuggestion) {
			CodeSuggestion other = (CodeSuggestion) o;
			return name.equals(other.name);
		}

		return false;
	}

	
	/**
	 * Gets the name of the suggestion
	 * @return the name of the suggestion.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the type of the suggestion.
	 * @return the type of the suggestion.
	 */
	public int getType() {
		return type;
	}
}
