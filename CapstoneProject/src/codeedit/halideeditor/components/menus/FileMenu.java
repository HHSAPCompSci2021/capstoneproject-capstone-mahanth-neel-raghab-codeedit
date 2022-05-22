package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;

import javax.swing.KeyStroke;

import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;

/**
 * Represents the application {@code FileMenu}.
 * @author Neel Sudhakaran
 */
public class FileMenu extends Menu {

    /**
     * Symbolic constant for the action of creating a new file.
     */
    public static final String NEW_FILE = "New";

    /**
     * Symbolic constant for the action of opening a file.
     */
    public static final String OPEN_FILE = "Open";

    /**
     * Symbolic constant for the action of opening a file.
     */
    public static final String SAVE_FILE = "Save";

    /**
     * Symbolic constant for the action of saving the current file.
     */
    public static final String SAVE_FILE_AS = "Save As";

    /**
     * Symbolic constant for the action of saving all files.
     */
   public static final String AUTOCOMPLETE = "Autocomplete";
    
    /**
     * Symbolic constant for the action of closing the current file.
     */
    public static final String CLOSE_FILE = "Close";

    /**
     * Symbolic constant for the action of closing all open files.
     */
    public static final String CLOSE_ALL_FILES = "Close All";

    /**
     * Creates a new {@code FileMenu} with the specified handler.
     * @param handler the handler for all menu actions
     */
    public FileMenu(ActionListener handler) {
        super("File", handler);
        addMenuItem(NEW_FILE, KeyStroke.getKeyStroke('N', ACTION_KEY));
        addMenuItem(OPEN_FILE, KeyStroke.getKeyStroke('O', ACTION_KEY));
        addMenuSeparator();
        addMenuItem(SAVE_FILE, KeyStroke.getKeyStroke('S', ACTION_KEY));
        addMenuItem(SAVE_FILE_AS, KeyStroke.getKeyStroke('S', ACTION_KEY | SHIFT_DOWN_MASK));
        addMenuItem(AUTOCOMPLETE, KeyStroke.getKeyStroke(' ', ACTION_KEY));
        addMenuSeparator();
        addMenuItem(CLOSE_FILE, KeyStroke.getKeyStroke('W', ACTION_KEY));
        addMenuItem(CLOSE_ALL_FILES, KeyStroke.getKeyStroke('W', ACTION_KEY | SHIFT_DOWN_MASK));
        addMenuSeparator();
        addSubMenu(new FileRevealMenu(handler));
    }

}
