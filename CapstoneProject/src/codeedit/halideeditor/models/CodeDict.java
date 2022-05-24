package codeedit.halideeditor.models;

import java.util.ArrayList;
/**
 * a class that contains the java keywords, methods, fields, and custom code snippets
 * @author Raghab Baruah
 *
 */
public class CodeDict {
	/**
	 * an array of all the java keywords
	 */
	public static final String[] JAVA_KEYWORDS = { "abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum", "extends", "false",
			"final", "finally", "float", "for", "goto", "if", "implements",
			"import", "instanceof", "int", "interface", "long", "native",
			"new", "null", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "true",
			"try", "void", "volatile", "while" };
	/**
	 * An array of the methods in the code
	 */
	public static ArrayList<String> METHODS = new ArrayList<>();
	/**
	 * An array of the fields in the code
	 */
	public static ArrayList<String> FIELDS = new ArrayList<>();
	/**
	 * An array of the custom snippets
	 */
	public static ArrayList<String> SNIPPETS = new ArrayList<>();
}