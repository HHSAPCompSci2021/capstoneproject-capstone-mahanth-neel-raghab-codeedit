package codeedit.halideeditor.components;

import javax.swing.JMenuBar;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    
    public MenuBar(ActionListener handler) {
        add(new FileMenu(handler));
        add(new EditMenu(handler));
    }
    
}
