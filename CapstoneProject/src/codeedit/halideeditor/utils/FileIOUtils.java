package codeedit.halideeditor.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Contains data and functions relating to the reading and writing of files.
 * 
 * @author Neel Sudhakaran
 */
public class FileIOUtils {

    /**
     * The {@code String} that represents a newline within a file.
     */
    public static final String lineSeparator = System.getProperty("line.separator");

    /**
     * The separation {@code String} between folder names in a file path.
     */
    public static final String fileSeparator = System.getProperty("file.separator");

    /**
     * Reads data from the specified file.
     * 
     * @param path the path to the file to read from
     * @return the data contained within the specified file
     */
    public static String readFile(String path) {
        StringBuffer data = new StringBuffer();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int ch;
            while ((ch = reader.read()) != -1) {
                data.append((char) ch);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

    /**
     * Writes data to the specified file.
     * 
     * @param path the path to the file to write to
     * @param data the data to be written to the file
     */
    public static void writeFile(String path, String data) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(); // TODO: Error handling
        }
    }
}
