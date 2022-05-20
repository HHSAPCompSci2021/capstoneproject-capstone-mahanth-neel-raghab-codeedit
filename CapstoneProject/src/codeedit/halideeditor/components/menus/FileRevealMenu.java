package codeedit.halideeditor.components.menus;

import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;

import java.awt.event.ActionListener;

import javax.swing.KeyStroke;

/**
 * Represents the "reveal" submenu within the {@code FileMenu}.
 * @author Neel Sudhakaran
 */
public class FileRevealMenu extends Menu {

    /**
     * Symbolic constant for the action of revealing a file in the native file explorer.
     */
    public static final String REVEAL_IN_EXPLORER = "In File Explorer";
   
    /**
     * Symbolic constant for the action of revealing a file in the default editor.
     */
    public static final String REVEAL_IN_EDITOR = "In Default Editor";

    /**
     * Creates a new {@code FileRevealMenu} with the specified action handler.
     * @param handler the handler for all menu actions
     */
    public FileRevealMenu(ActionListener handler) {
        super("Reveal", handler);
        addMenuItem(REVEAL_IN_EXPLORER, KeyStroke.getKeyStroke('F', ACTION_KEY));
        addMenuItem(REVEAL_IN_EDITOR, KeyStroke.getKeyStroke('E', ACTION_KEY));
    }

}
