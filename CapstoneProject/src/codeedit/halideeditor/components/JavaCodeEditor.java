package codeedit.halideeditor.components;

import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;

import java.awt.BorderLayout;

//<<<<<<< HEAD
import javax.swing.JPanel;

//=======
import org.fife.rsta.ac.LanguageSupportFactory;
//>>>>>>> 8d418bff22138969126248092efc97365c701cd4
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Defines a syntax-higlighted code editor for Java code.
 * 
 * @author Neel Sudhakaran
 */
public class JavaCodeEditor extends JPanel {

    /**
     * The component that represents the full code editor
     */
    private RTextScrollPane codeEditor;

    /**
     * Creates a new {@code JavaCodeEditor} with code-folding and scrolling
     * capabilities.
     */
    public JavaCodeEditor() {
        super(new BorderLayout());
        RSyntaxTextArea codeArea = new RSyntaxTextArea();
        LanguageSupportFactory.get().register(codeArea);
        LanguageSupportFactory.get().getSupportFor(SYNTAX_STYLE_JAVA).setAutoCompleteEnabled(false);
        codeArea.setSyntaxEditingStyle(SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        codeEditor = new RTextScrollPane(codeArea);
        add(codeEditor);
    }

    /**
     * Sets the text within the editor to the given data.
     * 
     * @param data the data to set the editor text to
     */
    public void setText(String data) {
        codeEditor.getTextArea().setText(data);
    }

    /**
     * Gets the current text within the editor.
     * 
     * @return the text within the editor
     */
    public String getText() {
        return codeEditor.getTextArea().getText();
    }

    public RTextScrollPane getCodeEditor() {
        return codeEditor;
    }
}
