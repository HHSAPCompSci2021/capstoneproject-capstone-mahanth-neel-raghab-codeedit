package codeedit.halideeditor.core;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JFrame;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageServer;

import autocomp.server.Server;
import codeedit.halideeditor.utils.NativeOSUtils;

public class HalideEditor {
    
    public static void main(String[] args) {
        if(NativeOSUtils.isMac()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true"); // TODO: Here or in EditorWindow?
        }
//        PipedInputStream inputstream = new PipedInputStream();
//        PipedOutputStream outputstream = new PipedOutputStream();
//        LanguageServer server = new Server() ;
//        Launcher<LanguageClient> launcher = 
//            LSPLauncher.createServerLauncher(server,
//                                             inputstream, 
//                                             outputstream);
        // Initialize the custom dracula theme for editor
        EditorWindow.initLookAndFeel();
        JFrame.setDefaultLookAndFeelDecorated(true);

        EditorWindow editor = new EditorWindow();
        editor.setSize(800, 600); // TODO: Here or in EditorWindow?
        editor.setVisible(true);
    }
}
