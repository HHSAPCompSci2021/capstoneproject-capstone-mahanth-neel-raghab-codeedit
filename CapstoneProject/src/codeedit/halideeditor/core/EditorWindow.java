package codeedit.halideeditor.core;

import javax.swing.JFrame;
import codeedit.halideeditor.components.EditMenu;
import codeedit.halideeditor.components.FileMenu;
import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.components.JavaFileChooser;
import codeedit.halideeditor.components.MenuBar;
import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.FileIOUtils;
import codeedit.halideeditor.utils.NativeOSUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Component;

public class EditorWindow extends JFrame implements ActionListener, KeyListener {

    private MenuBar menuBar;
    private FileTabPane fileTabPane;
    
    public EditorWindow() {
        super("Halide Editor");
        menuBar = new MenuBar(this);
        fileTabPane = new FileTabPane();

        setJMenuBar(menuBar);
        add(fileTabPane);
        if (!NativeOSUtils.isMac()) setDefaultCloseOperation(EXIT_ON_CLOSE); // TODO: Move to HalideEditor?  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {

            case FileMenu.NEW_FILE: {
                JavaFileChooser chooser = new JavaFileChooser();
                if (chooser.showDialog(null, "New") != JavaFileChooser.APPROVE_OPTION) return;
                File file = chooser.getSelectedFile();
                fileTabPane.addFileTab(new EditorFile(file));
                break;
            }

            case FileMenu.OPEN_FILE: {
                JavaFileChooser chooser = new JavaFileChooser();
                if (chooser.showOpenDialog(null) != JavaFileChooser.APPROVE_OPTION) {
                    return;
                }

                EditorFile file = new EditorFile(chooser.getSelectedFile());
                fileTabPane.addFileTab(file);
                break;
            }

            case FileMenu.CLOSE_FILE: {
                EditorFile current = fileTabPane.getSelectedFile();
                fileTabPane.removeFileTab(current);
                break;
            }

            case FileMenu.SAVE_FILE: {
                EditorFile current = fileTabPane.getSelectedFile();
                String savedContents = FileIOUtils.readFile(current.getPath());
                FileIOUtils.writeFile(current.getPath(), savedContents);
                break;
            }

            case FileMenu.SAVE_FILE_AS: {
                JavaFileChooser chooser = new JavaFileChooser();
                if (chooser.showSaveDialog(null) != JavaFileChooser.APPROVE_OPTION) {
                    return;
                }

                File target = chooser.getSelectedFile();
                Component currentTab = fileTabPane.getSelectedTab();
                JavaCodeEditor codeWindow = null;
                if (currentTab instanceof JavaCodeEditor) {
                    codeWindow = (JavaCodeEditor) codeWindow;
                }

                FileIOUtils.writeFile(target.getPath(), codeWindow.getText());
                break;
            }

            case EditMenu.CUT: {
                break;
            }
            case EditMenu.COPY: {
                break;
            }
            case EditMenu.PASTE: {
                break;
            }
            case EditMenu.UNDO: {
                break;
            }
            case EditMenu.REDO: {
                break;
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S: {
                
                break;
            }

            default:
                break;
        }
    }
}
