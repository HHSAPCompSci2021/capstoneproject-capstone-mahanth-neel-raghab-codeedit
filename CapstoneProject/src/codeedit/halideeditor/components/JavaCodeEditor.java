package codeedit.halideeditor.components;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Color;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import static org.fife.ui.rsyntaxtextarea.SyntaxConstants.SYNTAX_STYLE_JAVA;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.formdev.flatlaf.ui.FlatScrollPaneUI;
import com.formdev.flatlaf.ui.FlatTextAreaUI;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class JavaCodeEditor extends JPanel {
    private RTextScrollPane codeEditor;
    private Font editorFont;
    private RSyntaxTextArea codeArea;

    public JavaCodeEditor() {
        super(new BorderLayout());
        codeArea = new RSyntaxTextArea();
        codeArea.setSyntaxEditingStyle(SYNTAX_STYLE_JAVA);
        codeArea.setCodeFoldingEnabled(true);
        String sep = System.getProperty("file.separator");
        String wspaceRoot = System.getProperty("user.dir");
        try {
            editorFont = Font.createFont(Font.TRUETYPE_FONT, new File(wspaceRoot + sep + "res" + sep + "font.ttf"));
            editorFont = editorFont.deriveFont(15);
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(editorFont);
            codeArea.setFont(editorFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        codeArea.setUI(new FlatTextAreaUI());
        codeEditor = new RTextScrollPane(codeArea);
        codeEditor.setUI(new FlatScrollPaneUI());

        // VSCode-like settings defaults
        codeArea.setAntiAliasingEnabled(true);
        codeArea.setTabSize(4);
        codeArea.setAutoIndentEnabled(true);
        add(codeEditor);
    }

    public void setText(String data) {
        codeEditor.getTextArea().setText(data);
    }

    public String getText() {
        return codeEditor.getTextArea().getText();
    }
    
    public RSyntaxTextArea getCodeArea() {
    	return codeArea;
    }
}
