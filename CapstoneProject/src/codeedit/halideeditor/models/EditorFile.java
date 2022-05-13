package codeedit.halideeditor.models;

import java.io.File;

public class EditorFile {

    private String path;
    // private boolean isSaved;
   
    public EditorFile(String path) {
        this.path = path;
    }

    public EditorFile(File file) {
        this(file.getPath());
    }

    public String getName() {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object other) {
        if(other.getClass() != this.getClass()) return false;
        EditorFile otherFile = (EditorFile) other;
        return (otherFile.path.equals(this.path));
    }

}
