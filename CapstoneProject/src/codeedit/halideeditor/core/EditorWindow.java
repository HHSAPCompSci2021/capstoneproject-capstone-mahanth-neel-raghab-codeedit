package codeedit.halideeditor.core;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import codeedit.halideeditor.components.EditMenu;
import codeedit.halideeditor.components.FileMenu;
import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.components.JavaFileChooser;
import codeedit.halideeditor.components.MenuBar;
import codeedit.halideeditor.core.logic.SnippetSorter;
import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.FileIOUtils;
import codeedit.halideeditor.utils.NativeOSUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.plaf.synth.SynthLookAndFeel;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;

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

    public static void initLookAndFeel() {
        // String rootPath = System.getProperty("user.dir");
        // String sep = System.getProperty("file.separator");
        SynthLookAndFeel theme = new SynthLookAndFeel();
        FlatDraculaIJTheme.install(theme);

        try {
            UIManager.setLookAndFeel(new FlatDraculaIJTheme());
        } catch (Exception e) {
            System.err.println("Could not set editor theme");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {

            case FileMenu.NEW_FILE: {
                EditorActions.newFileAction(fileTabPane);
                break;
            }

            case FileMenu.OPEN_FILE: {
                EditorActions.openFileAction(fileTabPane);
                break;
            }

            case FileMenu.CLOSE_FILE: {
                EditorFile current = fileTabPane.getSelectedFile();
                fileTabPane.removeFileTab(current);
                break;
            }

            case FileMenu.SAVE_FILE: {
                
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
            	// SnippetSorter s = new SnippetSorter();
            	// Component currentTab = fileTabPane.getSelectedTab();
            	// if (currentTab instanceof JavaCodeEditor) {
                //     s.fill((JavaCodeEditor)currentTab);
                // }
            	// s.sortResults();
                // break;
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

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
