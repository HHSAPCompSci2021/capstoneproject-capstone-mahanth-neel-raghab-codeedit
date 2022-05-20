package autocomp.server;

import java.util.ArrayList;

/**
 * This class contains a list of all the Java keywords,
 * to be used by the CompletionService incase it cannot provide autocompletion.
 * @author Mahanth
 * @version 5/19/2022
 */
public class CodeDict {
    public static final String[] JAVA_KEYWORDS = new String[] {
        "abstract",
        "continue",
        "for",
        "new",
        "switch",
        "assert",
        "default",
        "goto",
        "package",
        "synchronized",
        "boolean",
        "do",
        "if",
        "private",
        "this",
        "break",
        "double",
        "implements",
        "protected",
        "throw",
        "byte",
        "else",
        "import",
        "public",
        "throws",
        "case",
        "enum",
        "instanceof",
        "return",
        "transient",
        "catch",
        "extends",
        "int",
        "short",
        "try",
        "char",
        "final",
        "interface",
        "static",
        "void",
        "class",
        "finally",
        "long",
        "strictfp",
        "volatile",
        "const",
        "float",
        "native",
        "super",
        "while"
    };

    private ArrayList<String> existingCodeSnippets;

    public CodeDict() {
        existingCodeSnippets = new ArrayList<>();
    }
}