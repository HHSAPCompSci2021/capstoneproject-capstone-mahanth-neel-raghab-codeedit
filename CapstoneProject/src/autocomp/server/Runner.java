package autocomp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;

public class Runner {
    public static final String PORT = "8888";

    try {
        Socket sock = new Socket("localhost", Integer.parseInt(PORT));
        InputStream is = sock.getInputStream();
        OutputStream os = sock.getOutputStream();

        LangServer lsp = new LangServer();
        
    }
}
