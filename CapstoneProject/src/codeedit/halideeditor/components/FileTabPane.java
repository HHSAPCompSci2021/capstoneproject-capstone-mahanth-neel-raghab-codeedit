package codeedit.halideeditor.components;

import javax.swing.JTabbedPane;
import java.awt.Component;

import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.FileIOUtils;
import com.formdev.flatlaf.ui.FlatTabbedPaneUI;

import java.util.ArrayList;

public class FileTabPane extends JTabbedPane {

    private ArrayList<EditorFile> activeFiles;
    
    public FileTabPane() {
        activeFiles = new ArrayList<>();
        setUI(new FlatTabbedPaneUI());
    }

    public void addFileTab(EditorFile file) {
        if(activeFiles.contains(file)) return; // TODO: Error Handle
        JavaCodeEditor editor = new JavaCodeEditor();
        editor.setText(FileIOUtils.readFile(file.getPath()));
        addTab(file.getName(), new FileIcon(), editor);
       
        activeFiles.add(file);
    }

    public void removeFileTab(EditorFile file) {
        int removalIndex = activeFiles.indexOf(file);
        removeTabAt(removalIndex);
        activeFiles.remove(removalIndex);
    }

    public EditorFile getSelectedFile() {
        int idx = getSelectedIndex();
        return activeFiles.get(idx);
    }

    public Component getSelectedTab() {
        return getTabComponentAt(getSelectedIndex());
    }
}
