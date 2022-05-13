package testing;

import javax.swing.JFrame;

import org.fife.rsta.ac.LanguageSupport;
import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.java.JavaLanguageSupport;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Window extends JFrame {

    public Window() {

        RSyntaxTextArea editor = new RSyntaxTextArea();
        editor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        editor.setCodeFoldingEnabled(true);

        // LanguageSupportFactory languageSupportFactory = LanguageSupportFactory.get();
        // JavaLanguageSupport javaLanguageSupport = (JavaLanguageSupport) languageSupportFactory.getSupportFor(SyntaxConstants.SYNTAX_STYLE_JAVA);
        // javaLanguageSupport.install(editor);

        RTextScrollPane scrollEditor = new RTextScrollPane(editor);
        
        this.add(scrollEditor);
    }
    
}