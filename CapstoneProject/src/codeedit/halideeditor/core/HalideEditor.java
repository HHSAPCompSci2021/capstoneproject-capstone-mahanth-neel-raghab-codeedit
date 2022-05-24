package codeedit.halideeditor.core;

import static codeedit.halideeditor.utils.NativeOSUtils.isMac;

/**
 * Defines the {@code HalideEditor} application.
 * @author Neel Sudhakaran
 */
public class HalideEditor {
    
    /**
     * Serves as the main entry-point for the application.
     * @param args command-line arguments for the interpreter
     */
    public static void main(String[] args) { 

        if(isMac()) System.setProperty("apple.laf.useScreenMenuBar", "true"); // TODO: Here or in EditorWindow?
        
        EditorWindow editor = new EditorWindow();
        editor.setSize(800, 600);
        editor.setVisible(true);
    }
}
