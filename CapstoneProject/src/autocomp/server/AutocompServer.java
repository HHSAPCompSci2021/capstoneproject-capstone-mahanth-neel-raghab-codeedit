package autocomp.server;

import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.CompletionOptions;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.WorkDoneProgressCancelParams;
import org.eclipse.lsp4j.InitializedParams;
import org.eclipse.lsp4j.WorkspaceFolder;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutocompServer implements LanguageServer, LanguageClientAware {
    private LanguageClient client;
    private String workSpaceRoot;
    private FullTextDocumentService docService = new FullTextDocumentService();

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        List<WorkspaceFolder> folders = params.getWorkspaceFolders();
        if (folders != null) {
            folders.get(0).getUri();
        }

        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Incremental);
        capabilities.setCodeActionProvider(true);
        capabilities.setCompletionProvider(new CompletionOptions(true, null);

        return CompletableFuture.completedFuture(new InitializeResult(capabilities));
    }

    public void cancelProgress(WorkDoneProgressCancelParams params) {

    }

    public void exit() {
        
    }

    public TextDocumentService getTextDocumentService() {
        return 
    }

    public WorkspaceService getWorkspaceService() {

    }

    public void initialized() {

    }

    void initialize(InitializedParams params) {

    }

    @Override
    public void connect(LanguageClient client) {
        this.client = client;
    }

    public CompletableFuture<Object> shutdown() {
        return CompletableFuture.completedFuture(null);
    }
}
