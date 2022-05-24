package codeedit.halideeditor.components;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SugItem extends JMenuItem {
    public static final Color SELECTED = new Color(212, 212, 212); 

    public SugItem(SuggestionDialog dialog, String suggestion) {
        super(suggestion);
        setSize(dialog.getWidth(), getHeight());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color prev = getBackground();
                setBackground(SELECTED);
                dialog.complete(suggestion);
                setBackground(prev);
                getParent().setVisible(false);
            }
        });
    }
}