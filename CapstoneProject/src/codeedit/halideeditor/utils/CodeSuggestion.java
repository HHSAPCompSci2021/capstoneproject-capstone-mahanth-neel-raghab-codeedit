package codeedit.halideeditor.utils;

public class CodeSuggestion implements Comparable<CodeSuggestion>{
	private String name;
	//0=field, 1=method, 2 keyword
	private int type;
	
	
	public CodeSuggestion (String name) {
		this.name = name;
	}
	
	public CodeSuggestion (String name, int type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(CodeSuggestion o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}
	
	public boolean equals(Object o) {
		return name.equals(((CodeSuggestion)o).name);
	}
	
	public String getName() {
		return name;
	}
	
	public int getType() {
		return type;
	}
}
