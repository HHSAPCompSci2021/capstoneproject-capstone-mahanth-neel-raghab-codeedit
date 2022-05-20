package codeedit.halideeditor.models;

import java.io.File;

import codeedit.halideeditor.utils.FileIOUtils;

/**
 * Represents an {@code EditorFile} in the application.
 * @author Neel Sudhakaran
 */
public class EditorFile {

    /**
     * The path to the {@code EditorFile}.
     */
    private String path;
    // private boolean isSaved;
   
    /**
     * Creates a new {@code EditorFile} with the specified path.
     * @param path the path of the file
     */
    public EditorFile(String path) {
        this.path = path;
    }

    /**
     * Creates a new {@code EditorFile} from the given {@code File}.
     * @param file the {@code File} to use
     */
    public EditorFile(File file) {
        this(file.getPath());
    }

    /**
     * Gets the name of the {@code EditorFile}.
     * @return the name of the file
     */
    public String getName() {
        return path.substring(path.lastIndexOf(FileIOUtils.fileSeparator) + 1);
    }

    /**
     * Gets the path to the {@code EditorFile}.
     * @return the path to the file
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Gets the extension of the {@code EditorFile}.
     * @return the extension of the file
     */
    public String getExtension() {
        return getName().substring(getName().lastIndexOf(".") + 1);
    }

    /**
     * Gets the parent directory of the {@code EditorFile}.
     * @return the parent directory of the file
     */
    public String getParentDirectory() {
        return path.substring(0, path.lastIndexOf(FileIOUtils.fileSeparator) + 1);
    }

    /**
     * Reads the contents of the {@code EditorFile}.
     * @return the contents of the file
     */
    public String read() {
        return FileIOUtils.readFile(path);
    }

    /**
     * Writes the specified data to the {@code EditorFile}.
     * @param data the data to write to the file
     */
    public void write(String data) {
        FileIOUtils.writeFile(path, data);
    }

    @Override
    public boolean equals(Object other) {
        if(other.getClass() != this.getClass()) return false;
        EditorFile otherFile = (EditorFile) other;
        return (otherFile.path.equals(this.path));
    }

    /**
     * Converts the {@code EditorFile} to a {@code File}.
     * @return the {@code File} representation of the {@code EditorFile}
     */
    public File toFile() {
        return new File(path);
    }

}