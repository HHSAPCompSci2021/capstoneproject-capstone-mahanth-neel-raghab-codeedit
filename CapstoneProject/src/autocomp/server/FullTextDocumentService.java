package autocomp.server;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;

import java.util.concurrent.CompletableFuture;

public class FullTextDocumentService implements TextDocumentService {
    private Map<String, TextDocumentItem> docs = new HashMap<>();

    @Override
    public void didOpen(DidOpenTextDocumentParams params) {
        TextDocumentItem doc = params.getTextDocument();
        docs.put(doc.getUri(), doc);
    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        String docUri = params.getTextDocument().getUri();
        List<TextDocumentContentChangeEvent> changes = params.getContentChanges();
        for (TextDocumentContentChangeEvent changeEvt : changes) {
            changeEvt.getText()
        }
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CompletableFuture<List<? extends CodeLens>> codeLens(CodeLensParams params) {
        String docUri = params.getTextDocument().getUri();

    }
}
