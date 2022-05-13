package autocomp.server;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.CodeLens;
import java.util.concurrent.CompletableFuture;

public class LangServer implements LanguageServer, LanguageClientAware {
    private LanguageClient client;

    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {

    }

    public void cancelProgress(WorkDoneProgressCancelParams params) {

    }

    public void exit() {
        
    }

    public TextDocumentService getTextDocumentService() {

    }

    public WorkspaceService getWorkspaceService() {

    }

    void initialized() {

    }

    void initialize(InitializedParams params) {

    }

    CompletableFuture<Object> shutdown() {

    }
}
