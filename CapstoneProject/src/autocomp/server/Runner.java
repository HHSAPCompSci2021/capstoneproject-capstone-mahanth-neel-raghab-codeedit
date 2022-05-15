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

    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", Integer.parseInt(PORT));
            InputStream incoming = sock.getInputStream();
            OutputStream sending = sock.getOutputStream();
            
            LangServer lspServer = new LangServer();
            Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(lspServer, incoming, sending);

            LanguageClient client = launcher.getRemoteProxy();
            lspServer.connect(client);

            launcher.startListening();
        } catch (IOException ie) {
            ie.printStackTrace();
        }        
    }
}
