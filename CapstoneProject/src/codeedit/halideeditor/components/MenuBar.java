package codeedit.halideeditor.components;

import javax.swing.JMenuBar;

import java.awt.Color;

import java.awt.event.ActionListener;
import com.formdev.flatlaf.ui.FlatMenuBarUI;

public class MenuBar extends JMenuBar {
    
    public MenuBar(ActionListener handler) {
        setBackground(new Color(62, 62, 62));
        setUI(new FlatMenuBarUI());
        add(new FileMenu(handler));
        add(new EditMenu(handler));
    }
}
