package codeedit.halideeditor.components;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;
import org.fife.ui.rtextarea.RTextScrollPane;

public class JavaCodeEditor extends JPanel {

    private RSyntaxTextArea codeArea;
    
    public JavaCodeEditor() {
        super(new BorderLayout());
        codeArea = new RSyntaxTextArea();
        codeArea.setSyntaxEditingStyle(SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        RTextScrollPane codeEditor = new RTextScrollPane(codeArea); // TODO: Make field?
        this.add(codeEditor);
    }

    public void setText(String data) {
        codeArea.setText(data);
    }

    public String getText() {
        return codeArea.getText();
    }
 
}
