package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;

import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
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
    public EditMenu(ActionListener handler) {
        super("Edit", handler);
        addMenuItem(CUT, KeyStroke.getKeyStroke('X', ACTION_KEY));
        addMenuItem(COPY, KeyStroke.getKeyStroke('C', ACTION_KEY));
        addMenuItem(PASTE, KeyStroke.getKeyStroke('V', ACTION_KEY));
        addMenuSeparator();
        addMenuItem(UNDO, KeyStroke.getKeyStroke('Z', ACTION_KEY));
        addMenuItem(REDO, KeyStroke.getKeyStroke('Z',  ACTION_KEY | SHIFT_DOWN_MASK));
    }

}
