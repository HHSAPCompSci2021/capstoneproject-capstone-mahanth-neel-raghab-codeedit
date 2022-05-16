package codeedit.halideeditor.components;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;
import org.fife.ui.rtextarea.RTextScrollPane;

public class JavaCodeEditor extends JPanel {

    private RTextScrollPane codeEditor;
    
    public JavaCodeEditor() {
        super(new BorderLayout());
        RSyntaxTextArea codeArea = new RSyntaxTextArea();
        codeArea.setSyntaxEditingStyle(SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        codeEditor = new RTextScrollPane(codeArea); // TODO: Make field?
        add(codeEditor);
    }

    public void setText(String data) {
        codeEditor.getTextArea().setText(data);
    }

    public String getText() {
        return codeEditor.getTextArea().getText();
    }
}
