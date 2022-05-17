package codeedit.halideeditor.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.ui.FlatMenuUI;;

public abstract class Menu extends JMenu {

    private ActionListener handler;

    public Menu(String name, ActionListener handler) {
        super(name);
        setUI(new FlatMenuUI());
        this.handler = handler;
    }

    public void addMenuItem(String name) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(handler);
        add(item);
    }
}
