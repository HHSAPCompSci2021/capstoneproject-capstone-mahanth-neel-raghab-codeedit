package codeedit.halideeditor.components;

import javax.swing.JTabbedPane;

import java.util.ArrayList;

public class FileTabPane extends JTabbedPane {

    private ArrayList<String> activeFiles;
    
    public FileTabPane() {
        activeFiles = new ArrayList<>();
    }

    public void addFileTab(String filename, String data) {
        if(activeFiles.contains(filename)) return; // TODO: Error Handle
        JavaCodeEditor editor = new JavaCodeEditor();
        editor.setText(data);
        addTab(filename, new FileIcon(), editor);
        activeFiles.add(filename);
    }

    public void removeFileTab(String filename) {
        int removalIndex = activeFiles.indexOf(filename);
        removeTabAt(removalIndex);
        activeFiles.remove(removalIndex);
    }

}
