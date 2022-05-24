package codeedit.halideeditor.components;

import javax.swing.JOptionPane;

/**
 * Defines a {@code ErrorDialog} for the application.
 */
public class ErrorDialog extends JOptionPane {
    
    /**
     * Creates a new {@code ErrorDialog} with the specified message.
     * @param message the message to use
     */
    public ErrorDialog(String message) {
        showMessageDialog(null, message, "Error", ERROR_MESSAGE);
    }

}
