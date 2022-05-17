package codeedit.halideeditor.core;

import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaFileChooser;
import java.io.File;
import codeedit.halideeditor.models.EditorFile;

public class EditorActions {
    public static void newFileAction(FileTabPane pane) {
        JavaFileChooser chooser = new JavaFileChooser();
        if (chooser.showDialog(null, "New") != JavaFileChooser.APPROVE_OPTION){
            return;
        }

        File file = chooser.getSelectedFile();
        pane.addFileTab(new EditorFile(file));
    }

    public static void openFileAction(FileTabPane pane) {
        JavaFileChooser chooser = new JavaFileChooser();
        if (chooser.showOpenDialog(null) != JavaFileChooser.APPROVE_OPTION) {
            return;
        }

        EditorFile file = new EditorFile(chooser.getSelectedFile());
        pane.addFileTab(file);
    }

    
}
