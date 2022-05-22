package codeedit.halideeditor.core;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import codeedit.halideeditor.components.ErrorDialog;
import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.components.JavaFileChooser;
import codeedit.halideeditor.components.MenuBar;
import codeedit.halideeditor.utils.CodeSuggestion;
import codeedit.halideeditor.utils.CompletionGiver;
import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.NativeOSUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import static codeedit.halideeditor.components.menus.FileMenu.*;
import static codeedit.halideeditor.components.menus.FileRevealMenu.*;
import static codeedit.halideeditor.components.menus.NavigateMenu.*;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * Composes the layout of the {@code EditorWindow} and handles all application actions.
 * @author Neel Sudhakaran, Mahanth Mohan
 */
public class EditorWindow extends JFrame implements ActionListener {

    /**
     * The {@code FileTabPane} managing all files for the {@code EditorWindow}.
     */
    private FileTabPane fileTabPane;
    private JTextArea suggestionBox;
    private JScrollPane scrollSuggestions;
    private CompletionGiver giver;

    /**
     * Creates a new {@code EditorWindow} with the standard layout.
     */
    public EditorWindow() {
        super("HalideEditor");
        if (!NativeOSUtils.isMac()) setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(new MenuBar(this));
        this.setLayout(new BorderLayout());
        fileTabPane = new FileTabPane();
        add(fileTabPane);
        suggestionBox = new JTextArea();
        suggestionBox.setEditable(false);
        scrollSuggestions = new JScrollPane(suggestionBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollSuggestions.setPreferredSize(new Dimension(500,100));
        scrollSuggestions.setVisible(false);
        add(scrollSuggestions, BorderLayout.SOUTH);
        giver = new CompletionGiver();
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            switch (event.getActionCommand()) {
                case NEW_FILE: {
                    EditorFile file = new JavaFileChooser().newAction();

                    if(file == null) return; // TODO: Do as Error Handle?
                    fileTabPane.openFile(file);
                    scrollSuggestions.setVisible(true);
                    break;
                }

                case OPEN_FILE: {
                    EditorFile file = new JavaFileChooser().openAction();

                    if(file == null) return; // TODO: Do as Error Handle?
                    fileTabPane.openFile(file);
                    scrollSuggestions.setVisible(true);
                    break;
                }

                case SAVE_FILE: {
                    JavaCodeEditor editor = fileTabPane.getCurrentEditor();
                    EditorFile file = fileTabPane.getCurrentFile();
                    file.write(editor.getText());
                    break;
                }
                case SAVE_FILE_AS: {
                    EditorFile file = new JavaFileChooser().saveAction();

                    if(file == null) return; // TODO: Do as Error Handle?

                    JavaCodeEditor editor = fileTabPane.getCurrentEditor();
                    file.write(editor.getText());
                    break;
                }
                case AUTOCOMPLETE: {
                	CodeSuggestion[] c = giver.getSuggestions(fileTabPane.getCurrentEditor());
                	StringBuffer s = new StringBuffer();
                	for (int i = 0; i< c.length; i++) {
                		s.append(c[i]+"\n");
                	}
                	s.delete(s.length()-1, s.length());
                	suggestionBox.setText(s.toString());
                	break;
                }

                case CLOSE_FILE: {
                    fileTabPane.closeFile(fileTabPane.getCurrentFile());
                    break;
                }
                case CLOSE_ALL_FILES: {
                    fileTabPane.removeAll();
                    break;
                }

                case REVEAL_IN_EXPLORER: {
                    EditorFile file = fileTabPane.getCurrentFile();
                    Desktop.getDesktop().open(new File(file.getParentDirectory()));
                    break;
                }

                case REVEAL_IN_EDITOR: {
                    EditorFile file = fileTabPane.getCurrentFile();
                    Desktop.getDesktop().open(file.toFile());
                    break;
                }

                case SWITCH_TO_FIRST_TAB: {
                    fileTabPane.switchToTab(0);
                    break;
                }

                case SWITCH_TO_LAST_TAB: {
                    fileTabPane.switchToTab(fileTabPane.getTabCount() - 1);
                    break;
                }

                case SWITCH_TO_SECOND_TAB:{
                    fileTabPane.switchToTab(1);
                    break;
                }

                case SWITCH_TO_THIRD_TAB: {
                    fileTabPane.switchToTab(2);
                    break;
                }

                case SWITCH_TO_FOURTH_TAB: {
                    fileTabPane.switchToTab(3);
                    break;
                }

                case SWITCH_TO_FIFTH_TAB: {
                    fileTabPane.switchToTab(4);
                    break;
                }

                case SWITCH_TO_SIXTH_TAB: {
                    fileTabPane.switchToTab(5);
                    break;
                }

                case SWITCH_TO_SEVENTH_TAB: {
                    fileTabPane.switchToTab(6);
                    break;
                }

                case SWITCH_TO_EIGHTH_TAB: {
                    fileTabPane.switchToTab(7);
                    break;
                }

            }
        } catch(Exception e) {
            new ErrorDialog(e.getMessage());
        }
    }
    
}
