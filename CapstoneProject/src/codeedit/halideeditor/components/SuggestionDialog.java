package codeedit.halideeditor.components;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import codeedit.halideeditor.utils.CodeSuggestion;

public class SuggestionDialog extends JPopupMenu {
    private JavaCodeEditor editor;

    public SuggestionDialog(JavaCodeEditor editor) {
        super();
        this.editor = editor;
        setLocation(0, 0);
        setVisible(true);
    }

    public SuggestionDialog(CodeSuggestion[] sugs, int numSugs, JavaCodeEditor editor) {
        super("Code Completions");
        this.editor = editor;
        setLocation(editor.getDialogLocation(50, 20));
        for (int i = 0; i < numSugs; i++) {
            add(new JMenuItem(sugs[i].toString()));
        }

        setVisible(true);
    }

    public void complete(String suggestion) {
        String code = editor.getText();
        int line = editor.getCurrentLine();
        int cursorPos = editor.getCaretPosition();
        String[] lines = code.split("\n");
        StringBuilder contents = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            if (i == line) {
                String curLine = lines[i];
                String completed = curLine.substring(0, cursorPos) + suggestion + curLine.substring(cursorPos + 1);
                contents.append(completed + "\n");
            } else {
                contents.append(lines[i] + "\n");
            }
        }

        editor.setText(contents.substring(0, contents.length() - 1));
    }

    public JavaCodeEditor getEditor() {
        return editor;
    }
}
