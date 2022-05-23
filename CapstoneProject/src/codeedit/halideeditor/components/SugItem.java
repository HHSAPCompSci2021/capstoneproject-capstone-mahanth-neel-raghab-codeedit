package codeedit.halideeditor.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JMenuItem;

public class SugItem extends JMenuItem implements ActionListener {
    public SugItem(String suggestion) {
        super(suggestion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component c = getParent();
        if (c instanceof SuggestionDialog) {
            SuggestionDialog dialog = (SuggestionDialog) c;
            dialog.complete(e.getActionCommand());
        } 
    }
}