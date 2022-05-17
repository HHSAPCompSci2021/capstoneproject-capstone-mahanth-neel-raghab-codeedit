package autocomp.server;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;

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
        
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {
        String docUri = params.getTextDocument().getUri();
        docs.remove(docUri);
    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        params.setText(params.getText());
    }

    @Override
    public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {
        return TextDocumentService.super.formatting(params);
    }

    @Override
    public CompletableFuture<List<? extends CodeLens>> codeLens(CodeLensParams params) {
        // TODO Auto-generated method stub
        return TextDocumentService.super.codeLens(params);
    }
}
