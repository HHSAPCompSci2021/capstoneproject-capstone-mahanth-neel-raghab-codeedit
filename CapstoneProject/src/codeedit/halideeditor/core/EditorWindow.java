package codeedit.halideeditor.core;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import codeedit.halideeditor.components.ErrorDialog;
import codeedit.halideeditor.components.FileTabPane;
import codeedit.halideeditor.components.JavaCodeEditor;
import codeedit.halideeditor.components.JavaFileChooser;
import codeedit.halideeditor.components.MenuBar;
import codeedit.halideeditor.components.SuggestionDialog;
import codeedit.halideeditor.utils.CodeDict;
import codeedit.halideeditor.utils.CodeSuggestion;
import codeedit.halideeditor.utils.CompletionGiver;
import codeedit.halideeditor.models.EditorFile;
import codeedit.halideeditor.utils.NativeOSUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import static codeedit.halideeditor.components.menus.FileMenu.*;
import static codeedit.halideeditor.components.menus.SettingsMenu.*;
import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;
import static codeedit.halideeditor.components.menus.FileRevealMenu.*;
import static codeedit.halideeditor.components.menus.NavigateMenu.*;

import java.awt.BorderLayout;
import java.awt.Desktop;

/**
 * Composes the layout of the {@code EditorWindow} and handles all application
 * actions.
 * 
 * @author Neel Sudhakaran, Mahanth Mohan
 */
public class EditorWindow extends JFrame implements ActionListener {

    /**
     * The {@code FileTabPane} managing all files for the {@code EditorWindow}.
     */
    private FileTabPane fileTabPane;
    private SuggestionDialog sugsDialog;
    private CompletionGiver giver;
    private HashMap<String, JMenuItem> controls;

    /**
     * Creates a new {@code EditorWindow} with the standard layout.
     */
    public EditorWindow() {
        super("HalideEditor");
        if (!NativeOSUtils.isMac())
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        controls = new HashMap<>();
        setJMenuBar(new MenuBar(this, controls));
        this.setLayout(new BorderLayout());
        fileTabPane = new FileTabPane();
        add(fileTabPane);
        giver = new CompletionGiver();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            switch (event.getActionCommand()) {
                case NEW_FILE: {
                    EditorFile file = new JavaFileChooser().newAction();

                    if (file == null)
                        return; // TODO: Do as Error Handle?
                    fileTabPane.openFile(file);
                    break;
                }

                case OPEN_FILE: {
                    EditorFile file = new JavaFileChooser().openAction();

                    if (file == null)
                        return; // TODO: Do as Error Handle?
                    fileTabPane.openFile(file);
                    break;
                }

                case SAVE_FILE: {
                    JavaCodeEditor editor = fileTabPane.getCurrentEditor();
                    EditorFile file = fileTabPane.getCurrentFile();
                    file.write(editor.getText());
                    System.out.println("update");
                    giver.update(editor);
                    break;
                }

                case SAVE_FILE_AS: {
                    EditorFile file = new JavaFileChooser().saveAction();

                    if (file == null)
                        return; // TODO: Do as Error Handle?

                    JavaCodeEditor editor = fileTabPane.getCurrentEditor();
                    file.write(editor.getText());
                    break;
                }

                case AUTOCOMPLETE: {
                    JavaCodeEditor editor = fileTabPane.getCurrentEditor();
                    if (editor == null) {
                        return;
                    }

                    CodeSuggestion[] sugs = giver.getSuggestions(editor);
                    sugsDialog = new SuggestionDialog(sugs, 5, editor);
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

                case SWITCH_TO_SECOND_TAB: {
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
                case CONTROLS: {
                	String s = (String)JOptionPane.showInputDialog(this,
                            "Which command will be overwritten",
                            "Save");
                	if (controls.containsKey(s)) {
                		String l = (String)JOptionPane.showInputDialog(this,
                                "Enter replacement",
                                "S");
                		if (l.toCharArray().length==1) {
                			controls.get(s).setAccelerator(KeyStroke.getKeyStroke(Character.toUpperCase(l.toCharArray()[0]), ACTION_KEY));
                		}
                		else {
                			JOptionPane.showMessageDialog(this,
                				    "Must be a single letter",
                				    "Inane warning",
                				    JOptionPane.WARNING_MESSAGE);
                		}
                	}
                	else {
                		JOptionPane.showMessageDialog(this,
            				    "Command not found",
            				    "Inane warning",
            				    JOptionPane.WARNING_MESSAGE);
                	}
                	break;
                }
                
                case AUTOCOMPLETES: {
                	String s = (String)JOptionPane.showInputDialog(this,
                            "Enter phrase to be autocompleted",
                            "Custom Autocompletion");
                	CodeDict.SNIPPETS.add(s);
                	giver.update(fileTabPane.getCurrentEditor());
                	break;
                }

            }
        } catch (Exception e) {
            new ErrorDialog(e.getMessage());
        }
    }

}
