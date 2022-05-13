package codeedit.halideeditor.models;

import java.io.File;

public class EditorFile {

    private String name;
    private String path;
    // private boolean isSaved;
   
    public EditorFile(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public EditorFile(File file) {
        this(file.getName(), file.getPath());
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
