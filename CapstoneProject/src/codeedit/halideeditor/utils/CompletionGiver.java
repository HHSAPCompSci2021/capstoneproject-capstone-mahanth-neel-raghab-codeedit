package codeedit.halideeditor.utils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.java.JavaLanguageSupport;
import org.fife.rsta.ac.java.rjc.ast.CompilationUnit;
import org.fife.rsta.ac.java.rjc.ast.Field;
import org.fife.rsta.ac.java.rjc.ast.Member;
import org.fife.rsta.ac.java.rjc.ast.Method;
import org.fife.rsta.ac.java.rjc.ast.NormalClassDeclaration;
import org.fife.rsta.ac.java.rjc.ast.TypeDeclaration;
import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import codeedit.halideeditor.components.JavaCodeEditor;

/**
 * A class that provides a list of possible autocompletion snippets whenever the
 * user hits the ctrl+tab key
 * 
 * @author Raghab, Mahanth
 * @version 05/22/2022
 */
public class CompletionGiver {
	private CompletionProvider provider;
	AutoCompletion ac;
	SnippetSorter s;

	public CompletionGiver() {
		provider = createCompletionProvider();
		s = new SnippetSorter();
	}

	public CodeSuggestion[] getSuggestions(JavaCodeEditor textArea) {
		List<Completion> comps = provider.getCompletions(textArea.getCodeEditor().getTextArea());
		CodeSuggestion[] c = new CodeSuggestion[comps.size()];
		int[] k = new int[comps.size()];
		String code = textArea.getText();
		int counter;
		String t;
		for (int i = 0; i < comps.size(); i++) {
			t = comps.get(i).toString();
			c[i] = new CodeSuggestion(t, getType(t));
			counter = 0;
			for (int j = code.indexOf(t); j != -1; j = code.indexOf(t, j + 1)) {
				counter++;
				if (j == code.length() - 1)
					j = -1;
			}
			k[i] = counter;
		}
		System.out.println(Arrays.toString(c));
		this.s.fill(c, k);
		return this.s.getSuggestions();
	}

	private CompletionProvider createCompletionProvider() {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		for (String sug : CodeDict.JAVA_KEYWORDS) {
			provider.addCompletion(new BasicCompletion(provider, sug));
		}

		return provider;
	}

	private int getType(String s) {
		for (String k : CodeDict.JAVA_KEYWORDS) {
			if (k.equals(s))
				return 2;
		}

		for (String m : CodeDict.METHODS) {
			if (m.equals(s)) {
				return 1;
			}
		}

		return 0;
	}

	public void update(JavaCodeEditor textArea) {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		LanguageSupportFactory lsf = LanguageSupportFactory.get();
		JavaLanguageSupport support = (JavaLanguageSupport) lsf.getSupportFor(SyntaxConstants.SYNTAX_STYLE_JAVA);
		// for (int i = 0; i < f.getTabCount(); i++) {
		System.out.println("cycle");
		CompilationUnit c = support.getParser((RSyntaxTextArea) (textArea.getCodeEditor().getTextArea()))
				.getCompilationUnit();
		System.out.println(c);
		for (Iterator<TypeDeclaration> k = c.getTypeDeclarationIterator(); k.hasNext();) {
			TypeDeclaration td = k.next();
			System.out.println(td.getName());
			if (td instanceof NormalClassDeclaration) {
				System.out.println("tower defence");
				NormalClassDeclaration ncd = (NormalClassDeclaration) td;
				for (Iterator<Member> g = ncd.getMemberIterator(); g.hasNext();) {
					Member m = g.next();
					if (m instanceof Method) {
						Method m1 = (Method) m;
						CodeDict.METHODS.add(m1.getName());
						System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM" + m1.getName());
						provider.addCompletion(new BasicCompletion(provider, m1.getName(),
								m1.getType() == null ? "<constructor>" : m1.getType().toString()));

					}
					if (m instanceof Field) {
						m = (Field) m;
						CodeDict.FIELDS.add(m.getName());
						System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF" + m.getName());
						provider.addCompletion(new BasicCompletion(provider, m.getName(), m.getType().toString()));
					}
				}
			}
		}
		
		for (int i = 0; i < CodeDict.JAVA_KEYWORDS.length; i++) {
			provider.addCompletion(new BasicCompletion(provider, CodeDict.JAVA_KEYWORDS[i]));
		}

		this.provider = provider;
		System.out.println(this.provider.getCompletions(textArea.getCodeEditor().getTextArea()));
	}
}