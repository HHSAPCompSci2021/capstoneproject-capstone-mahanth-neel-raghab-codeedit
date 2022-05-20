package codeedit.halideeditor.components;

import javax.swing.JMenuBar;

import codeedit.halideeditor.components.menus.EditMenu;
import codeedit.halideeditor.components.menus.FileMenu;
import codeedit.halideeditor.components.menus.NavigateMenu;

import java.awt.event.ActionListener;

/**
 * Defines a {@code MenuBar} composed of various different menus.
 * @author Neel Sudhakaran
 */
public class MenuBar extends JMenuBar {

    /**
     * Creates a {@code MenuBar} with the given action handler.
     * @param handler the handler for all menu actions
     */
    public MenuBar(ActionListener handler) {
        add(new FileMenu(handler));
        add(new EditMenu(handler));
        add(new NavigateMenu(handler));
    }

}
