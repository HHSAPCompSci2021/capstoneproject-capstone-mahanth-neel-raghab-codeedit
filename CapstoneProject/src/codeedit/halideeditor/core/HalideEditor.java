package codeedit.halideeditor.core;

import codeedit.halideeditor.utils.NativeOSUtils;

public class HalideEditor {
    
    public static void main(String[] args) {
        if(NativeOSUtils.isMac()) System.setProperty("apple.laf.useScreenMenuBar", "true"); // TODO: Here or in EditorWindow?
        EditorWindow editor = new EditorWindow();
        editor.setSize(800, 600); // TODO: Here or in EditorWindow?
        editor.setVisible(true);
    }

}
