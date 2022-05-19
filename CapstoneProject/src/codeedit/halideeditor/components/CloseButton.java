package codeedit.halideeditor.components;

import javax.swing.JButton;
import com.formdev.flatlaf.ui.FlatButtonUI;

public class CloseButton extends JButton {
    public CloseButton() {
        super("\u2715");
        setUI(new FlatButtonUI());
    }
    
}
