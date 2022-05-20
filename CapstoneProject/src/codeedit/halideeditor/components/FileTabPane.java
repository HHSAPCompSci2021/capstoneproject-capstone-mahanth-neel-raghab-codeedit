package codeedit.halideeditor.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import codeedit.halideeditor.models.EditorFile;

/**
 * Represents a {@code FileTabPane} that handles actions and graphics associated with the user's various files.
 * @author Neel Sudhakaran
 */
public class FileTabPane extends JTabbedPane {

    /**
     * The list of active files in the {@code FileTabPane}.
     */
    private List<EditorFile> files;

    /**
     * Creates a new, empty {@code FileTabPane}.
     */
    public FileTabPane() {
        files = new ArrayList<>();
    }

    /**
     * Opens the specified file in the {@code FileTabPane}.
     * @param file the file to open
     */
    public void openFile(EditorFile file) {
        if(files.contains(file)) return;

        files.add(file);
        JavaCodeEditor editor = new JavaCodeEditor();
        editor.setText(file.read());
        addTab(file.getName(), new FileIcon(), editor);
        switchToTab(getSelectedIndex() + 1);
       
    }

    /**
     * Closes the specified file in the {@code FileTabPane}.
     * @param file the file to close
     */
    public void closeFile(EditorFile file) {
        int removalIndex = files.indexOf(file);
        removeTabAt(removalIndex);
        files.remove(removalIndex);
    }

    /**
     * Gets the current active {@code EditorFile}.
     * @return the current active file
     */
    public EditorFile getCurrentFile() {
        return files.get(getSelectedIndex());
    }

    /**
     * Gets the current editor for the active file.
     * @return the current editor
     */
    public JavaCodeEditor getCurrentEditor() {
        return (JavaCodeEditor) getSelectedComponent();
    }

    /**
     * Switches the active file tab to the one at the specified index (if that exists).
     * @param index the index to switch to
     */
    public void switchToTab(int index) {
        if(index < getTabCount() && index >= 0) setSelectedIndex(index);
    }

}
