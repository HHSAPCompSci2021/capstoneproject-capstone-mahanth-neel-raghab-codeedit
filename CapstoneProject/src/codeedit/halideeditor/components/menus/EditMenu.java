package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;
import java.util.Map;

import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Represents the application {@code EditMenu}.
 * @author Neel Sudhakaran
 */
public class EditMenu extends Menu {
    
    /**
     * Symbolic constant for performing a "cut" text action.
     */
    public static final String CUT = "Cut";

    /**
     * Symbolic constant for performing a "copy" text action.
     */
    public static final String COPY = "Copy";

    /**
     * Symbolic constant for performing a "paste" text action.
     */
    public static final String PASTE = "Paste";

    /**
     * Symbolic constant for performing a "undo" text action.
     */
    public static final String UNDO = "Undo";

    /**
     * Symbolic constant for performing a "redo" text action.
     */
    public static final String REDO = "Redo";

    /**
     * Creates a new {@code EditMenu} with the specified handler.
     * @param handler the handler for all menu actions
     */
    public EditMenu(ActionListener handler, Map<String, JMenuItem> m) {
        super("Edit", handler);
        m.put(CUT, addMenuItem(CUT, KeyStroke.getKeyStroke('X', ACTION_KEY)));
        m.put(COPY, addMenuItem(COPY, KeyStroke.getKeyStroke('C', ACTION_KEY)));
        m.put(PASTE, addMenuItem(PASTE, KeyStroke.getKeyStroke('V', ACTION_KEY)));
        addMenuSeparator();
        m.put(UNDO, addMenuItem(UNDO, KeyStroke.getKeyStroke('Z', ACTION_KEY)));
        m.put(REDO, addMenuItem(REDO, KeyStroke.getKeyStroke('Z',  ACTION_KEY | SHIFT_DOWN_MASK)));
    }

}
