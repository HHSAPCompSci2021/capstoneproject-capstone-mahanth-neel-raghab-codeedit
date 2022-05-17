package codeedit.halideeditor.components;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.formdev.flatlaf.ui.FlatScrollPaneUI;
import com.formdev.flatlaf.ui.FlatTextAreaUI;
import java.awt.Font;
import java.io.File;

public class JavaCodeEditor extends JPanel {
    private RTextScrollPane codeEditor;
    private Font editorFont;

    public JavaCodeEditor() {
        super(new BorderLayout());
        RSyntaxTextArea codeArea = new RSyntaxTextArea();
        codeArea.setSyntaxEditingStyle(SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        String sep = System.getProperty("file.separator");
        String fontPath = System.getProperty("user.dir") + sep + "res" + sep + "font.ttf";
        try {
            editorFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            editorFont = editorFont.deriveFont(15);
            codeArea.setFont(editorFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        codeArea.setUI(new FlatTextAreaUI());
        codeEditor = new RTextScrollPane(codeArea); // TODO: Make field?
        codeEditor.setUI(new FlatScrollPaneUI());
        add(codeEditor);
    }

    public void setText(String data) {
        codeEditor.getTextArea().setText(data);
    }

    public String getText() {
        return codeEditor.getTextArea().getText();
    }
}
