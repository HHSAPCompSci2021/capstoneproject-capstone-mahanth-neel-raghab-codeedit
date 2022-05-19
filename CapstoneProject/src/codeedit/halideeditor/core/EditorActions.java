package codeedit.halideeditor.core;

import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaFileChooser;
import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.FileIOUtils;

public class EditorActions {
    public static void newFileAction(FileTabPane pane) {
        JavaFileChooser chooser = new JavaFileChooser();
        if (chooser.showDialog(null, "New") != JavaFileChooser.APPROVE_OPTION){
            return;
        }
    }

    public static void openFileAction(FileTabPane pane) {
        JavaFileChooser chooser = new JavaFileChooser();
        if (chooser.showOpenDialog(null) != JavaFileChooser.APPROVE_OPTION) {
            return;
        }

        EditorFile file = new EditorFile(chooser.getSelectedFile());
        pane.addFileTab(file);
    }

    public static void saveFileAction(FileTabPane pane) {
        EditorFile current = pane.getSelectedFile();
        String unsaved = pane.getSelectedTabContents();
        FileIOUtils.writeFile(current.getPath(), unsaved);
    }


}
