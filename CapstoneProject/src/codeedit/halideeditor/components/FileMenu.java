package codeedit.halideeditor.components;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class FileMenu extends Menu {

    public static final String NEW_FILE = "New";
    public static final String OPEN_FILE = "Open";
    public static final String SAVE_FILE = "Save";
    public static final String SAVE_FILE_AS = "Save As";
    public static final String CLOSE_FILE = "Close";

    public FileMenu(ActionListener handler) {
        super("File", handler);
        addMenuItem(NEW_FILE);
        addMenuItem(OPEN_FILE);
        addMenuItem(SAVE_FILE);
        addMenuItem(SAVE_FILE_AS);
        addMenuItem(CLOSE_FILE);
    }
    
}
