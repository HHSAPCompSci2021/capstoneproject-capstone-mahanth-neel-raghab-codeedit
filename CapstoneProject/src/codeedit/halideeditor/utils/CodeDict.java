package codeedit.halideeditor.utils;

import java.util.ArrayList;

public class CodeDict {
	public static final String[] JAVA_KEYWORDS = {
			"abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum", "extends", "false",
			"final", "finally", "float", "for", "goto", "if", "implements",
			"import", "instanceof", "int", "interface", "long", "native",
			"new", "null", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "true",
			"try", "void", "volatile", "while"
	};

	private static ArrayList<String> METHODS = new ArrayList<>();
	private static ArrayList<String> FIELDS = new ArrayList<>();

	public static ArrayList<String> getMethods() {
		return METHODS;
	}

	public static ArrayList<String> getFields() {
		return FIELDS;
	}

	public static void addMethod(String s) {
		METHODS.add(s);
	}

	public static void addField(String s) {
		FIELDS.add(s);
	}
}
