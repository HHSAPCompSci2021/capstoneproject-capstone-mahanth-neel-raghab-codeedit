package codeedit.halideeditor.components;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import codeedit.halideeditor.models.EditorFile;

/**
 * Defines a file chooser for Java files.
 * @author Neel Sudhakaran
 */
public class JavaFileChooser extends JFileChooser {
    
    /**
     * Creates a file chooser that filters out non-Java files.
     */
    public JavaFileChooser() {
        FileNameExtensionFilter javaFileFilter = new FileNameExtensionFilter("Java Files", "java");
        setFileFilter(javaFileFilter);
    }

    /**
     * Gets a file after a given prompt action.
     * @param status the status of the prompt action
     * @return the file "chosen"
     */
    private EditorFile chooseAction(int status) {
        if (status != JFileChooser.APPROVE_OPTION) return null;
        return new EditorFile(getSelectedFile());
    }

    /**
     * Promts the user to create a new file.
     * @return the file created
     */
    public EditorFile newAction() {
        return chooseAction(showDialog(null, "New"));
    }

    /**
     * Promts the user to create a open a file.
     * @return the file to open
     */
    public EditorFile openAction() {
        return chooseAction(showOpenDialog(null));
    }

    /**
     * Promts the user to save a file.
     * @return the file to save to
     */
    public EditorFile saveAction() {
        return chooseAction(showSaveDialog(null));
    }
    
}
