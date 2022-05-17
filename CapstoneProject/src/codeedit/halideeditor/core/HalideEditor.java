package codeedit.halideeditor.core;

import javax.swing.JFrame;

import codeedit.halideeditor.utils.NativeOSUtils;

public class HalideEditor {
    
    public static void main(String[] args) {
        if(NativeOSUtils.isMac()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); // TODO: Here or in EditorWindow?
        }

        // Initialize the custom dracula theme for editor
        EditorWindow.initLookAndFeel();
        JFrame.setDefaultLookAndFeelDecorated(true);

        EditorWindow editor = new EditorWindow();
        editor.setSize(800, 600); // TODO: Here or in EditorWindow?
        editor.setVisible(true);
    }

}
