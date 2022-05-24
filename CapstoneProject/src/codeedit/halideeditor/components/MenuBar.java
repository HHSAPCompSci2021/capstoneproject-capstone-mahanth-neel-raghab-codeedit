package codeedit.halideeditor.components;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import codeedit.halideeditor.components.menus.EditMenu;
import codeedit.halideeditor.components.menus.FileMenu;
import codeedit.halideeditor.components.menus.NavigateMenu;
import codeedit.halideeditor.components.menus.SettingsMenu;

import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Defines a {@code MenuBar} composed of various different menus.
 * @author Neel Sudhakaran
 */
public class MenuBar extends JMenuBar {
    
    /**
     * Creates a {@code MenuBar} with the given action handler.
     * @param handler the handler for all menu actions
     */
    public MenuBar(ActionListener handler, Map<String, JMenuItem> m) {
        add(new FileMenu(handler, m));
        add(new EditMenu(handler, m));
        add(new NavigateMenu(handler));
        add(new SettingsMenu(handler));
    }
}
