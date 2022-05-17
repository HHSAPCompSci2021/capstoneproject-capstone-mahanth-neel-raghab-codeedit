package codeedit.halideeditor.components;

import java.awt.event.ActionListener;

public class EditMenu extends Menu {

    public static final String CUT = "Cut";
    public static final String COPY = "Copy";
    public static final String PASTE = "Paste";
    public static final String UNDO = "Undo";
    public static final String REDO = "Redo";

    public EditMenu(ActionListener handler) {
        super("Edit", handler);
        addMenuItem(CUT);
        addMenuItem(COPY);
        addMenuItem(PASTE);
        addMenuItem(UNDO);
        addMenuItem(REDO);
    }
}
