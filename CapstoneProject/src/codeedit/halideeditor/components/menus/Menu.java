package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 * Represents a {@code Menu} of various actions or other submenus.
 * @author Neel Sudhakaran
 */
public abstract class Menu extends JMenu {

    /**
     * The handler for the various menu actions.
     */
    private ActionListener handler;

    /**
     * Creates a new {@code Menu} with the given name and action handler
     * @param name the name of the menu to be displayed
     * @param handler the handler for all menu actions
     */
    protected Menu(String name, ActionListener handler) {
        super(name);
        this.handler = handler;
    }

    /**
     * Adds a new menu item with the specified name and key binding.
     * @param name the name of the menu item
     * @param keyBinding the key binding for the corresponding menu item's action
     */
    public JMenuItem addMenuItem(String name, KeyStroke keyBinding) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(handler);

        if (keyBinding != null) item.setAccelerator(keyBinding);

        add(item);
        return item;
    }
    
    /**
     * Adds a new menu item with the specified name and no key binding.
     * @param name the name of the menu item
     */
    public JMenuItem addMenuItem(String name) {
        return addMenuItem(name, null);
    }

    /**
     * Adds a separation line within the {@code Menu}.
     */
    public void addMenuSeparator() {
        add(new JSeparator());
    }

    /**
     * Adds a submenu to the {@code Menu}.
     * @param menu the submenu
     */
    public void addSubMenu(Menu menu) {
        add(menu);
    }

}
