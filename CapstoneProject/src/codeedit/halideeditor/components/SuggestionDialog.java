package codeedit.halideeditor.components;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import codeedit.halideeditor.utils.CodeSuggestion;

/**
 * A class that is responsible for the SuggestionDialog that pops up when the user tries to autocomplete
 * @author Mahanth Mohan
 * @version 05/23/2022
 */
public class SuggestionDialog extends JPopupMenu {
    private JavaCodeEditor editor;
    private JScrollPane scrollPane;
    
    public SuggestionDialog(JavaCodeEditor editor) {
        super();
        this.editor = editor;
        scrollPane = new JScrollPane();
        setLocation(0, 0);
        setSize(new Dimension(50, 75));
        setVisible(true);
    }

    public SuggestionDialog(CodeSuggestion[] sugs, int numSugs, JavaCodeEditor editor) {
        super("Code Completions");
        this.editor = editor;
        scrollPane = new JScrollPane(this);

        setSize(new Dimension(125, 62));
        Point cursorPos = editor.getCursorPosition();
        Point dialogPos = new Point((int) cursorPos.getX(), (int) cursorPos.getY());
       
        if (numSugs > sugs.length) {
            numSugs = sugs.length;
        }
        
        for (int i = 0; i < numSugs; i++) {
            add(new SugItem(this, sugs[i].toString()));
        }

        setLocation(cursorPos);
        setVisible(true);
    }
    
    public void complete(String suggestion) {
        String code = editor.getText();
        int curPos = editor.getCaretPosition();
        code = code.substring(0, curPos) + suggestion + code.substring(curPos);
        editor.setText(code);
        editor.setCursorPosition(curPos);
    }
}
