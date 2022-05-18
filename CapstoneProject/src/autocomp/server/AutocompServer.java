package autocomp.server;

import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.CodeLensOptions;
import org.eclipse.lsp4j.CompletionOptions;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.WorkDoneProgressCancelParams;
import org.eclipse.lsp4j.InitializedParams;
import org.eclipse.lsp4j.WorkspaceFolder;
import java.util.concurrent.CompletableFuture;
import java.util.List;

public class AutocompServer implements LanguageServer, LanguageClientAware {
    private LanguageClient client;
    private String workSpaceRoot;
    private DocumentService docService = new DocumentService();

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        List<WorkspaceFolder> folders = params.getWorkspaceFolders();
        if (folders != null) {
            folders.get(0).getUri();
        }

        CodeLensOptions lensOptions = new CodeLensOptions();

        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Full);
        capabilities.setCodeActionProvider(true);
        capabilities.setCompletionProvider(new CompletionOptions(true, null));
        capabilities.setCodeLensProvider(lensOptions);
        capabilities.setDefinitionProvider(true);

        return CompletableFuture.completedFuture(new InitializeResult(capabilities));
    }

    public void cancelProgress(WorkDoneProgressCancelParams params) {
    }

    public void exit() {
        
    }

    public TextDocumentService getTextDocumentService() {
        
    }

    public WorkspaceService getWorkspaceService() {

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
