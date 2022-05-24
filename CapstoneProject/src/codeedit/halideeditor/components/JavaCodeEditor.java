package codeedit.halideeditor.components;

import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import java.awt.Point;

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

    /**
     * Gets the code editor contained within this widget
     * @return the code editor contained within this widget

     */
    public RTextScrollPane getCodeEditor() {
        return codeEditor;
    }

    /**
     * Sets the cursor to the given position
     * @param pos the position offset from the start
     */
    public void setCursorPosition(int pos) {
        codeEditor.getTextArea().setCaretPosition(pos);
    }

    /**
     * Gets the current position of the cursor
     * @return the position of the cursor with respect to the start of the textarea
     */
    public int getCaretPosition() {
        return codeEditor.getTextArea().getCaretPosition();
    }

    /**
     * Gets the position of the cursor with respect to the window
     * @return the point with (x, y) coordinates representing the cursor's position
     */
    public Point getCursorPosition() {
        return codeEditor.getTextArea().getCaret().getMagicCaretPosition();
    }

    public int getLineHeight() {
        return codeEditor.getTextArea().getLineHeight();
    }
}
